/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.Snake0517;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brela
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());

    public ChinookGenreManager() {
        
        try {
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/Snake0517/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();

            logger.log(Level.INFO, "Connecting to database: {0}", props.getProperty("db.connection"));

            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("db.connection"));
            }
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File Not Found: {0}", ex.getMessage());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IO Exception: {0}", ex.getMessage());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Issue: {0}", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Class not found: {0}", ex.getMessage());
        }
    }
    public HashMap<Integer, String> getGenre() {
        HashMap<Integer, String> Genre = new HashMap<>();
        
        try{
            Statement s = this.con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM Artist");
            
            while (rs.next()) {
                Genre.put(rs.getInt("GenreID"), rs.getString("Name"));
            }
        }
        catch(SQLException ex){
            logger.log(Level.SEVERE, "SQL Issue: {0}", ex.getMessage());
        }
        
        return Genre;
    }
    
}
