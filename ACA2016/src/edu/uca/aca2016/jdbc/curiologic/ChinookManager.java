/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.curiologic;

import java.io.BufferedReader;
import java.io.File;
import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xulix
 */

/** establishes connection to database*/
public class ChinookManager {

    private Properties ChinookManager = new Properties();
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());
    Connection con;

    public ChinookManager() throws SQLException {
        this.loadChinookManager();
        con = DriverManager.getConnection(ChinookManager.getProperty("db.connection"));
    }

    /** loads the database properties to connect to*/
    private void loadChinookManager() {
        FileInputStream in = null;

        try {
            Path inpath = Paths.get("resources", "config", "curiologic", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.ChinookManager.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, "Properties file was not found", ex);
        } catch (IOException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, "Exception reading properties file", ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /** Adds artist to database
     * @param addArtist
     * @throws java.sql.SQLException*/
    public void addArtist(String addArtist) throws SQLException {

        PreparedStatement ppst = null;
        try {

            String sql = "INSERT INTO Artist(Name)VALUES (?)";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, addArtist);
            ppst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ppst != null) {
                ppst.close();
            }
        }
    }

    /** gets artist id if 0 or more than 1 returns -
     * @param Name is the name of artist
     * @return gives the artist ID that was retrieved
     * @throws java.sql.SQLException*/
    public int getArtist(String Name) throws SQLException {
        PreparedStatement ppst = null;
        int ArtistId = -1;
        String sql = "SELECT *  FROM Artist WHERE UPPER (Name) =  (?)";
        try {
            ppst = con.prepareStatement(sql);
            ppst.setString(1, Name.toUpperCase());
            ResultSet rs = ppst.executeQuery();
            if (rs.next()) {
                ArtistId = rs.getInt("ArtistId");

            }
            if (rs.next()) {
                ArtistId = -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (ppst != null) {
                ppst.close();
            }
        }
        logger.log(Level.INFO, "artist id is {0}", ArtistId);
        return ArtistId;
    }

    /** updates the artist name in the database
     * @param artistId is the ID to be updated
     * @param artistName Name of Artist
     * @return boolean to show if the database updated
     * @throws java.sql.SQLException*/
    public boolean updateArtist(int artistId, String artistName) throws SQLException {
        PreparedStatement ppst = null;
        boolean update = false;
        try {
            String sql = "UPDATE Artist SET Name = (?) WHERE artistId = ? ";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, artistName);
            ppst.setInt(2, artistId);
            int rows = ppst.executeUpdate();
            if (rows != 1) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (ppst != null) {
                ppst.close();
            }
            logger.log(Level.INFO, "artist name is {0}", artistName);
        }
        return update;

    }


    /** deletes artist from list with given artist I
     * @param artistId is the artist ID to be deleted
     * @return returns boolean for if the ID was deleted
     * @throws java.sql.SQLException*/
    public boolean artistDelete(int artistId) throws SQLException {

        PreparedStatement ppst = null;
        boolean del = false;

        try {

            String sql = "DELETE FROM Artist WHERE artistId = ?";
            ppst = con.prepareStatement(sql);
            ppst.setInt(1, artistId);
            int rowd = ppst.executeUpdate();
            if (rowd != 1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ppst != null) {
                ppst.close();
            }
            logger.log(Level.INFO, "Deleted {0}", artistId);
        }
        return false;
    }
/**
 * batch loads CSV file into the Database with chosen column
     * @param music is CSV file to be loaded
     * @param Col is the column to be loaded into database
     * @throws java.io.FileNotFoundException
     * @throws java.sql.SQLException
 */
    public void BatchLoadArtist(File music, int Col) throws FileNotFoundException, IOException, SQLException {
        PreparedStatement ppst = null;
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        String[] Band;
        String sql = "INSERT INTO Artist(Name)VALUES (?)";
        ppst = con.prepareStatement(sql);
        try {
            br = new BufferedReader(new FileReader(music));
            while ((line = br.readLine()) != null) {
                Band = line.split(csvSplitBy);
                ppst.setString(1, Band[Col]);
                logger.log(Level.INFO, "added {0}", Band[Col]);
                ppst.addBatch();
            }
            ppst.executeBatch();
            ppst.close();

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
