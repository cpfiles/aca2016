/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.clintlemons;

import java.util.Properties;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Username
 */
public class ChinookManager {
     Connection con;
    /**
     * connect to db
     * @throws java.sql.SQLException
     */
    public ChinookManager() throws SQLException {
        this.con = DriverManager.getConnection("ChinookManager.properties");
  
                
    }
}
    //public void ConnectAndLoadDefaultProperties("Chinook_db") {
       // try {
           // String db = "C:\\Users\\Username\\Documents\\Chinook_db\\Chinook_Sqlite.sql";  
     //  Connection con = DriverManager.getConnection("Chinook_db");
      // public void DefaultProperties(){
            //String  == ("C:\Users\Username\Documents\NetBeansProjects\aca2016\ACA2016\resources\config\clintlemons");
           // defaultProperties = ("ChinookManager.properties");
           // Path file = file.get("C:\Users\Username\Documents\NetBeansProjects\aca2016\ACA2016\resources\config\clintlemons\ChinookManager.properties");
 
            //ResultSet rs = stmt.executeQuery("SELECT * FROM Album");
          //  Statement stmt = con.createStatement("Album");
            // in = new FileInputStream(inpath.toFile());
            //  this.defaultProperties.load();
            // in.close();
            // } catch (SQLException ex) {
            //  Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);     
//        default.FileInputStream = ("ChinookManager.properties") {
//        this.toString();
//        default.Properties = 
//        
//    }
//  
//            



    

