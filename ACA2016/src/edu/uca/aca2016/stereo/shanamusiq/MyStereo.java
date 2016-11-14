
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.shanamusiq;

/**
 *
 * @author Shana
 */
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Shana
 */
public class MyStereo implements StereoExtended {

    private static final int STOPPED = 0;
    private static final int PLAYING = 1;
    private static final int PAUSED = 2;
    private int state = STOPPED;
    private static final int MAXTRACKS = 1000;
    private boolean shuffle = false;
    private int currentTrack = 1;
    private int previousTrack = 1;
    private int minTrack = 1;
    private int maxTrack = MAXTRACKS;
    private boolean loadedUSB = false;
    Random rand = new Random();
    
   /*This method should load mp3s from a USB drive.
    *
    *
    */
            
    @Override
    public void loadUSB() {
        if (loadedUSB) {
            return;
        }
        maxTrack = rand.nextInt(MAXTRACKS) + 1;
        loadedUSB = true;
        state = PLAYING;
    }
    /**This method tells the caller if the USB drive has been scanned for MP3 file
     *
     *
     */
    
    @Override
    public boolean isUSBLoaded() {
//        if (loadedUSB) {
//            System.out.println("USB is loaded.");
//        } else {
//            System.out.println("USB is not loaded.");
//        }
//        logger.info
        return loadedUSB;
    }

    /**This method unloads the USB drive by resetting counts & counters.
    *
    * 
    */
    
    @Override
    public void unloadUSB() {
        loadedUSB = false;
        currentTrack = 1;
        previousTrack = 1;
    }

    /**
     * This method returns the number of the current track that is "playing".
     *
     * @return The current track number.
     */
    @Override
    public int currentTrackNumber() {
        return currentTrack;
    }

    /** Returns the total number of tracks loaded from the USB drive.
     * 
     * @return 
     */
    @Override
    public int totalTrackCount() {
        return maxTrack;
    }

    /**Method plays tracks in sequential order.
     *
     * 
     */
    @Override
    public void enableStraightPlayMode() {
        shuffle = false;
//        currentTrack = 1;
//        previousTrack = 1;
    }

    /**Method plays tracks in random order.
     *
     * 
     */
    @Override
    public void enableShufflePlayMode() {
        shuffle = true;
    }

    /**Method stops playing.
     * 
     */
    @Override
    public void stop() {
        state = STOPPED;
    }

    /**Pauses playing when playing
     * 
     */
    @Override
    public void pause() {
        if (state == PLAYING) {
            state = PAUSED;
        }

    }

    /**Method to advance to next track.
     * 
     */
    @Override
    public void nextTrack() {
        if (!loadedUSB) {
            return;
        }
        if (shuffle) {
            previousTrack = currentTrack;
            currentTrack = rand.nextInt(maxTrack);
        } else if (currentTrack == maxTrack) {
            previousTrack = currentTrack;
            currentTrack = 1;
        } else {
            previousTrack = currentTrack;
            currentTrack++;
        }
    }

    /**Method to move to previous track.
     * 
     */
    @Override
    public void previousTrack() {
        if (!loadedUSB) {
            return;
        }
        currentTrack = previousTrack;
    }

    /**Method tells caller if stereo is playing.
    *        
    */       
    
    @Override
    public boolean isPlaying() {
        return (state == PLAYING);
    }

    /**Method tells caller if stereo is paused.
     * 
     * @return 
     */
    @Override
    public boolean isPaused() {
        return (state == PAUSED);
    }
    
    ArrayList<String> trackList = new ArrayList<>();
    
     /**
     * Loads a list of track names from the specified file.
     * 
     * The file is a plain text file that contains one track name per line. For
     * example:
     *  Song 1.mp3
     *  Song 2.mp3
     *  Song 4.mp3
     * 
     * @param trackListSource A file that contains a list of mp3 tracks. There
     * is one track per line.
     * @throws IOException Any IO exceptions are caught and re-thrown as this 
     * type of exception
     */
    @Override
    public void loadTrackList(File trackListSource) throws IOException {
       Scanner input = new Scanner(trackListSource);
       String line;
        while (input.hasNextLine()) {
           line = input.nextLine();
           trackList.add(line);
        }
    }
    
    /**
     * Restarts the playing process.
     */
    @Override
    public void play() {
        if(loadedUSB) state = PLAYING;
    }        

    /**
     * Return a list of all the tracks that are loaded.
     * @return
     */
    @Override
    public ArrayList<String> getTrackList() {
        return trackList;
    }
    /**
     * Get the full file name of the current track
     * @return The current track's file name.
     */
    @Override
    public String getCurrentTrackFileName() {
        if(!loadedUSB) return null;
        if(currentTrack > trackList.size()) return null;
       return trackList.get(currentTrack - 1);
    }

}
