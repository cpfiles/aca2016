/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.TerraDukes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author DueTe
 */
public class ChinookGenreManager {

    
        try{
            // attempt to read a "known" properties file that is on the classpath
            Enumeration<URL> url = ChinookManager.class.getClassLoader().getResources("config/cpfiles/ChinookManager.properties");
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
}
