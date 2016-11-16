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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Setup for connecting to the database.
 *
 * @author jeffb
 */
public class ChinookManager {

    Connection con;
    private Properties defaultProperties = new Properties();

    /**
     * Setup to look for the default Properties.
     *
     * @throws java.sql.SQLException
     */
    public ChinookManager() throws SQLException {
        this.loadDefaultProperties();
        this.con = DriverManager.getConnection(defaultProperties.getProperty("db.connection"));
    }

    private void loadDefaultProperties() throws SQLException {
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
     * Method to add an Artist.
     *
     * @param url
     * @throws SQLException
     */
    public void addArtist(String url) throws SQLException {
//        this.loadDefaultProperties();
        this.con = DriverManager.getConnection(defaultProperties.getProperty("db.connection"));
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO Artist (Name) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "Benny Goodman");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
    }
}
