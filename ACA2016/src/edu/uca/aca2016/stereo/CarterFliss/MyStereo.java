/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.CarterFliss;

/**
 *
 * @author Carter
 */
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyStereo implements StereoExtended {

    /**
     * @param args the command line arguments
     *
     * instantiating the variables necessary for the rest of the program
     * clarification: isPlaying only stores whether stereo is currently playing,
     * regardless of current play mode. isPlayingStraight and isPlayingShuffle
     * stores value of which play mode stereo is currently in.
     */
    private int trackTotal;
    private boolean isPlaying = false;
    private boolean isPlayingStraight = false;
    private boolean isPlayingShuffle = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private boolean isUSBLoaded = false;
    private int currentTrack;
    ArrayList<String> trackList = new ArrayList<String>();
    String currentTrackEx = new String();

    /*
    *  loads USB device and enables starting variables
    *  such as isUSBLoaded, isPlaying, and generates trackTotal based on 
    *  trackList.size() (-1 so other methods reference the correct indeces)
    *  Defaults on Straight Play mode.
     */
    
    public void loadUSB() {
//        this.isUSBLoaded = true;
//        this.isPlaying = true;
//        this.isPlayingStraight = true;
//         this.trackTotal = (this.trackList.size() - 1);
//        while (this.trackTotal == 0) {
//            this.trackTotal++;
//            break;
//        }
    return;
    }

    /*
    *  checks if USB device is loaded
     */
    public boolean isUSBLoaded() {
        return this.isUSBLoaded;
    }

    /*
    *  reverts all ints to 0 and all booleans to false.
     */
    public void unloadUSB() {
        this.isUSBLoaded = false;
        while (this.isUSBLoaded == false) {
            this.currentTrack = 0;
            this.trackTotal = 0;
            this.trackList.clear();
            this.isPlayingStraight = false;
            this.isPlayingShuffle = false;
            this.isPlaying = false;
            this.isPaused = false;
            this.isStopped = false;
            break;
        }
    }

    /*
    *  returns current track number
    *  adds +1 to currentTrack because of index reference changes
    *  established in loadUSB method.  Returns 0 if trackList is empty.
     */
    public int currentTrackNumber() {
        if (this.trackList.isEmpty()) {
            return 0;
        } else {
            return (this.currentTrack + 1);
        }
    }

    /*
    *  returns trackTotal
     *  adds +1 to trackTotal because of index reference changes
    *  established in loadUSB method.  Returns 0 if trackList is empty.
     */
    public int totalTrackCount() {
        if (this.trackList.isEmpty()) {
            return 0;
        } else {
            return (this.trackTotal + 1);
        }
    }

    /*
    * establishes and stores appropriate states for Straight Play mode.
     */
    public void enableStraightPlayMode() {
        this.isPlaying = true;
        this.isPlayingStraight = true;
        this.isPlayingShuffle = false;
        this.isPaused = false;
        this.isStopped = false;
    }


    /*
    * establishes and stores appropriate states for Shuffle Play mode.
     */
    public void enableShufflePlayMode() {
        this.isPlaying = true;
        this.isPlayingShuffle = true;
        this.isPlayingStraight = false;
        this.isPaused = false;
        this.isStopped = false;
    }

    /*
    * stops all play modes and reverts back to first track
     */
    public void stop() {
        this.isStopped = true;
        this.currentTrack = 0;
        this.isPlaying = false;
        this.isPaused = false;

    }

    /*
    *  Pauses music without reverting other variables
    *  Change
     */
    public void pause() {
        this.isPaused = true;
        this.isPlaying = false;
        this.isStopped = false;

    }

    /*
    *  moves to next track in list. if on last track of list while on Straight
    *  Play mode, loops back to first track.  On Shuffle Play, moves to random
    *  track w/in track list
     */
    public void nextTrack() {
        this.isPaused = false;
        this.isStopped = false;
        if (this.isPlayingStraight == true) {
            if (this.currentTrack >= this.trackTotal) {
                this.currentTrack = 0;
            } else {
                do {
                    this.currentTrack++;
                    break;
                } while (this.currentTrack != this.trackTotal);
            }
        } else if (this.isPlayingShuffle == true) {
            Random curTrack = new Random();
            this.currentTrack = (curTrack.nextInt(this.trackTotal) + 1);
        }

    }

    /*
    *  moves to previous track in list. if on first track of list while on Straight
    *  Play mode, loops back to first track.  On Shuffle Play, moves to random
    *  track w/in track list
     */
    public void previousTrack() {
        this.isPaused = false;
        this.isStopped = false;
        if (this.isPlayingStraight == true) {
            if (this.currentTrack <= 0) {
                this.currentTrack = this.trackTotal;
            } else {
                do {
                    this.currentTrack--;
                    break;
                } while (this.currentTrack != this.trackTotal);
            }
        } else if (this.isPlayingShuffle == true) {
            Random curTrack = new Random();
            this.currentTrack = (curTrack.nextInt(this.trackTotal) + 1);
        }

    }

    //returns isPlaying
    public boolean isPlaying() {
        return this.isPlaying;
    }

    //returns isPaused
    public boolean isPaused() {
        return this.isPaused;
    }

    /**
     * Loads a list of track names from the specified file.
     *
     * The file is a plain text file that contains one track name per line. For
     * example: Song 1.mp3 Song 2.mp3 Song 4.mp3
     *
     * @param trackListSource A file that contains a list of mp3 tracks. There
     * is one track per line.
     * @throws IOException Any IO exceptions are caught and re-thrown as this
     * type of exception
     */
    public void loadTrackList(File trackListSource) {
        Scanner s = null;
        this.isUSBLoaded = true;
        this.isPlaying = true;
        this.isPlayingStraight = true;
        
        try {
            s = new Scanner(trackListSource);
            while (s.hasNextLine()) {
                this.trackList.add(s.nextLine());
            }
            s.close();
            this.trackTotal = (this.trackList.size() - 1);
        } catch (IOException ex) {
            new Exception("IO Error:" + ex.getMessage());
        } 
        
    }

    /**
     * Restarts the playing process.
     */
    public void play() {
        this.isPlaying = true;
        this.isPaused = false;
        this.isStopped = false;
    }

    /**
     * Return a list of all the tracks that are loaded.
     *
     * @return
     */
    public ArrayList<String> getTrackList() {
        if (this.trackList.isEmpty()) {
            return null;
        } else {
            return this.trackList;
        }
    }

    /**
     * Get the full file name of the current track
     *
     * @return The current track's file name.
     */
    public String getCurrentTrackFileName() {
        if (this.trackList.isEmpty()) {
            return null;
        } else {
            return this.currentTrackEx = this.trackList.get(this.currentTrack);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        MyStereo t = new MyStereo();
//        File tl = new File("C:\\Users\\Carter\\Documents\\NetBeansProjects\\aca2016\\ACA2016\\resources\\io\\tracklist.txt");
//        t.loadUSB();
//        t.loadTrackList(tl);
//        
//        
//        System.out.println(t.getTrackList());
//        System.out.println(t.currentTrackNumber());
//        System.out.println(t.getCurrentTrackFileName());
//        t.previousTrack();
//        System.out.println(t.currentTrackNumber());
//        System.out.println(t.getCurrentTrackFileName());
//        t.previousTrack();
//        System.out.println(t.currentTrackNumber());
//        System.out.println(t.getCurrentTrackFileName());
//        t.previousTrack();
//        System.out.println(t.currentTrackNumber());
//        System.out.println(t.getCurrentTrackFileName());
    }

}
