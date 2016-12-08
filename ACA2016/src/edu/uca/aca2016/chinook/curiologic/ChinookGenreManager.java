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
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

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
    }

}
