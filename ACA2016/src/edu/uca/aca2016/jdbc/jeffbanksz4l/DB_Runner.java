/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jeffbanksz4l;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.lang.String;

/**
 *
 * @author jeffb
 */
public class DB_Runner {
    
    

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws SQLException, IOException {
        ChinookManager CM = new ChinookManager();
        String file = "C:\\Users\\jeffb\\Desktop\\Artist List.csv";

//        CM.addArtist("Benny Goodman");
//        System.out.println("---------------------------------------------");
//        CM.getArtist("Benny Goodman");
//        System.out.println("---------------------------------------------");
//        CM.updateArtist(276, "Glenn Miller");
//        System.out.println("---------------------------------------------");
//        CM.deleteArtist(276);
//        System.out.println("---------------------------------------------");
        
//        CM.batchLoadArtist("C:\\Users\\jeffb\\Desktop\\Artist List.csv", 0);
        
    }
}
