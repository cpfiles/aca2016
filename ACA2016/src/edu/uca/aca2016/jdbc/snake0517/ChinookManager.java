/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.snake0517;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author brela
 */
public class ChinookManager {

    Connection con;

    private Properties Chin = new Properties();

    public ChinookManager() throws IOException, SQLException {

        FileInputStream in = null;
        try {
            Path inpath = Paths.get("resources", "config", "Snake0517", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.Chin.load(in);
            this.con = DriverManager.getConnection(Chin.getProperty("db.connection"));
            in.close();
        } finally {

            if (in != null) {
                in.close();
            }

        }
    }
}
