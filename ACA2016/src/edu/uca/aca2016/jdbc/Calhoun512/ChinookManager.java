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
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;



public class ChinookManager{
    
    Connection con;

    private Properties chinook = new Properties();
    
        public ChinookManager() throws IOException, SQLException {
                 
        FileInputStream in = null;      
        try {
    
            Path inpath = Paths.get("resources", "config", "Calhoun512", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.chinook.load(in);
            con = DriverManager.getConnection(chinook.getProperty("db.connection"));
                    
        }finally{
            
            if (in != null){
                in.close();
            }
            
        }
        
    }
    /**
     *
     * @param artist_name
     * @throws SQLException
     */
        public void addArtist(String Name) throws SQLException {
            
            PreparedStatement ps = null;
            
            try{
                
                String sql = "INSERT INTO Artist (Name) VALUES (?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, Name);
                ps.executeUpdate();
            }
            catch(SQLException ex){
                Logger.getLogger(ChinookManager.class.getName());
                
            }
            finally {
                if (ps != null){
                ps.close();
            }
            }
        }
        
        public void getArtist (String Name) throws SQLException {
            
            PreparedStatement ps = null;
            ResultSet rs =
        }
        
    /**
     *
     * @param artist_name
     * @throws SQLException
     */
//        public int getArtist (String artist_name) throws SQLException {
//            Connection con = null;
//            PreparedStatement ps = null;
//            
//        try {
//        }

}
        

    
//    public void connectToAndQueryDatabase(String url) throws SQLException{
//        
//        Connection con = DriverManager.getConnection(Chinook.getProperty("db.connection"));
//        
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM Artist");
//
//        while(rs.next()){
//            String first_name = rs.getString("FirstName");
//            String last_name = rs.getString("LastName");
//            int id = rs.getInt("ArtistId");
//            
//            System.out.format("Artist", id, first_name, last_name);
//        }
//        
//        stmt.close();
//        con.close();
//    }
//        
//    /**
//     *
//     * @throws IOException
//     * @throws SQLException
//     */
//
//        
//
//    
//
//    public void connectAndInsert(String url) throws SQLException {
//        Connection con = null;
//        PreparedStatement ps = null;
//        
//    try{
//            con = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\calho\\\\Documents\\\\SQL\\\\Chinook");
//            
//            ps = con.prepareStatement("INSERT INTO Artist(FirstName, LastName) VALUES (?,?)");
//            ps.executeUpdate();
//            
        
    






