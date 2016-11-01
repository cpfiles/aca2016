/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.jeffbanksz4l;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author jeffb
 */
public class StereoRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MyStereo myTracks = new MyStereo();
        
        Path f = Paths.get("C:\\Users\\jeffb\\Desktop\\Banks_MyPlayList.txt");
        myTracks.loadTrackList(f.toFile());
        
        myTracks.loadUSB();
        System.out.println("Number of Tracks: " + myTracks.totalTrackCount());
        System.out.println("Loaded: " + myTracks.isUSBLoaded());
        System.out.println("Current Tack Number: " + myTracks.currentTrackNumber());
//        System.out.println("Is Playing: " + myTracks.isPlaying());

//        myTracks.isUSBLoaded();
//        System.out.println("Loaded: " + myTracks.isUSBLoaded());

//        myTracks.unloadUSB();
//        System.out.println("Unload USB: " + myTracks.isUSBLoaded());
//        System.out.println("Total Track Count: " + myTracks.totalTrackCount());

//        myTracks.currentTrackNumber();
//        System.out.println("Current Track Number: " + myTracks.currentTrackNumber());
        
//        myTracks.totalTrackCount();
//        System.out.println("Total Track Count: " + myTracks.totalTrackCount());

        myTracks.nextTrack();
        System.out.println("Next Track: " + myTracks.currentTrackNumber());
        
        

    }

}
