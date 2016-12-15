/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.jrob582;

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
 * @author johna
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());

    /**
     * Creates a connection to an instance of the Chinook database.
     *
     * The connection URL is obtained by reading a properties file located on
     *
     */
    public ChinookGenreManager() {
        try {

            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/jrob/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();

            logger.log(Level.INFO, "Connecting to database: {0}", props.getProperty("db.connection"));

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
     *
     * @return
     */
    public HashMap<Integer, String> getGenre() {
        HashMap<Integer, String> Genre = new HashMap<>();

        try {
            Statement s = this.con.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM Genre");

            while (rs.next()) {
                Genre.put(rs.getInt("GenreID"), rs.getString("Name"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Issue: {0}", ex.getMessage());
        }

        return Genre;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean addGenre(String name) {
        boolean ret = false;
        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES(?)");
            ps.setString(1, name);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                ret = true;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue adding genre: {0}", ex.getMessage());
        }

        logger.log(Level.INFO, "Added genre ''{0}'' to the database ", name);
        return ret;
    }

    /**
     *
     * @param id
     * @return
     */
    public String getGenreName(int id) {
        String ret = null;

        try {

            PreparedStatement ps;
            ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ret = rs.getString("Name");
                logger.log(Level.INFO, "Search by id for genre ''{0}'' yielded an name of {1}", new Object[]{id, ret});
            } else {
                logger.log(Level.INFO, "Search for genre ''{0}'' yielded no results", id);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue searching for genre: {0}", ex.getMessage());
        }

        return ret;
    }

    /**
     *
     * @param id
     * @param name
     * @return
     */
    public boolean updateGenre(int id, String name) {
        boolean ret = false;

        try {
            PreparedStatement ps;
            ps = this.con.prepareStatement("UPDATE Genre SET Name = ? WHERE GenreID = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.log(Level.INFO, "Updated genre with ID {0} set name to ''{1}''", new Object[]{id, name});
            } else {
                logger.log(Level.WARNING, "Update genre with ID {0} had an undesired result and changed {1} records", new Object[]{id, ra});
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue updating genre: {0}", ex.getMessage());
        }

        return ret;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteGenre(int id) {
        boolean ret = false;

        try {
            PreparedStatement ps;
            ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreID = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();

            if (ra == 1) {
                ret = true;
                logger.log(Level.INFO, "Deleted genre with ID {0}", id);
            } else {
                logger.log(Level.WARNING, "Delete genre with ID {0} had an undesired result and changed {1} records", new Object[]{id, ra});
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Issue deleting genre: {0}", ex.getMessage());
        }

        return ret;
    }

    public void close() {
        if (this.con != null) {
            try {
                this.con.close();
            } catch (SQLException ex) {
                logger.warning(ex.getMessage());
            }
        }
    }
}
