/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.Calhoun512;

/**
 *
 * @author calho
 */

import java.sql.*;
import java.util.properties;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Statement;



public class ChinookManager{
    
    public void connectToAndQueryDatabase(String url) throws SQLException{
        Connection con = DriverManager.getConnection(chinook.getProperty("db.connection"));
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Artist");

        while(rs.next()){
            String first_name = rs.getString("FirstName");
            String last_name = rs.getString("LastName");
            int id = rs.getInt("ArtistId");
            
            System.out.format("Artist", id, first_name, last_name);
        }
        
        stmt.close();
        con.close();
    }
        
    /**
     *
     * @throws IOException
     * @throws SQLException
     */
//    public ChinookManager() throws IOException, SQLException {
//        
//        Connection con = DriverManager.getConnection(ChinookManager.getProperty("db.connection"));
//        
//    
//        FileInputStream in = null;
//        try{
//            Path inpath = Paths.get("resources", "config", "Calhoun512", "ChinookManager.properties");
//            in = new FileInputStream(inpath.toFile());
//            this.chinook.load(in);
//            in.close();
//            this.con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\calho\\Documents\\SQL\\Chinook");
//        
//        }catch(SQLException){
//        
//        System.out.println(this.ChinookManager.getProperty("db.connection"));
//        
//        }finally{
//            
//            if (in != null){
//                in.close();
//            }
//            
//        }
//        
//
//    }

    public void connectAndInsert(String url) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\calho\\\\Documents\\\\SQL\\\\Chinook");
            
            ps = con.prepareStatement("INSERT INTO Artist(FirstName, LastName) VALUES (?,?)");
            ps.executeUpdate();
            
            
        }
    }

}

