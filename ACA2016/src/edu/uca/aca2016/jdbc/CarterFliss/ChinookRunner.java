/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.CarterFliss;

import java.sql.*;

/**
 *
 * @author Carter
 */
public class ChinookRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        /**
         * test runner file constructs and goes through all methods in
         * ChinookManager.java, returning results
         */
        ChinookManager t = new ChinookManager();
        t.addArtist("GWAR");
        System.out.println("ArtistId = " + t.getArtist("gwar"));
        System.out.println("Update was Successful? " + t.updateArtist(276, "The Casualties"));
        System.out.println("Delete was Successful? " + t.deleteArtist(276));
        
        
        
    }
    
}
