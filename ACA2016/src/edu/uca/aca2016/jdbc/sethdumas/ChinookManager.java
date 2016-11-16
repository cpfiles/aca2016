/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.sethdumas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sethd
 */
public class ChinookManager {
    
//Create a class constructor that takes zero parameters    
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

}
