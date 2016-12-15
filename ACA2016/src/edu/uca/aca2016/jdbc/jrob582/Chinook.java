/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jrob582;

import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author johna
 */
public class Chinook {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException,SQLException {
        ChinookManager ChinookManager = new ChinookManager();
        File Artist = new File ("C:\\Users\\johna\\Desktop\\Art.csv");
        ChinookManager.batchLoadArtist(Artist, 0);
  //      ChinookManager.addArtist("paul");
//        ChinookManager.getArtist("Paul");
//        ChinookManager.updateArtist(275,"Worship");
 //       ChinookManager.deleteArtist(276);
        
        
        
    }


    }
    

