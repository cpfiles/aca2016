/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.snake0517;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author brela
 */
public class Runner {

     
    public static void main(String[] args) {
        MyStereo Tracks = new MyStereo();
        
        
       
        
        
        
        
        Tracks.currentTrackNumber();
        Tracks.loadUSB();
        Tracks.isUSBLoaded();
        Tracks.enableShufflePlayMode();
         for (int i = 0; i < 10; i++) {
                Tracks.nextTrack();
                System.out.print(Tracks.currentTrackNumber() + " ");
            }
            System.out.println();
      
        
        
        System.out.println("Number of Tracks: " + Tracks.totalTrackCount());
    
        System.out.println("USB Loaded?: " + Tracks.isUSBLoaded());
    }
    
}
