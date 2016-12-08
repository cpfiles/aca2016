package edu.uca.aca2016.jdbc.cpfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * A class to manipulate the contents of the Chinook SQLite Database
 * 
 * More information about the Chinook database can be found at:
 * https://chinookdatabase.codeplex.com/
 * 
 * @author cfiles
 */
public class ChinookManager{
    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());
    
    /**
     * Creates a connection to an instance of the Chinook database. 
     * 
     * The connection URL is obtained by reading a properties file located on
     * the classpath at resources/config/cpfiles/ChinookManager.properties
     */
    public ChinookManager(){
        try{
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookManager.class.getClassLoader().getResources("config/clintlemons/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();
            
            logger.info("Connecting to database: " + props.getProperty("db.connection"));
            
            // the properties file loaded, attempt to connect using the value of the "db.connection" property
            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("db.connection"));
            }
        }
        catch(FileNotFoundException ex){
            logger.severe("File Not Found: " + ex.getMessage());
        }
        catch(IOException ex){
            logger.severe("IO Exception: " + ex.getMessage());
        }
        catch(SQLException ex){
            logger.severe("SQL Issue: " + ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            logger.severe("Class not found: " + ex.getMessage());
        }
    }
    
    /**
     * Adds an artist to the Artist table of the database. The artist gets the 
     * next id according to the database.
     * 
     * @param name The name of the Artist to add
     */
    public void addArtist(String name) {
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Artist (Name) VALUES(?)");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            logger.severe("Issue adding artist: " + ex.getMessage());
        }
        
        logger.info("Added artist '" + name + "' to the database ");
    }
    
    /**
     * Preforms a case insensitive search by name for a given artist.
     * 
     * @param name The name of the artist to search.
     * @return The database id of the artist if a single result is found; -1 if
     * no result or ambiguous results are found.
     */
    public int getArtist(String name) {
        // default the return value to -1
        int ret = -1;

        try{
            // attempt to find the artist by name. note we use upper() to make it case insensitive
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Artist WHERE UPPER(Name) = UPPER(?)");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            
            // if there is a record, get the artist id to return
            if (rs.next()) {
                ret = rs.getInt("ArtistID");
                logger.info("Search for artist '" + name + "' yielded an ID of " + ret);
            }
            else {
                logger.info("Search for artist '" + name + "' yielded no results");
            }
            
            // if there is a second record we have ambiguous resuts, return -1
            if (rs.next()) {
                ret = -1;
                logger.info("Search for artist yielded ambiguous results, returning -1");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue searching for artist: " + ex.getMessage());
        }

        // send back either an ID or -1 for no or ambiguous results
        return ret;
    }
    
    public String getArtistName(int id) {
        String ret = null;

        try{
            // attempt to find the artist by id
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            // if there is a record, get the artist id to return
            if (rs.next()) {
                ret = rs.getString("Name");
                logger.info("Search by id for artist '" + id + "' yielded an name of " + ret);
            }
            else {
                logger.info("Search for artist '" + id + "' yielded no results");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue searching for artist: " + ex.getMessage());
        }

        // send back null or the name
        return ret;
    }
    
    /**
     * Updates an artist's name by the given id.
     * 
     * @param id The ID of the artist to update.
     * @param name The new name of the artist.
     * @return true when a single record is updated. false if no records or multiple
     * records are updated.
     */
    public boolean updateArtist(int id, String name) {
        boolean ret = false;
        
        try{
            PreparedStatement ps = this.con.prepareStatement("UPDATE Artist SET Name = ? WHERE ArtistID = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int ra = ps.executeUpdate();
            
            if (ra == 1) {
                ret = true;
                logger.info("Updated artist with ID " + id + " set name to '" + name + "'");
            }
            else {
                logger.warning("Update artist with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue updating artist: " + ex.getMessage());
        }
        
        return ret;
    }
    
    /**
     * Deletes an artist by the given id.
     * @param id The ID of the artist to delete.
     * @return true when a single record is deleted. false if no records or multiple
     * records are deleted.
     */
    public boolean deleteArtist(int id) {
        boolean ret = false;
        
        try{
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Artist WHERE ArtistID = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();
            
            if (ra == 1) {
                ret = true;
                logger.info("Deleted artist with ID " + id);
            }
            else {
                logger.warning("Delete artist with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue deleting artist: " + ex.getMessage());
        }
        
        return ret;
    }
    
    public void batchLoadArtist(File csv, int column) {
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Artist (Name) VALUES (?)");
            
            while ((line = br.readLine()) != null) {
                String[] pieces = line.split(",");
                ps.setString(1, pieces[column]);
                ps.addBatch();
                
                logger.info("Adding " + pieces[column] + " to the batch." );
            }
            
            int[] results = ps.executeBatch();
            
            ps.close();
        } 
        catch (IOException ex) {
            logger.severe("IO Exception: " + ex.getMessage());
        }
        catch(SQLException ex){
            logger.severe("SQL Issue: " + ex.getMessage());
        }
    }
    
    public HashMap<Integer, String> getArtists() {
        HashMap<Integer, String> artists = new HashMap<>();
        
        try{
            Statement s = this.con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM Artist");
            
            while (rs.next()) {
                artists.put(rs.getInt("ArtistID"), rs.getString("Name"));
            }
        }
        catch(SQLException ex){
            logger.severe("SQL Issue: " + ex.getMessage());
        }
        
        return artists;
    }
    
    public void close() {
        if (this.con != null) {
            try{
                this.con.close();
            }
            catch(SQLException ex){
                logger.warning(ex.getMessage());
            }
        }
    }
}
