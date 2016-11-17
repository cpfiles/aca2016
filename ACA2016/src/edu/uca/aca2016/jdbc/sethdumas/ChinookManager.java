/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.sethdumas;

import java.io.FileInputStream;
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
 * @author sethd
 */
public class ChinookManager {

    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());

    public void ChinookManager() {
        try {
            Path inpath = Paths.get("resources", "config", "sethdumas", "ChinookManager.properties");
            Properties props;
            try (FileInputStream in = new FileInputStream(inpath.toFile())) {
                props = new Properties();
                props.load(in);
            }

            con = DriverManager.getConnection(props.getProperty("db.connection"));

        } catch (SQLException | IOException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addArtist(){
        
        
    }
}
