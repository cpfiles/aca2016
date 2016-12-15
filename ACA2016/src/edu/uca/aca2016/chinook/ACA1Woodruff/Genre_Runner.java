/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.ACA1Woodruff;

import java.sql.SQLException;

/**
 *
 * @author awood
 */
public class Genre_Runner {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        ChinookGenreManager2 cm = new ChinookGenreManager2();
//       cm.addGenre("Celtic");
//       cm.getGenreName(26);
//       cm.updateGenre(26, "Celtic1");
       cm.deleteGenre (26);
    }

}
