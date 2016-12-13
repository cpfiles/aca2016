/*
C:\Users\DueTe\Downloads\ChinookDatabase1.4_Sqlite
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca2016.jdbc.TerraDukes;

/**
 *
 * @author DueTe
 */
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Paths;

/**
 * Build a class named ChinookManager
 */
public class ChinookManager {

    /**
     * Establish Connection to the database. IQ & SQL Exception thrown
     *
     *
     */
    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());
    private Properties Chin = new Properties();

    public ChinookManager() {
        try {
            Path inpath = Paths.get("resources", "config", "TerraDukes", "ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());

            this.Chin.load(in);
            this.con = DriverManager.getConnection(Chin.getProperty("db.connections"));

            logger.log(Level.INFO, "Connecting to database: {0}", Chin.getProperty("db.connections"));
            in.close();

        } catch (FileNotFoundException ex) {

        } catch (IOException | SQLException ex) {

        }
    }

    /*create method  connect-and delete- add/get/update/deleteArtist-single parameter for name.
     */
    public void addArtist(String Artistname) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT into Artist (Name) VALUES(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Artistname);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public int getArtist(String name) throws SQLException {
        PreparedStatement ps = null;
        int id = -1;
        try {

            String sql = "SELECT * from Artist where UPPER (Name) = (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name.toUpperCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ArtistId");
            }
            if (rs.next()) {
                id = -1;

            }

        } catch (SQLException ex) {

            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.log(Level.INFO, "Return Artist Id: {0}", id);
        return id;
    }

    public boolean updateArtist(int id, String name) {
        PreparedStatement ps = null;

        String sql = "UPDATE Artist Set Name = (?) WHERE ArtistId = (?)";
        boolean x = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                x = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.log(Level.INFO, "Return Artist Name:  {0}", name);

        return x;

    }

    public boolean deleteArtist(int id) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM Artist WHERE ArtistId = (?)";
        boolean x = false;
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                x = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return x;

    }

    public void batchLoadArtist(File Artist, int col) {
        try {
            PreparedStatement ps = null;
            String sql = "INSERT into Artist (Name) VALUES(?)";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            ps = con.prepareStatement(sql);
            String[] ArtList;
            try {

                br = new BufferedReader(new FileReader(Artist));
                while ((line = br.readLine()) != null) {
                    ArtList = line.split(cvsSplitBy);

                    ps.setString(1, ArtList[col]);
                    ps.addBatch();

                }
                ps.executeBatch();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
