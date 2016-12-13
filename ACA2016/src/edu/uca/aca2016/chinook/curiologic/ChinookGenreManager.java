/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.curiologic;

import java.io.FileInputStream;
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
 * @author xulix
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger log = Logger.getLogger(ChinookGenreManager.class.getName());

    public ChinookGenreManager() {
        try {
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/curiologic/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();

            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("db.connection"));
            }
        } catch (ClassNotFoundException ex) {
            log.info("File Not Found:" + ex.getMessage());
        } catch (SQLException ex) {
            log.info(ex.getMessage());
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
    }public HashMap<Integer, String> getGenre() {
       HashMap<Integer, String> artists = new HashMap<>();
       
       try{
           Statement s = this.con.createStatement();
           
           ResultSet rs = s.executeQuery("SELECT * FROM Genre");
           
           while (rs.next()) {
               artists.put(rs.getInt("GenreID"), rs.getString("Name"));
           }
       }
       catch(SQLException ex){
           log.severe("SQL Issue: " + ex.getMessage());
       }
       
       return artists;
   } 
    public boolean addGenre(String name) {
        boolean ret = false;
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES(?)");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
            ResultSet rs = ps.executeQuery();
             int ra = ps.executeUpdate();
             
             if (ra == 1) {
                ret = true;
            }
              else {
                log.info("adding genre '" + name + "' failed");
            }
        }
                
        catch(SQLException ex){
            log.severe("Issue adding genre: " + ex.getMessage());
        }
        
        log.info("Added genre '" + name + "' to the database ");
       return ret;
    }
public String getGenreName(int id) {
        String ret = null;

        try{
            // attempt to find the artist by id
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            // if there is a record, get the artist id to return
            if (rs.next()) {
                ret = rs.getString("Name");
                log.info("Search  id for genre '" + id + "' genre of " + ret);
            }
            else {
                log.info("Search for genre '" + id + "' yielded no results");
            }
        }
        catch(SQLException ex){
            log.severe("Issue searching for genre: " + ex.getMessage());
        }

        // send back null or the name
        return ret;
    }
 public boolean updateGenre(int id, String name) {
        boolean ret = false;
        
        try{
            PreparedStatement ps = this.con.prepareStatement("UPDATE Genre SET Name = ? WHERE GenreID = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int ra = ps.executeUpdate();
            
            if (ra == 1) {
                ret = true;
                log.info("Updated artist with ID " + id + " set name to '" + name + "'");
            }
            else {
                log.warning("Update artist with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        }
        catch(SQLException ex){
            log.severe("Issue updating genre: " + ex.getMessage());
        }
        
        return ret;
    }
      
    public boolean deleteGenre(int id) {
        boolean ret = false;
        
        try{
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreID = ?");
            ps.setInt(1, id);
            int ra = ps.executeUpdate();
            
            if (ra == 1) {
                ret = true;
                log.info("Deleted genre with ID " + id);
            }
            else {
                log.warning("Delete genre with ID " + id + " had an undesired result and changed " + ra + " records");
            }
        }
        catch(SQLException ex){
            log.severe("Issue deleting genre: " + ex.getMessage());
        }
        
        return ret;
    }
}
