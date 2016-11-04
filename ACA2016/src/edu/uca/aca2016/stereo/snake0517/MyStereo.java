/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.snake0517;

import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author brela
 */
public class MyStereo implements StereoExtended {
    
    private int number_of_tracks = 0;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int current_track = 0;
    private boolean isStopped = false;
    private List<String> tracks = new ArrayList<>();

    /**
     * This method should load mp3s from a USB drive.
     *
     * For our purposes, generate a random number of tracks between 1 and 1000.
     * This method should silently fail if the USB drive has already been loaded
     * and has not been unloaded.
     */
    @Override
    public void loadUSB() {
        int bound = 1000;
        
        Random r = new Random();
        
        number_of_tracks = r.nextInt(bound);
        number_of_tracks++;
        isUSBLoaded = true;
        current_track = 1;
        isPlaying = true;
    }

    /**
     * This method should tell the caller if the USB drive has been scanned for
     * mp3 files
     *
     * @return
     */
    @Override
    public boolean isUSBLoaded() {
        return isUSBLoaded;
        
    }

    /**
     * This method should unload the USB drive by resetting all of the counts
     * and counters.
     */
    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        this.number_of_tracks = 0;
        isPaused = false;
        isPlaying = false;
        
    }

    /**
     * This method should return the number of the current track that is
     * "playing".
     *
     * @return The current track number.
     */
    @Override
    public int currentTrackNumber() {
        
        return current_track;
    }

    /**
     * Return the total number of tracks loaded from the USB drive.
     *
     * @return The total number of tracks
     */
    @Override
    public int totalTrackCount() {
        
        return this.number_of_tracks;
    }

    /**
     * Plays the tracks in sequential order.
     *
     * For our purposes, this method should set the current track to the first
     * track and keep a record of the current track. Note the only way the
     * program moves to the next track is by calls to nextTrack and
     * previousTrack.
     */
    @Override
    public void enableStraightPlayMode() {
        enableStraightPlayMode = true;
        enableShufflePlayMode = false;
        
    }

    /**
     * Plays tracks in a random order.
     *
     * For our purposes, this method should set the current track to a random
     * track and keep a record of the current track. Note the only way the
     * program moves to the next track is by calls to nextTrack and
     * previousTrack.
     */
    @Override
    public void enableShufflePlayMode() {
        enableShufflePlayMode = true;
        enableStraightPlayMode = false;
    }

    /**
     * Stop the playing process.
     */
    @Override
    public void stop() {
        isStopped = true;
        isPlaying = false;
        isPaused = false;
    }

    /**
     * Pause the playing process.
     */
    @Override
    public void pause() {
        isPaused = true;
        isPlaying = false;
    }

    /**
     * Advance to the next track.
     */
    @Override
    public void nextTrack() {
        if (isUSBLoaded && isPlaying) {
            if (enableStraightPlayMode) {
                this.current_track++;
                if (this.current_track > number_of_tracks) {
                    this.current_track = 1;
                }
            } else if (enableShufflePlayMode) {
                int bound = number_of_tracks;
                Random r = new Random();
                this.current_track = r.nextInt((bound) + 1);
            }
            
        }
    }

    /**
     * Move to the previous track.
     */
    @Override
    public void previousTrack() {
        if (isUSBLoaded && isPlaying) {
            if (enableStraightPlayMode) {
                this.current_track--;
                if (this.current_track == 0) {
                    this.current_track = number_of_tracks;
                }
            } else if (enableShufflePlayMode) {
                int bound = number_of_tracks;
                Random r = new Random();
                this.current_track = r.nextInt((bound) + 1);
            }
            
        }
    }

    /**
     * Tell the caller if the stereo is playing.
     *
     * @return
     */
    @Override
    public boolean isPlaying() {
        
        return isPlaying;
        
    }

    /**
     * Tell the caller if the stereo has been paused.
     *
     * @return
     */
    @Override
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
    @Override
    public void loadTrackList(File trackListSource) throws IOException {
        Scanner s = null;
        
        try {
            s = new Scanner(new BufferedReader(new FileReader(trackListSource)));
            while (s.hasNext()) {
              System.out.println(s.next());
                String e = null;
                tracks.add(current_track, e);
            }
        }
            catch(IOException e){
                    System.err.println("Caught IOException" + e.getMessage());
                    }
                    
                
         finally {
            if (s != null) {
                
            }
        }
    }

    /**
     * Restarts the playing process.
     */
    @Override
    public void play() {
        if (isUSBLoaded = true) {
        isPlaying = true;
        isPaused = false;
        isStopped = false;
        }
    }

    /**
     * Return a list of all the tracks that are loaded.
     *
     * @return
     */
    @Override
    public ArrayList<String> getTrackList() {
        return (ArrayList<String>) tracks;
        
    }

    /**
     * Get the full file name of the current track
     *
     * @return The current track's file name.
     */
    @Override
    public String getCurrentTrackFileName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
