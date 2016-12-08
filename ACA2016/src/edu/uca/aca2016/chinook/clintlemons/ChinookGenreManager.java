/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.clintlemons;

import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
import java.util.Enumeration;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;



/**
 *
 * @author Username
 */
public class ChinookGenreManager {
        Connection con = null;
         static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());
    public ChinookGenreManager() {
        try{
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/clintlemons/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();
            
            logger.info("Connecting to database: " + props.getProperty("db.connection"));
            
            // the properties file loaded, attempt to connect using the value of the "db.connection" property
            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("db.connection"));
            }
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
        catch(ClassNotFoundException ex){
            logger.severe("Class not found: " + ex.getMessage());
        }
    }
}
