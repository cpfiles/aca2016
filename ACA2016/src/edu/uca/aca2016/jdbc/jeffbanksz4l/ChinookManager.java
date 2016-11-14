/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jeffbanksz4l;

import edu.uca.aca2016.config.PropertiesExample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffb
 */
public class ChinookManager {

    private final Properties defaultProperties = new Properties();

    /**
     * Setup to look for the default Properties.
     */
    public ChinookManager() {
        this.loadDefaultProperties();
    }

    private void loadDefaultProperties() {
        FileInputStream in = null;

        try {
            Path inpath = Paths.get("resources", "config", "jeffbanksz4l", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.defaultProperties.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, "Properties file was not found", ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, "Exception reading properties file", ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Setup to connect to the database.
     *
     * @param url
     * @throws SQLException
     */
    public void connectToAndQueryDatabase(String url) throws SQLException {
        Connection con = DriverManager.getConnection(url);

        con.close();
    }
}
