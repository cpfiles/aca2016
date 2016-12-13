/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.jeffbanksz4l;

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
import java.util.Properties;
import java.util.logging.Logger;
import java.util.HashMap;

/**
 *
 * @author jeffb
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());

    /**
     * Creates a connection to an instance of the Chinook database.
     *
     * The connection URL is obtained by reading a properties file located on
     * the classpath at resources/config/jeffbanksz4l/ChinookManager.properties
     */
    public ChinookGenreManager() {

        try {
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/jeffbanksz4l/ChinookManager.properties");
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
     * Creates a HashMap of the Genre database.
     *
     * @return Returns the Genre database.
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
     * Adds a Genre to the database.
     *
     * @param name The Name of the Genre.
     * @return If true only one record is returned, false if none or more than
     * one record is returned.
     * @throws SQLException
     */
    public boolean addGenre(String name) throws SQLException {
        boolean rtn = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES (?)");
            ps.setString(1, name);
            int retGenre = ps.executeUpdate();

            if (retGenre == 1) {
                rtn = true;
                logger.info("Genre '" + name + "' was added to the database");
            } else {
                logger.info("Genre '" + name + "' was NOT added to the database");
            }

        } catch (SQLException ex) {
            logger.severe("Issue adding Genre: " + ex.getMessage());
        }

        return rtn;
    }

    /**
     * Searches for a Genre based on the GenreId.
     *
     * @param id Id of the Genre that is being searched for.
     * @return Returns GenreName from the GenreId if found, otherwise returns
     * 'null'.
     * @throws SQLException
     */
    public String getGenreName(int id) throws SQLException {

        String GenreName = null;

        try {
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                GenreName = rs.getString("Name");
            }
            if (rs.next()) {
                GenreName = null;
            }

        } catch (SQLException ex) {
            logger.severe("SQL Exception: " + ex.getMessage());
        }
        logger.info("Issue returning GenreName: " + GenreName);
        return GenreName;
    }

    /**
     * Updates a Genre in the database.
     *
     * @param id Id of the Genre that is being updated.
     * @param name Updates with a New Genre Name.
     * @return If true only one record is returned, false if none or more than
     * one record is returned.
     * @throws java.sql.SQLException
     */
    public boolean updateGenre(int id, String name) throws SQLException {
        boolean rtn = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("UPDATE Genre SET Name = ? WHERE GenreId = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int retGenre = ps.executeUpdate();

            if (retGenre == 1) {
                rtn = true;
                logger.info("Genre '" + name + "' was updated to the database");
            } else {
                logger.info("Genre '" + name + "' was NOT updated to the database");
            }
        } catch (SQLException ex) {
            logger.severe("Issue updating Genre: " + ex.getMessage());
        }

        return rtn;
    }

    /**
     * Deletes a Genre from the database.
     *
     * @param id Id of the Genre that is being deleted.
     * @return If true only one record is returned, false if none or more than
     * one record is returned.
     * @throws java.sql.SQLException
     */
    public boolean deleteGenre(int id) throws SQLException {
        boolean rtn = false;

        try {
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            int retGenre = ps.executeUpdate();

            if (retGenre == 1) {
                rtn = true;
                logger.info("Genre '" + id + "' was deleted to the database");
            } else {
                logger.info("Genre '" + id + "' was NOT deleted to the database");
            }

        } catch (SQLException ex) {
            logger.severe("Issue deleting Genre: " + ex.getMessage());
        }

        logger.info("Deleted GenreId: " + id);
        return rtn;
    }

    /**
     * Closes connection to the database.
     */
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
