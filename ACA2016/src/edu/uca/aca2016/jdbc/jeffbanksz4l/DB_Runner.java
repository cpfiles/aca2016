/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jeffbanksz4l;

import java.sql.SQLException;

/**
 *
 * @author jeffb
 */
public class DB_Runner {

    /**
     * @param args the command line arguments
     * @param rowcount
     * @param Artist
     * @throws java.sql.SQLException
     */
    public static void main(String[] args, String rowcount, String Artist) throws SQLException {
        ChinookManager CM = new ChinookManager();

//        String db = System.getProperty("user.home") + File.separator + "Chinook_Sqlite.sqlite";
//        CM.addArtist("Benny Goodman");
//        System.out.println("---------------------------------------------");
//        CM.getArtist("Benny Goodman");
//        System.out.println("---------------------------------------------");
//        CM.updateArtist(276, "Glenn Miller");
//        System.out.println("---------------------------------------------");
        CM.deleteArtist(276);
        System.out.println("---------------------------------------------");
    }
}
