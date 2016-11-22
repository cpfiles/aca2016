/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.CarterFliss;

import java.sql.*;
import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        PreparedStatement psOldName;
        PreparedStatement psNewName;
        try {
            //saves old artist name
            String oldName = "SELECT Name FROM Artist WHERE ArtistId = (?)";
            psOldName = con.prepareStatement(oldName);
            psOldName.setInt(1, id);
            ResultSet getOld = psOldName.executeQuery();
            if (getOld.next()) {
                oldName = getOld.getString("Name");
            }
            //updates the artist
            String sql = "UPDATE Artist SET Name = (?) WHERE ArtistId = (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, name);
            this.ps.setInt(2, id);
            this.ps.executeUpdate();
            //saves the new artist name
            String newName = "SELECT Name FROM Artist WHERE ArtistId = (?)";
            psNewName = con.prepareStatement(newName);
            psNewName.setInt(1, id);
            ResultSet getNew = psNewName.executeQuery();
            //checks whether new name and old name are/aren't the same, and returns proper value
            if (getNew.next()) {
                newName = getNew.getString("Name");
            }
            if (oldName.equals(newName)) {
                artistUpdated = false;
            } else {
                artistUpdated = true;
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
            this.ps.executeUpdate();
            //checks whether artist was deleted and returns proper boolean
            if (this.ps.executeUpdate() == 0) {
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

}
