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
import java.io.IOException;
import static java.lang.System.in;
import java.sql.*;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
/**
 *
 * @author Username
 */
public class ChinookManager {
    Connection con=null;
    private final Properties defaultProperties =new Properties();
    //this.con = DriverManager.getConnection("dbconnection");
    /**
     *loads properties file
     * @param dbconnection
     * @throws java.sql.SQLException
     * 
     */
    public void ChinookManager (String dbconnection) throws SQLException {
        FileInputStream in;
        this.con = DriverManager.getConnection("dbconnection");
        try{
            Path inpath = Paths.get("resources","config","clintlemons","ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.defaultProperties.load(in);
            //con = defaultProperties.getProperty("db.connection",));
            //this.con.prepareCall("Chinook_db");
            in.close();
        } catch (FileNotFoundException Properties_Not_Found) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.WARNING, null, Properties_Not_Found);
        } catch (IOException Properties_IO_Error) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.WARNING, null, Properties_IO_Error);
        }
        
    }
    public void addArtist(String name){
              logger.info("Added artist'"+name+"' to the database");
    }

    ChinookManager (){
        throw new UnsupportedOperationException("connection failed"); //To change body of generated methods, choose Tools | Templates.
    }
}





//        private Properties prop=new Properties(){
//                String Connection = prop.getProperty("ChinookManager.properties");
//                System.out.println("Connection Successful");
                
//        try {
//            prop.load(in);
//        } catch (IOException ex) {
//            Logger.getLogger(ChinookManager.class.getName()).log(Level.WARNING, null, ex);
//        }
//        try {
//            in.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ChinookManager.class.getName()).log(Level.INFO, null, ex);
//     Connection con;
//    public ChinookManager() throws SQLException {
//        this.con = DriverManager.getConnection("ChinookManager.properties");   
//    }
//    public void addArtist(String Artist, int ArtistID){
//        
//    }}
//} public void insertRow(String coffeeName, int supplierID,
//                      float price, int sales, int total)
//    throws SQLException {
//
//    Statement stmt = null;
//    try {
//        stmt = con.createStatement(
//            ResultSet.TYPE_SCROLL_SENSITIVE
//            ResultSet.CONCUR_UPDATABLE);
//
//        ResultSet uprs = stmt.executeQuery(
//            "SELECT * FROM " + dbName +
//            ".COFFEES");
//
//        uprs.moveToInsertRow();
//        uprs.updateString("COF_NAME", coffeeName);
//        uprs.updateInt("SUP_ID", supplierID);
//        uprs.updateFloat("PRICE", price);
//        uprs.updateInt("SALES", sales);
//        uprs.updateInt("TOTAL", total);
//
//        uprs.insertRow();
//        uprs.beforeFirst();
//    } catch (SQLException e ) {
//        JDBCTutorialUtilities.printSQLException(e);
//    } finally {
//        if (stmt != null) { stmt.close(); }
//    }
//}
       //SQL ex here:
       // INSERT INTO Album (AlbumId, Title, ArtistId) 
       //VALUES (1, 'Waiting for the miracle', 2)
       //
       //1,2,3 (?,?,?)        
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
 // @cpfiles ex---public void addArtist(String name){
        //         logger.info("Added artist'"+name+"' to the database");
    //}
   // @cpfiles ex ---public int getArtist(String name)
   //                logger.info("not implemented");
   //                  return -1:
    //}
//    //@cpfiles ex was on or around line 31 
//       private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());


    //this.con = load.DriverManager
   // public void main connectChinookManager() {
        //this.con = DriverManager.getConnection((jdbc:sqlite:)) + load.ChinookManager.properties);
//        public void ChinookManager(){
//            this.loadDefaultProperties();
//           System.out.println(this.defaultProperties.getProperty("ChinookManager.properties"));
//        }