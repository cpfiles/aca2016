/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cfiles
 */
public class JDBCExample{

    public void connectToAndQueryDatabase(String url) throws SQLException{
        Connection con = DriverManager.getConnection(url);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE CustomerID > 55");

        while(rs.next()){
            String first_name = rs.getString("FirstName");
            String last_name = rs.getString("LastName");
            String email = rs.getString("Email");
            int id = rs.getInt("CustomerId");
            
            System.out.format("Customer: %d\t%-30.30s %-30.30s %-30.30s %n", id, first_name, last_name, email);
        }
        
        stmt.close();
        con.close();
    }
    
    /**
     * Use a prepared statement to insert a row into the database.
     * 
     * https://en.wikipedia.org/wiki/SQL_injection
     * https://xkcd.com/327/
     * 
     * @param url
     * @throws SQLException 
     */
    
    public void connectAndInsert(String url) throws SQLException  {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DriverManager.getConnection(url);
            
            String sql = "INSERT INTO Customer (FirstName, LastName, Email) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "John");
            ps.setString(2, "Smith");
            ps.setString(3, "example@example.com");
            ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void connectAndUpdate(String url) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DriverManager.getConnection(url);
            
            String sql = "UPDATE Customer SET Email = ? WHERE Email= ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "john@example.com");
            ps.setString(2, "example@example.com");
            ps.executeUpdate();
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT CustomerID, FirstName FROM Customer WHERE Email = 'john@example.com'");
            if(rs.next()) {
                int id = rs.getInt("CustomerID");
                
                //rs.updateString("FirstName", "Jonathan");
                //rs.updateRow();
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE,ex.getMessage(),ex);
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void connectAndDelete(String url) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DriverManager.getConnection(url);
            
            String sql = "DELETE FROM Customer WHERE Email= ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "john@example.com");
            ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void countRecords(String url) throws SQLException {
        Connection con = DriverManager.getConnection(url);
        ResultSet rs;
        Statement stmt = con.createStatement();
        int rowcount = 0;
        
        // when you can do a insensitive type scroll on a small data set
        /*
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        rs = stmt.executeQuery("SELECT * FROM Customer WHERE CustomerID > 55");

        
        if (rs.last()) {
            rowcount = rs.getRow();
            rs.beforeFirst();   // not rs.first() because the rs.next() below will move on, missing the first element
        }
        
        while (rs.next()) {
            System.out.format("Customer: %d\t%-30.30s%n", rs.getInt("CustomerId"), rs.getString("LastName"));
        }
        */
        
        // when that is not available        
        rs = stmt.executeQuery("SELECT COUNT(*) AS CustomerCount FROM Customer WHERE CustomerID > 55");
        if (rs.next()) {
            rowcount = rs.getInt("CustomerCount");
        }
        
        System.out.println("There are " + rowcount + " rows");
        
        rs = stmt.executeQuery("SELECT * FROM Customer WHERE CustomerID > 55");
        while (rs.next()) {
            System.out.format("Customer: %d\t%-30.30s%n", rs.getInt("CustomerId"), rs.getString("LastName"));
        }

        stmt.close();
        con.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        JDBCExample jdbce = new JDBCExample();
        
        String db = System.getProperty("user.home") + File.separator + "Chinook_Sqlite.sqlite";
        
//        jdbce.connectAndInsert("jdbc:sqlite:" + db);
//        jdbce.connectToAndQueryDatabase("jdbc:sqlite:" + db);
//        System.out.println("---------------------------------------------");
//        jdbce.connectAndUpdate("jdbc:sqlite:" + db);
//        jdbce.connectToAndQueryDatabase("jdbc:sqlite:" + db);
//        System.out.println("---------------------------------------------");
//        jdbce.connectAndDelete("jdbc:sqlite:" + db);
//        jdbce.connectToAndQueryDatabase("jdbc:sqlite:" + db);
        
        jdbce.countRecords("jdbc:sqlite:" + db);
    }
}
