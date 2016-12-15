/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.CarterFliss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author Carter
 */
public class ChinookGenreManager {
    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());
    PreparedStatement ps;
    
    public ChinookGenreManager(){
        try{
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/CarterFliss/ChinookManager.properties");
            InputStream in = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(in);
            in.close();
            
            logger.info("Connecting to database: " + props.getProperty("dbconnection"));
            
            // the properties file loaded, attempt to connect using the value of the "db.connection" property
            con = DriverManager.getConnection(props.getProperty("dbconnection"));
        }
        catch(FileNotFoundException ex){
            logger.severe("File Not Found: " + ex.getMessage());
        }
        catch(IOException ex){
            logger.severe("IO Exception: " + ex.getMessage());
        }
        catch(SQLException ex){
            logger.severe("SQL Issue: " + ex.getMessage());
        }
    }
    
    public HashMap<Integer,String> getGenres(){
        HashMap<Integer,String> m = new HashMap<Integer,String>();
        try{
            this.ps = this.con.prepareStatement("SELECT * FROM Genre");
            ResultSet rs = this.ps.executeQuery();
            int genIDCol = rs.findColumn("GenreId");
            int genNameCol = rs.findColumn("Name");
            while(rs.next()){
                int getGenID = rs.getInt(genIDCol);
                String getGenName = rs.getString(genNameCol);
                m.put(getGenID,getGenName);
            }
            
        }catch(SQLException e){
            logger.severe(e.getMessage());
        }
        return m;
    }
    
    public boolean addGenre(String inName){
        boolean tf = false;
        try{
            this.ps = this.con.prepareStatement("INSERT INTO Genre (Name) VALUES (?)");
            this.ps.setString(1, inName);
            int ga = this.ps.executeUpdate();
            if (ga == 1){
                tf = true;
                logger.info(inName + " was added to database.");
            }else{
                logger.warning("Error entering "+inName+" into database.");
            }
            
        }catch(SQLException e){
            logger.severe(e.getMessage());
        }
        return tf;
    }
    
    public String getGenreName (int IDpar){
        String newGenre = null;
        try{
            this.ps = this.con.prepareStatement("SELECT * FROM Genre WHERE GenreId = (?)");
            this.ps.setInt(1, IDpar);
            ResultSet rs = this.ps.executeQuery();
            if(rs.next()){
                newGenre = rs.getString(1);
                logger.info(rs.getString(1)+" was found.");
            }
        }catch (SQLException e){
            logger.severe(e.getMessage());
        }
        return newGenre;
    }
    
    public boolean updateGenre (int IDpar, String namePar){
        boolean tf = false;
        try{
            this.ps = this.con.prepareStatement("UPDATE Genre SET Name = (?) WHERE GenreId = (?)");
            this.ps.setString(1, namePar);
            this.ps.setInt(2, IDpar);
            int ga = this.ps.executeUpdate();
            if (ga == 1){
               tf = true;
               logger.info("Genre updated entry " + IDpar + " to "+namePar);
            }else{
                logger.warning("Genre was NOT updated.");
            }
        }catch (SQLException e){
            logger.severe(e.getMessage());
        }
        return tf;
    }
    
    public boolean deleteGenre (int IDpar){
        boolean tf = false;
        try{
            this.ps = this.con.prepareStatement("DELETE FROM Genre WHERE GenreId = (?)");
            this.ps.setInt(1, IDpar);
            int ga = this.ps.executeUpdate();
            if (ga == 1){
                tf = true;
                logger.info("Genre w/ ID "+IDpar+" was deleted.");
            }else{
                logger.warning("Genre was NOT deleted.");
            }
        }catch (SQLException e){
            logger.severe(e.getMessage());
        }
        return tf;
    }
}
