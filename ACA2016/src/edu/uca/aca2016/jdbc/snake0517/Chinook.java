/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.snake0517;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author brela
 */
public class Chinook {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {
        ChinookManager Chinook = new ChinookManager();
        Chinook.addArtist("Bob Rightp");
        Chinook.getArtist("Bob Rightp");
        
    }
    
}
