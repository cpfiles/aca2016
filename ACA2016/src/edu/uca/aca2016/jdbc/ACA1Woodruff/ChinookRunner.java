/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.ACA1Woodruff;


import java.sql.SQLException;
import java.io.IOException;

/**
 *
 * @author awood
 */
public class ChinookRunner {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {
    ChinookManager ChinookRunner = new ChinookManager();
//    ChinookRunner.addArtist("Fleetwood Mack");
//    ChinookRunner.getArtist ("Fleetwood Mack");
//    ChinookRunner.updateArtist (276, "Fleetwood Mac");
       ChinookRunner.deleteArtist(276);
    
    }
   
}        

    

