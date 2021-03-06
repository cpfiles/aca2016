/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jeffbanksz4l;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Setup for connecting to the database.
 *
 * @author jeffb
 */
public class ChinookManager {

    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());

    /**
     * Setup to look for the default Properties.
     *
     * @throws java.sql.SQLException
     */
    public ChinookManager() throws SQLException {
        try {
            Path inpath = Paths.get("resources", "config", "jeffbanksz4l", "ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());
            Properties cmProperties = new Properties();
            cmProperties.load(in);
            in.close();

            logger.info("Connecting to database: " + cmProperties.getProperty("db.connection"));

            con = DriverManager.getConnection(cmProperties.getProperty("db.connection"));

        } catch (FileNotFoundException ex) {
            logger.severe("FileNotFoundException: " + ex.getMessage());
        } catch (IOException ex) {
            logger.severe("IO Exception: " + ex.getMessage());
        }
    }

    /**
     * Adding an Artist to the database.
     *
     * @param artistName
     * @throws SQLException
     */
    public void addArtist(String artistName) throws SQLException {

        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO Artist (Name) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, artistName);
            ps.executeUpdate();
            logger.info("Added Artist '" + artistName + "' to the database");

        } catch (SQLException ex) {
            logger.severe("SQL exception: " + ex.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Getting the Artist Id from the database.
     *
     * @param artistName
     * @return
     * @throws SQLException
     */
    public int getArtist(String artistName) throws SQLException {

        PreparedStatement ps = null;
        int ArtistId = -1;
        String sql = "SELECT * FROM Artist WHERE upper(Name) = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artistName.toUpperCase());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ArtistId = rs.getInt("ArtistId");
            }
            if (rs.next()) {
                ArtistId = -1;
            }

        } catch (SQLException ex) {
            logger.severe("SQL Exception: " + ex.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.info("Return ArtistId: " + ArtistId);
        return ArtistId;
    }

    /**
     * Updating an Artist in the database.
     *
     * @param ArtistId
     * @param newArtistName
     * @return
     * @throws java.sql.SQLException
     */
    public boolean updateArtist(int ArtistId, String newArtistName) throws SQLException {

        PreparedStatement ps = null;
        boolean update = false;

        String sql = "UPDATE Artist SET Name = ? WHERE ArtistId = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, newArtistName);
            ps.setInt(2, ArtistId);
            int rtn = ps.executeUpdate();
            logger.info("Updated Artist '" + newArtistName + "' with ArtistId: " + ArtistId);

            if (rtn == 1) {
                update = true;
            }

        } catch (SQLException ex) {
            logger.severe("SQL Exception: " + ex.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.info("Updated Artist: " + newArtistName);
        return update;
    }

    /**
     * Deleting an Artist from the database.
     *
     * @param ArtistId
     * @return
     * @throws java.sql.SQLException
     */
    public boolean deleteArtist(int ArtistId) throws SQLException {

        PreparedStatement ps = null;
        boolean update = false;
        String sql = "DELETE FROM Artist WHERE ArtistId = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ArtistId);
            ps.executeUpdate();
            int rtn = ps.executeUpdate();
            logger.info("Deleted ArtistId: " + ArtistId);

            if (rtn == 1) {
                update = true;
            }

        } catch (SQLException ex) {
            logger.severe("SQL Exception: " + ex.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.info("Deleted ArtistId: " + ArtistId);
        return update;
    }

    /**
     *
     * @param csv Read in the CSV file.
     * @param Col Specific column to read from the CSV file.
     * @throws FileNotFoundException Exception if file is not found.
     * @throws IOException Exception if the path is not working.
     * @throws SQLException Exception if the DB cannot be connected to.
     */
    public void batchLoadArtist(File csv, int Col) throws FileNotFoundException, IOException, SQLException {

        PreparedStatement ps = null;
        String line = "";
        String splitC = ",";
        String sql = "INSERT INTO Artist (Name) VALUES (?)";
        ps = con.prepareStatement(sql);

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {

            while ((line = br.readLine()) != null) {
                String[] name = line.split(splitC);
                logger.info("Artist Name: " + name[Col]);
                ps.setObject(1, name[Col]);
                ps.addBatch();
                logger.info("Added Artists: '" + name[Col]);
            }
            ps.executeBatch();

        } catch (IOException ex) {
            logger.severe("IO Exception: " + ex.getMessage());
        }
    }
}
