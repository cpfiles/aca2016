/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.ACA1Woodruff;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author awood
 */
public class ChinookGenreManager2 {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager2.class.getName());

    /**
     * Creates a connection to an instance of the Chinook database.
     *
     * The connection URL is obtained by reading a properties file located on
     * the class path at resources/config/awood/ChinookGenreManager.properties
     */
    public ChinookGenreManager2() {
        try {
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager2.class.getClassLoader().getResources("config/ACA1Woodruff/ChinookGenreManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();

            logger.log(Level.INFO, "Connecting to database: {0}", props.getProperty("db.connection"));

            // the properties file loaded, attempt to connect using the value of the "db.connection" property
            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("db.connection"));
            }
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File Not Found: {0}", ex.getMessage());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IO Exception: {0}", ex.getMessage());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Issue: {0}", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Class not found: {0}", ex.getMessage());
        }
    }

    /**
     * Adds a genre to the Genre table of the database. The genre gets the next
     * id according to the database.
     *
     * @param name The name of the Genre to add
     */
    public HashMap<Integer, String> getGenres() {
        HashMap<Integer, String> genres = new HashMap<>();

        try {
            Statement s = this.con.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM Genre");

            while (rs.next()) {
                genres.put(rs.getInt("GenreID"), rs.getString("Name"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Issue: {0}", ex.getMessage());
        }

        return genres;
    }

    public boolean addGenre(String name) {
        boolean ret = false;
        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES(?)");
            ps.setString(1, name);
            int ra = ps.executeUpdate();
            ps.close();
            if (ra == 1) {
                ret = true;
                logger.log(Level.INFO, "added genre {0}", name);
            } else {
                logger.log(Level.INFO, "genre added failed {0}not selected", name);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue adding genre: {0}", ex.getMessage());
//          logger.severe("Issue adding artist: " + ex.getMessage());*/
        }

        logger.log(Level.INFO, "Added genre ''{0}'' to the database ", name);
        return ret;
    }

    /**
     * Performs a case insensitive search by name for a given genre.
     *
     * @param name. The name of the genre to search.
     * @return the database id of the genre, if a single result is found; -1 if
     * no result or ambiguous results are found.
     */
    public String getGenreName(int id) throws SQLException {
        String ret = null;

        try {
            // attempt to find the genre by name. note we use upper() to make it case insensitive
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ret = rs.getString("Name");
                logger.log(Level.INFO, "Search for genre ''{0}'' yielded an ID of {1}", new Object[]{id, ret});
//              logger.info("Search for genre '" + id + "' yielded an ID of " + ret);
            } else {
                logger.log(Level.INFO, "Search for genre ''{0}'' yielded no results", id);
//              logger.info("Search for genre '" + name + "' yielded no results");*/
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue searching for genre: {0}", ex.getMessage());
//          logger.severe("Issue searching for genre: " + ex.getMessage());*/
        }
        return ret;
    }

    /**
     * Updates an artist's name by the given id.
     *
     * @param id The ID of the artist to update.
     * @param name The new name of the artist.
     * @return true when a single record is updated. false if no records or
     * multiple records are updated.
     */
    public boolean updateGenre(int id, String name) {
        boolean ret = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("UPDATE Genre SET Name = ? WHERE GenreID = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.log(Level.INFO, "Updated genre with ID {0} set name to ''{1}''", new Object[]{id, name});
//              logger.info("Updated artist with ID " + id + " set name to '" + name + "'");*/ 
            } else {
                logger.log(Level.WARNING, "Update genre with ID {0} had an undesired result and changed {1} records", new Object[]{id, ra});
//              logger.warning("Update artist with ID " + id + " had an undesired result and changed " + ra + " records");*/ 
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue updating genre: {0}", ex.getMessage());
//          logger.severe("Issue updating artist: " + ex.getMessage());*/  
        }

        return ret;
    }

    /**
     * Deletes an genre by the given id.
     *
     * @param id The ID of the genre to delete.
     * @return true when a single record is deleted. False, if no records or
     * multiple records are deleted.
     */
    public boolean deleteGenre(int id) throws SQLException {
        boolean ret = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreID = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.log(Level.INFO, "Deleted genre with ID {0}", id);
//              logger.info("Deleted artist with ID " + id);*/
            } else {
                logger.log(Level.WARNING, "Delete genre with ID {0} had an undesired result and changed {1} records", new Object[]{id, ra});
//              logger.warning("Delete artist with ID " + id + " had an undesired result and changed " + ra + " records");*/ 
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue deleting genre: {0}", ex.getMessage());
//          logger.severe("Issue deleting artist: " + ex.getMessage());*/ 
        }

        return ret;
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
