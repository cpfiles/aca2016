/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.jrob582;

/**
 *
 * @author johna
 */
public class ChinookGenreRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChinookGenreManager cm = new ChinookGenreManager();

//        cm.addGenre("Rock");
//        cm.getGenreName(17);
//      cm.updateGenre(17,"Jazz");
        cm.deleteGenre(17);

    }

}
