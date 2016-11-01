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
    *  such as isUSBLoaded, isPlaying, and generates trackTotal
    *  Defaults on Straight Play mode.
     */
    public void loadUSB() {
        isUSBLoaded = true;
        isPlaying = true;
        isPlayingStraight = true;
        Random genTL = new Random();
        trackTotal = (genTL.nextInt(1000) + 1);
        while (trackTotal == 0) {
            trackTotal++;
            break;
        }
    }

    /*
    *  checks if USB device is loaded, providing appropriate message
    *  in relation to current device state
     */
    public boolean isUSBLoaded() {
        return isUSBLoaded;
    }

    /*
    *  reverts all ints to 0 and all booleans to false.
     */
    public void unloadUSB() {
        isUSBLoaded = false;
        while (isUSBLoaded == false) {
            currentTrack = 0;
            trackTotal = 0;
            isPlayingStraight = false;
            isPlayingShuffle = false;
            isPlaying = false;
            isPaused = false;
            isStopped = false;
            break;
        }
    }

    /*
    *  Generates and returns a current track number, defaulting at first track
     */
    public int currentTrackNumber() {
        return currentTrack;
    }

    /*
    *  returns trackTotal
     */
    public int totalTrackCount() {
        return trackTotal;
    }

    /*
    * establishes and stores appropriate states for Straight Play mode.
     */
    public void enableStraightPlayMode() {
        isPlaying = true;
        isPlayingStraight = true;
        isPlayingShuffle = false;
        isPaused = false;
        isStopped = false;
    }


    /*
    * establishes and stores appropriate states for Shuffle Play mode.
     */
    public void enableShufflePlayMode() {
        isPlaying = true;
        isPlayingShuffle = true;
        isPlayingStraight = false;
        isPaused = false;
        isStopped = false;
    }

    /*
    * stops all play modes and reverts back to first track
     */
    public void stop() {
        isStopped = true;
        currentTrack = 1;
        isPlaying = false;
        isPaused = false;

    }

    /*
    *  Pauses music without reverting other variables
     */
    public void pause() {
        isPaused = true;
        isPlayingStraight = false;
        isPlayingShuffle = false;
        isPlaying = false;
        isStopped = false;

    }

    /*
    *  moves to next track in list. if on last track of list while on Straight
    *  Play mode, loops back to first track.  On Shuffle Play, moves to random
    *  track w/in trackTotal
     */
    public void nextTrack() {
        isPaused = false;
        isStopped = false;
        if (isPlayingStraight == true) {
            if (currentTrack == trackTotal) {
                currentTrack = (trackTotal - (trackTotal - 1));
            } else {
                do {
                    currentTrack++;
                    break;
                } while (currentTrack != trackTotal);
            }
        } else if (isPlayingShuffle == true) {
            Random curTrack = new Random();
            currentTrack = (curTrack.nextInt(trackTotal) + 1);
        }

    }

    /*
    *  moves to previous track in list. if on first track of list while on Straight
    *  Play mode, loops back to first track.  On Shuffle Play, moves to random
    *  track w/in trackTotal
     */
    public void previousTrack() {
        isPaused = false;
        isStopped = false;
        if (isPlayingStraight == true) {
            if (currentTrack == (trackTotal - (trackTotal - 1))) {
                currentTrack = trackTotal;
            } else {
                do {
                    currentTrack--;
                    break;
                } while (currentTrack != trackTotal);
            }
        } else if (isPlayingShuffle == true) {
            Random curTrack = new Random();
            currentTrack = (curTrack.nextInt(trackTotal) + 1);
        }

    }

    //returns isPlaying
    public boolean isPlaying() {
        if (isPlayingStraight == true || isPlayingShuffle == true) {
            isPlaying = true;
        }
        return isPlaying;
    }

    //returns isPaused
    public boolean isPaused() {
        return isPaused;
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
        try {
            Scanner s = new Scanner(trackListSource);
            while (s.hasNextLine()) {
                this.trackList.add(s.nextLine());
            }
            s.close();
        } catch (IOException ex) {
            new Exception("IO Error:" + ex.getMessage());
        }
    }

    /**
     * Restarts the playing process.
     */
    public void play() {
        this.currentTrack = 0;
        this.isPlayingStraight = true;
    }

    /**
     * Return a list of all the tracks that are loaded.
     *
     * @return
     */
    public ArrayList<String> getTrackList() {
        return this.trackList;
    }

    /**
     * Get the full file name of the current track
     *
     * @return The current track's file name.
     */
    public String getCurrentTrackFileName() {
        this.currentTrackEx = trackList.get(currentTrack);
        return this.currentTrackEx;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        MyStereo test = new MyStereo();
        File tl = new File("C:\\Users\\Carter\\Documents\\NetBeansProjects\\aca2016\\ACA2016\\resources\\io\\tracklist.txt");
        test.loadTrackList(tl);
        System.out.println(test.getTrackList());
        test.play();
        System.out.println(test.getCurrentTrackFileName());
        test.nextTrack();
        System.out.println(test.getCurrentTrackFileName());

    }

}
