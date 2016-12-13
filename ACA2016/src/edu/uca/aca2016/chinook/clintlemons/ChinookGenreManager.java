/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.clintlemons;

import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
import java.util.Enumeration;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Username
 */
public class ChinookGenreManager {
        Connection con = null;
         static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());
    public ChinookGenreManager() {
        try{
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/clintlemons/ChinookManager.properties");
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
     *
     * @param GenreID
     * @param Name
     * @return GenreID and Name 
     */
    public HashMap<Integer, String> getGenres(int GenreID, String Name){
        
        HashMap<Integer, String> Genres = new HashMap<>();
        try{
            Statement s = this.con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM Genre");
            
            while (rs.next()) {
                Genres.put(rs.getInt("GenreID"), rs.getString("Name"));
            }
        }
        catch(SQLException ex){
            logger.log(Level.SEVERE, "SQL Issue: {0}", ex.getMessage());
        }
        return Genres;
    }
        public boolean addGenre(String name) {
            boolean ret = false;
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES(?)");
            ps.setString(1,name);
            int ra = ps.executeUpdate();
            if (ra == 1) {
                ret = true;
                logger.info("Added genre '" + name + "' to the database ");
                ps.close();
            }
            else{
                ps.close();
            }
            
        }
        catch(SQLException ex){
            logger.severe("Issue updating genre: " + ex.getMessage());
        } 
        return ret;
    }
        public String getGenreName(int id) {
        String ret = null;

        try{
            // attempt to find the genre by id
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            // if there is a record, get the genre id to return
            if (rs.next()) {
                ret = rs.getString("Name");
                logger.info("Search by id for genre '" + id + "' yielded an name of " + ret);
            }
            else {
                logger.info("Search for genre '" + id + "' yielded no results");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue searching for genre: " + ex.getMessage());
        }

        // send back null or the name
        return ret;
    }
        public boolean updateGenre(int id, String name) {
        boolean ret = false;
        
        try{
            PreparedStatement ps = this.con.prepareStatement("UPDATE Genre SET Name = ? WHERE GenreId = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int ra = ps.executeUpdate();
            
            if (ra == 1) {
                ret = true;
                logger.info("Updated genre with ID " + id + " set name to '" + name + "'");
            }
            else {
                logger.warning("Update genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue updating genre: " + ex.getMessage());
        }
        
        return ret;
    }
            
        public boolean deleteGenre(int id) {
        boolean ret = false;
        
        try{
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();
            
            if (ra == 1) {
                ret = true;
                logger.info("Deleted genre with ID " + id);
            }
            else {
                logger.warning("Delete genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        }
        catch(SQLException ex){
            logger.severe("Issue deleting genre: " + ex.getMessage());
        }
        
        return ret;
    }
}
