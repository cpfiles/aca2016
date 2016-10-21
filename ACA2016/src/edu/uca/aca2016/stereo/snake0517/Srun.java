/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.snake0517;

/**
 *
 * @author brela
 */
public class Srun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TheStereo Tracks = new TheStereo();
        
        Tracks.loadUSB();
        
        System.out.println("Tracks " + Tracks.totalTrackCount());
        
//        Tracks.unloadUSB();
        
        System.out.println("Loaded " + Tracks.isUSBLoaded());
        Tracks.enableShufflePlayMode();
        Tracks.previousTrack();
        System.out.println("Track Number " + Tracks.currentTrackNumber());
        Tracks.nextTrack();
        Tracks.pause();
       
        System.out.println("Track Number " + Tracks.currentTrackNumber());
    }
    
}
