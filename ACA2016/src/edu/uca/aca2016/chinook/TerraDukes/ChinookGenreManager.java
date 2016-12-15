/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.TerraDukes;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DueTe
 */
public class ChinookGenreManager {

    Connection con = null;

    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());

    public static void main(String[] args) {
        ChinookGenreManager Chin = new ChinookGenreManager();
    }

    public ChinookGenreManager() {
        try {
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/TerraDukes/ChinookManager.properties");
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
        } catch (IOException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//*

    public HashMap<Integer, String> getGenre() {

        HashMap<Integer, String> Genre = new HashMap<>();

        try {
            Statement s = this.con.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM GENRE");

            while (rs.next()) {
                Genre.put(rs.getInt("GenreID"), rs.getString("Name"));
            }
        } catch (SQLException ex) {
            logger.severe("SQL Issue: " + ex.getMessage());
        }

        return Genre;
    }

    public String getGenreName(int id) {
        String ret = null;

        try {
            // attempt to find the artist by id
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // if there is a record, get the artist id to return
            if (rs.next()) {
                ret = rs.getString("Genre");
                logger.info("Search by id for Genre '" + id + "' yielded an name of " + ret);
            } else {
                logger.info("Search for Genre '" + id + "' yielded no results");
            }
        } catch (SQLException ex) {
            logger.severe("Issue searching for Genre: " + ex.getMessage());
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
                logger.info("Updated Genre with ID " + id + " set name to '" + name + "'");
            } else {
                logger.warning("Update Genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue updating Genre: " + ex.getMessage());
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
                logger.info("Deleted Genre with ID " + id);
            } else {
                logger.warning("Delete Genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        } catch (SQLException ex) {
            logger.severe("Issue deleting Genre: " + ex.getMessage());
        }

        return ret;
    }

    public void addGenre(String Genre) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT into Genre (Name) VALUES(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Genre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
    

    
}


