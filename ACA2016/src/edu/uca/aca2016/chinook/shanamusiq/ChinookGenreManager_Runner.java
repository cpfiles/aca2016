/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.shanamusiq;

import java.sql.SQLException;

/**
 *
 * @author Shana
 */
public class ChinookGenreManager_Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ChinookGenreManager cmg = new ChinookGenreManager();
        cmg.getGenres();
        cmg.addGenre("Reggae");
        System.out.println(cmg.getGenreName(12));
        cmg.updateGenre(10, "R&B");
        cmg.deleteGenre(20);
    }
    
}
