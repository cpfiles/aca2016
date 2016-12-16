/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.sethdumas;

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
import java.util.logging.Logger;

/**
 *
 * @author sethd
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());

    public ChinookGenreManager() {
        try {
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/sethdumas/ChinookManager.properties");
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

    /**
     *
     * @return returns a hash map of Genre table values
     */
    public HashMap<Integer, String> getGenres() {
        HashMap<Integer, String> genres = new HashMap<>();

        try {
            Statement s = this.con.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM Genre");

            while (rs.next()) {
                genres.put(rs.getInt("GenreId"), rs.getString("Name"));
            }
        } catch (SQLException ex) {
            logger.severe("SQL Issue: " + ex.getMessage());
        }
        return genres;
    }

    /**
     * Adds a Name to the Genre table.
     *
     * @param genrename the name of the genre being added.
     * @return true when a single record is added. false if no record is
     * deleted.
     */
    public boolean addGenre(String genrename) {
        boolean ret;
        ret = false;
        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES(?)");
            ps.setString(1, genrename);

            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                ps.close();
                logger.info("Added genre with name " + genrename);
            } else {
                logger.warning("Adding genre with name " + genrename + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue adding Genre: " + ex.getMessage());
        }

        logger.info("Added Genre '" + genrename + "' to the database ");

        return ret;
    }

    /**
     * Searches for a given genre by id
     *
     * @param id The id of the genre to search.
     * @return The database id of the genre if a single result is found; -1 if
     * no result or ambiguous results are found.
     */
    public String getGenreName(int id) {
        String ret = null;

        try {
            // attempt to find the genre by id
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // if there is a record, get the GenreId to return
            if (rs.next()) {
                ret = rs.getString("Name");
                logger.info("Search by id for Genre '" + id + "' yielded a result of " + ret);
            } else {
                logger.info("Search for Genre '" + id + "' yielded no results");
            }
        } catch (SQLException ex) {
            logger.severe("Issue searching for Genre: " + ex.getMessage());
        }

        // send back null or the genre
        return ret;
    }

    /**
     * Updates a genre name by the given id.
     *
     * @param id The ID of the genre to update.
     * @param name The new name of the genre.
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
                logger.info("Updated Genre with ID " + id + " set Genre to '" + name + "'");
            } else {
                logger.warning("Update Genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue updating Genre: " + ex.getMessage());
        }

        return ret;
    }

    /**
     * Deletes a Genre by the given id.
     *
     * @param id The ID of the genre to delete.
     * @return true when a single record is deleted. false if no records or
     * multiple records are deleted.
     */
    public boolean deleteGenre(int id) {
        boolean ret = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreID = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.info("Deleted Genre with ID " + id);
            } else {
                logger.warning("Delete Genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue deleting Genre: " + ex.getMessage());
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
