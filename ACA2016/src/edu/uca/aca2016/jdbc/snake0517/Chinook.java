/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.snake0517;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.nio.file.Paths;

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
        File Artists = new File ("C:\\Users\\brela\\Desktop\\Artists.csv");
 
        Chinook.batchLoadArtist(Artists, 0);
//        Chinook.addArtist("Jimmy")
//        Chinook.getArtist("jimmy");
//        Chinook.updateArtist(334, "Charles");
//        Chinook.deleteArtist(334);

    }

}
