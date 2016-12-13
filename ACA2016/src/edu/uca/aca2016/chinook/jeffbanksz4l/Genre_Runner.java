/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.jeffbanksz4l;

import java.sql.SQLException;


/**
 *
 * @author jeffb
 */
public class Genre_Runner {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        ChinookGenreManager CM = new ChinookGenreManager();
        CM.getGenres();
        CM.addGenre("Gospel");
        CM.getGenreName(24);
        CM.updateGenre(26, "Worship");
        CM.deleteGenre(26);
    }
}
