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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
        } finally {

            if (in != null) {
                in.close();
            }

        }
    }
    
    public void addArtist(String artistname) throws SQLException{
        PreparedStatement ps = null;
        
            String sql = "INSERT into Artist (Name) VALUES(?)";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1,"Breland");
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if (ps != null) {
                    ps.close();
                }
                if (con != null)
                    con.close();
            }
        }
    }

