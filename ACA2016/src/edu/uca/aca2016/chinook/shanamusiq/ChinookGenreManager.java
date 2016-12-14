/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.shanamusiq;

import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
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
 * @author Shana
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());

    /**
     * Creates a connection to an instance of the Chinook database.
     *
     * The connection URL is obtained by reading a properties file located on
     *
     */
    public ChinookGenreManager() {
        try {
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookManager.class.getClassLoader().getResources("config/shanamusiq/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();

            logger.info("Connecting to database: " + props.getProperty("ChinookDatabase.connection"));

            // the properties file loaded, attempt to connect using the value of the "ChinookDatabase" property
            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("ChinookDatabase.connection"));
            }
        } catch (FileNotFoundException ex) {
            logger.severe("File Not Found: " + ex.getMessage());
        } catch (IOException ex) {
            logger.severe("IO Exception: " + ex.getMessage());
        } catch (SQLException ex) {
            logger.severe("SQL Issue: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            logger.severe("Class not found: " + ex.getMessage());
        }
    }

    public HashMap<Integer, String> getGenres() {
        HashMap<Integer, String> genre = new HashMap<>();

        try {
            Statement s = this.con.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM Genre");

            while (rs.next()) {
                genre.put(rs.getInt("GenreID"), rs.getString("Name"));
            }
        } catch (SQLException ex) {
            logger.severe("SQL Issue: " + ex.getMessage());
        }

        return genre;
    }

    public boolean addGenre(String name) {
        boolean ret = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES(?)");
            ps.setString(1, name);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    /**
     * Method finds the genre the user requested. The method returns the name of
     * the genre if one is found. If there is no match, returns null.
     *
     * @param id
     * @return
     */
    public String getGenreName(int id) {
        String ret = null;

        try {
            // attempt to find the artist by id
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // if there is a record, get the artist id to return
            if (rs.next()) {
                ret = rs.getString("Name");
            } else {
            }
        } catch (SQLException ex) {
        }
        // send back null or the name
        return ret;
    }

    public boolean updateGenre(int id, String name) {
        boolean ret = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("UPDATE Genre SET Name = ? WHERE GenreID = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.info("Updated genre with ID " + id + " set name to '" + name + "'");
            } else {
                logger.warning("Update genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue updating genre: " + ex.getMessage());
        }

        return ret;
    }

    public boolean deleteGenre(int id) {
        boolean ret = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreID = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.info("Deleted genre with ID " + id);
            } else {
                logger.warning("Delete genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue deleting genre: " + ex.getMessage());
        }

        return ret;

    }
}
