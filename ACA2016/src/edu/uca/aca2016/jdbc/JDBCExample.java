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
        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");

        while(rs.next()){
            String first_name = rs.getString("FirstName");
            String last_name = rs.getString("LastName");
            int id = rs.getInt("CustomerId");
            
            System.out.format("Customer: %d\t%-30.30s %-30.30s%n", id, first_name, last_name);
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
            
            ps = con.prepareStatement("INSERT INTO Customer (FirstName, LastName, Email) VALUES('Jane', 'Doe', 'jane@example.com')");
            ps.executeUpdate();
            
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        JDBCExample jdbce = new JDBCExample();
        
        String db = System.getProperty("user.home") + File.separator + "Chinook_Sqlite.sqlite";
        
        jdbce.connectAndInsert("jdbc:sqlite:" + db);
        jdbce.connectToAndQueryDatabase("jdbc:sqlite:" + db);
    }
}
