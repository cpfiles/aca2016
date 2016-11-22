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
    private Connection con = null;
    private Properties defaultProperties = new Properties();
    private PreparedStatement ps = null;

    public ChinookManager() throws SQLException {
        Path inpath = null;
        FileInputStream in = null;
        try {
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

    public void addArtist(String artistName) throws SQLException {
        try {
            String sql = "INSERT INTO Artist (Name) VALUES (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, artistName);
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }

    }

    public int getArtist(String artistName) throws SQLException {
        int id = -1;
        try {            
            String sql = "SELECT ArtistId FROM Artist WHERE LOWER(Name) = LOWER((?))";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, artistName);
            ResultSet rs = this.ps.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt("ArtistId");                
            } 
            if (rs.next()) {
                id = -1;
            }
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }
        return id;
    }

    public boolean updateArtist(int id, String name) throws SQLException {
        boolean artistUpdated;
        try {
            String oldName = "SELECT Name FROM Artist WHERE ArtistId = (?)";
            PreparedStatement psOldName = con.prepareStatement(oldName);
            psOldName.setInt(1, id);
            ResultSet getOld = psOldName.executeQuery();
            if (getOld.next()){
                oldName = getOld.getString("Name");
            }
            
            String sql = "UPDATE Artist SET Name = (?) WHERE ArtistId = (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, name);
            this.ps.setInt(2, id);
            this.ps.executeUpdate();
            
            String newName = "SELECT Name FROM Artist WHERE ArtistId = (?)";
            PreparedStatement psNewName = con.prepareStatement(newName);
            psNewName.setInt(1, id);
            ResultSet getNew = psNewName.executeQuery();
            if (getNew.next()){
                newName = getNew.getString("Name");
            }
            if (oldName.equals(newName)){
                return artistUpdated = false;
            } else {
                return artistUpdated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            artistUpdated = false;
            return artistUpdated;
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }
        
    }

    public boolean deleteArtist(int id) throws SQLException {
        boolean artistDeleted;
        try{
            String sql = "DELETE FROM Artist WHERE ArtistId = (?)";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, id);            
            this.ps.executeUpdate();                    
            
            return artistDeleted = true;
            
        }catch (SQLException ex){
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            artistDeleted = false;
            return artistDeleted;
        }finally{
            if (this.ps != null) {
                this.ps.close();
            }
        }
        
        
    }
}
