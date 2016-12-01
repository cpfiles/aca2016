/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.CarterFliss;

import java.io.BufferedReader;
import java.sql.*;
import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carter
 */
public class ChinookManager {

    /**
     * @param args the command line arguments
     */
    //initializing class-wide variables
    private Connection con = null;
    private Properties defaultProperties = new Properties();
    private PreparedStatement ps = null;

    //constructor for class
    public ChinookManager() throws SQLException {
        Path inpath = null;
        FileInputStream in = null;
        try {
            //reads ChinookManager.properties files and loads connection to database from file
            inpath = Paths.get("resources", "config", "CarterFliss", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.defaultProperties.load(in);
            in.close();
            this.con = DriverManager.getConnection("jdbc:sqlite:" + this.defaultProperties.getProperty("dbconnection"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, "Properties file was not found", ex);
        } catch (IOException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, "Exception reading properties file", ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            //closes prepared statements
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, "Exception reading properties file", ex);
                }
            }
        }
    }

    //Adds artist to database, defaulting to last id value
    public void addArtist(String artistName) throws SQLException {
        try {
            String sql = "INSERT INTO Artist (Name) VALUES (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, artistName);
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            //closes prepared statements
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }

    }

    //gets ArtistId from database based on artist's Name
    public int getArtist(String artistName) throws SQLException {
        //initializing int id to auto-"fail"
        int id = -1;
        try {
            //runs query to find artist based on artistName
            String sql = "SELECT ArtistId FROM Artist WHERE LOWER(Name) = LOWER((?))";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, artistName);
            ResultSet rs = this.ps.executeQuery();
            //checks if resulSet returns the ArtistId, and returns proper id
            if (rs.next()) {
                id = rs.getInt("ArtistId");
            }
            //check for a second (or hypothetical third+) match, and sets id to fail again if true
            if (rs.next()) {
                id = -1;
            }
            //in case of SQLException, method will fail and id will = -1, to signify error
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            id = -1;
            //closes prepared statements
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }
        return id;
    }

    //updates artist in database based on ArtistId parameter
    public boolean updateArtist(int id, String name) throws SQLException {
        boolean artistUpdated;

        try {

            //updates the artist & saves ps.executUpdate return value
            String sql = "UPDATE Artist SET Name = (?) WHERE ArtistId = (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, name);
            this.ps.setInt(2, id);
            int recCheck = this.ps.executeUpdate();
            //checks recCheck's return value to get appropriate return boolean
            if (recCheck == 1) {
                artistUpdated = true;
            } else {
                artistUpdated = false;
            }
            //in case of SQLException, method will fail and artist isn't updated
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            artistUpdated = false;
            //closes prepared statements
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }
        return artistUpdated;
    }

    //deletes an artist from database and returns whether deletion was successful
    public boolean deleteArtist(int id) throws SQLException {
        boolean artistDeleted;
        try {
            //runs deletion update to database
            String sql = "DELETE FROM Artist WHERE ArtistId = (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, id);
            int recCheck = this.ps.executeUpdate();
            //checks whether artist was deleted and returns proper boolean
            if (recCheck == 1) {
                artistDeleted = true;
            } else {
                artistDeleted = false;
            }
            //in case of SQLException, method will fail and so will deletion
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            artistDeleted = false;
            //closes prepared statements    
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }

        return artistDeleted;
    }

    public void batchLoadArtist(File inCSV, int col) throws SQLException {
        String sql = "INSERT INTO Artist (Name) VALUES (?)";
        String line = "";
        String splitBy = ",";
        String[] set = null;

        final int batchSize = 1000;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inCSV))) {
            while ((line = br.readLine()) != null) {
                set = line.split(splitBy);
                for (String name : set) {
                    this.ps = this.con.prepareStatement(sql);
                    this.ps.setString(1, set[col]);
                    this.ps.addBatch();
                    if (++count % batchSize == 0) {
                        this.ps.executeBatch();
                    }
                }
                this.ps.executeBatch();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, "Exception reading CSV file", ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }

    }

}
