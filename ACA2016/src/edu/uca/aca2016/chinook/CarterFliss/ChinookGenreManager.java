/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.CarterFliss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 *
 * @author Carter
 */
public class ChinookGenreManager {
    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());
    
    public ChinookGenreManager(){
        try{
            // attempt to read a "known" properties file that is on the classpath
            Path inpath = Paths.get("resources","config","CarterFliss", "ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());
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
}
