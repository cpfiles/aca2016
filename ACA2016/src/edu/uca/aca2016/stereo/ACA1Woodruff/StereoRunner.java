/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author awood
 */
public class StereoRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MyStereo m = new MyStereo(); 
    
       for (int x = 0; x < 4; x++){
           System.out.println("Playing (false): "+ m.isPlaying());
           m.loadUSB();
           System.out.println("Track Count: " + m.totalTrackCount());
           System.out.println("Playing (true):" + m.isPlaying());
           
           System.out.println("Straight Play:");
           for (int i = 1; i <m.totalTrackCount() + 1; i++){
               System.out.print(m.currentTrackNumber() + "");
               m.nextTrack();
           }
           System.out.println();
           
           for (int i = m.totalTrackCount() + 3; i > 0; i--){
               System.out.print(m.currentTrackNumber() + " ");
               m.previousTrack();
           }
           System.out.println();
           
           m.pause();
           System.out.println("Paused (true): " + m.isPaused());
           System.out.println("Playing (false): " + m.isPlaying());
           
           m.enableShufflePlayMode();
           
           for (int i = 0; i < 10; i++){
               m.nextTrack();
               System.out.print(m.currentTrackNumber() + " ");
           }
           System.out.println();
           
           for (int i = 0; i < 10; i++){
               m.previousTrack();
               System.out.print(m.currentTrackNumber() + " ");
           }
           System.out.println();
           
           m.stop();
           System.out.println("Paused (false): " + m.isPaused());
           System.out.println("Playing (false): " + m.isPlaying());
           
           m.enableStraightPlayMode(); // the enable straight play
           m.unloadUSB();
           System.out.println("Loaded (false): " + m.isUSBLoaded());
           System.out.println("Paused (false): " + m.isPaused());
           System.out.println("Playing (false): " + m.isPlaying());
           }
    }
//    Tracks.currentTrackNumber();
//    Tracks.isUSBLoaded();
//    Tracks.NumberOfTracks ();
//    Tracks.enableStraightPlayMode();
//    Tracks.enableShufflePlayMode ();
//    Tracks.isPlaying();
//    Tracks.isPaused();
//    Tracks.isStopped();
//    
//    System.out.println
//    
//    {
//            
//        // TODO code application logic here
    }
    

