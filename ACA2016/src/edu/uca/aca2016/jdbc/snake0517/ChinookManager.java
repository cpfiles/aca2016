/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.snake0517;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brela
 */
public class ChinookManager {

    Connection con;

    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());

    private Properties Chin = new Properties();

    /**
     * Sets up Connection to the database.
     *
     * @throws IOException
     * @throws SQLException
     */
    public ChinookManager() throws IOException, SQLException {

        FileInputStream in = null;
        try {
            Path inpath = Paths.get("resources", "config", "Snake0517", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.Chin.load(in);
            this.con = DriverManager.getConnection(Chin.getProperty("db.connection"));
            logger.log(Level.INFO, "Connecting to database: {0}", Chin.getProperty("db.connection"));
        } finally {

            if (in != null) {
                in.close();
            }

        }
    }

    /**
     * Adds new artist name to the database in the artist table.
     *
     * @param artistname
     * @throws SQLException
     */
    public void addArtist(String artistname) throws SQLException {
        PreparedStatement ps = null;

        String sql = "INSERT into Artist (Name) VALUES(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artistname);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
    }

    /**
     * Retrieves the ArtistId when give the name of a artist in the table. will
     * return negative one if multiple or no records are found.
     *
     * @param artist_name
     * @return
     * @throws SQLException
     */
    public int getArtist(String artist_name) throws SQLException {
        PreparedStatement ps = null;
        int ArtistId = -1;
        String sql = "SELECT * FROM Artist WHERE UPPER (Name) = (?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artist_name.toUpperCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ArtistId = rs.getInt("ArtistId");
            }
            if (rs.next()) {
                ArtistId = -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.log(Level.INFO, "Return Artist Id: {0}", ArtistId);
        return ArtistId;

    }

    /**
     * Updates the name of the Artist associated with the ArtistId provided.
     *
     * @param Id
     * @param Name
     * @return
     * @throws SQLException
     */
    public boolean updateArtist(int Id, String Name) throws SQLException {
        PreparedStatement ps = null;

        String sql = "UPDATE Artist SET Name = (?) WHERE ArtistId = (?)";
        boolean x = false;
        String ArtistName = Name;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setInt(2, Id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                x = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();

            }

        }
        logger.log(Level.INFO, "Return Artist Name: {0}", ArtistName);

        return x;

    }

    /**
     * Deletes Artist record from the database.
     *
     * @param Id
     * @return
     * @throws SQLException
     */
    public boolean deleteArtist(int Id) throws SQLException {
        PreparedStatement ps = null;
        boolean x = false;
        String sql = "DELETE FROM Artist WHERE ArtistId = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                x = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
        return x;
    }

    public void batchLoadArtist(File Artists) {

    }
}
