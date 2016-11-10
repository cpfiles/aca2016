/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc;

import java.io.File;
import java.sql.*;

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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        JDBCExample jdbce = new JDBCExample();
        
        String db = System.getProperty("user.home") + File.separator + "Chinook_Sqlite.sqlite";
        
        jdbce.connectToAndQueryDatabase("jdbc:sqlite:" + db);
    }
}
