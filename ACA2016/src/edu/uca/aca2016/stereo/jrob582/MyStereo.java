/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.jrob582;

import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author johna
 */
public class MyStereo implements StereoExtended {

    private int number_of_tracks;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private int currentTrackNumber = 0;
    private final ArrayList<String> tracks = new ArrayList<>();

    /**
     * This method should load mp3s from a USB drive.
     *
     */
    @Override
    public void loadUSB() {

        int bound = 1000;

        Random r = new Random();

        number_of_tracks = r.nextInt(bound);
        number_of_tracks++;
        isUSBLoaded = true;
        currentTrackNumber = 1;
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
        this.isUSBLoaded = false;
        this.number_of_tracks = 0;
        this.currentTrackNumber = 0;
        this.isPlaying = false;
        this.isPaused = false;
    }

    /**
     * This method should return the number of the current track that is
     * "playing".
     *
     * @return The current track number.
     */
    @Override
    public int currentTrackNumber() {

        return this.currentTrackNumber;

    }

    /**
     * Return the total number of tracks loaded from the USB drive.
     *
     * @return The total number of tracks
     */
    @Override
    public int totalTrackCount() {

        return number_of_tracks;

    }

    /**
     * Plays the tracks in sequential order.
     *
     */
    @Override
    public void enableStraightPlayMode() {
        this.enableStraightPlayMode = true;
        this.enableStraightPlayMode = false;
    }

    /**
     * Plays tracks in a random order.
     *
     */
    @Override
    public void enableShufflePlayMode() {
        this.enableShufflePlayMode = true;
        this.enableShufflePlayMode = false;
    }

    /**
     * Stop the playing process.
     */
    @Override
    public void stop() {
        isStopped = true;
        isPlaying = false;

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
            return;
        }
        if (enableStraightPlayMode) {
            currentTrackNumber++;
            if (currentTrackNumber > number_of_tracks) {
                currentTrackNumber = 1;
            } else if (enableShufflePlayMode) {
                int bound = number_of_tracks;
                Random r = new Random();
                currentTrackNumber = r.nextInt(bound);
                currentTrackNumber++;
            }
        }
    }

    /**
     * Move to the previous track.
     */
    @Override
    public void previousTrack() {
        if (isUSBLoaded && isPlaying) {
            return;
        }
        if (enableStraightPlayMode) {
            currentTrackNumber--;
            if (currentTrackNumber < number_of_tracks) {
                currentTrackNumber = 0;
            } else if (enableShufflePlayMode) {
                int bound = number_of_tracks;
                Random r = new Random();
                currentTrackNumber = r.nextInt(bound);
                currentTrackNumber++;
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

        return this.isPlaying;
    }

    /**
     * Tell the caller if the stereo has been paused.
     *
     * @return
     */
    @Override
    public boolean isPaused() {

        return this.isPaused;

    }
        /**
     *  Checking loadTrackList method, of class MyStereo.
     *
     * @throws java.io.IOException
     */
    @Override
    public void loadTrackList(File trackListSource) throws IOException {

     try {
         try (Scanner s = new Scanner (trackListSource)) {
             while (s.hasNextLine()) {
                 tracks.add(s.nextLine());
             }
         }
         this.number_of_tracks = (this.tracks.size() - 1);
     } catch (IOException e){
         System.out.println("Caught IOException" + e.getMessage());
        
         
         }
     }
    /**
     * Checking to see if it's playing.
     */
    @Override
    public void play() {
        if (isUSBLoaded = true){
            isPlaying = true;
            isPaused = false;
            isStopped = false;

        }
    }

    @Override
    public ArrayList<String> getTrackList() {
        return this.tracks;
    }
    /**
     *  Getting TrackList method.
     */
    @Override
    public String getCurrentTrackFileName() {
        try {
            if (this.isUSBLoaded) {
                
                return this.tracks.get(currentTrackNumber - 1);
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

        return null;
    }
}
    