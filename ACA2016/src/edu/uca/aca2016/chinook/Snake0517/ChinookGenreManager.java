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
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author brela
 */
public class ChinookGenreManager {

    Connection con = null;
    private static final Logger logger = Logger.getLogger(ChinookGenreManager.class.getName());

    public ChinookGenreManager() {
        System.out.print("I AM HERE");
        try {
            Enumeration<URL> url = ChinookGenreManager.class.getClassLoader().getResources("config/Snake0517/ChinookManager.properties");
            InputStream stream = new FileInputStream(url.nextElement().getPath());
            Properties props = new Properties();
            props.load(stream);
            stream.close();

            logger.info("Connecting to database: " + props.getProperty("db.connection"));

            Class.forName("org.sqlite.JDBC");
            if (this.con == null) {
                con = DriverManager.getConnection(props.getProperty("db.connection"));
            }
        } catch (FileNotFoundException ex) {
            logger.severe("File Not Found: " + ex.getMessage());
        } catch (IOException ex) {
            logger.severe("IO Exception: " + ex.getMessage());
        } catch (SQLException ex) {
            logger.severe("SQL Issue: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            logger.severe("Class not found: " + ex.getMessage());
        }
    }
}
