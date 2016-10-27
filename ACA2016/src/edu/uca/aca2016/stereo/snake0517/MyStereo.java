/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.snake0517;

import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;

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

    // Sets state of player to load and starts the player going.
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

    //checks to see if device is loaded.
    @Override
    public boolean isUSBLoaded() {
        return isUSBLoaded;

    }

    // unloads usb drive and restes values 
    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        this.number_of_tracks = 0;
        isPaused = false;
        isPlaying = false;

    }

    // shows current track number
    @Override
    public int currentTrackNumber() {

        return current_track;
    }

    // Shows total track count
    @Override
    public int totalTrackCount() {

        return this.number_of_tracks;
    }

    // Plays next in seqeuntial order.
    @Override
    public void enableStraightPlayMode() {
        enableStraightPlayMode = true;
        enableShufflePlayMode = false;

    }

    // Plays random track within bound.
    @Override
    public void enableShufflePlayMode() {
        enableShufflePlayMode = true;
        enableStraightPlayMode = false;
    }

    // Stops track from playing
    @Override
    public void stop() {
        isStopped = true;
        isPlaying = false;
        isPaused = false;
    }

    // Pauses track 
    @Override
    public void pause() {
        isPaused = true;
        isPlaying = false;
    }

    // Plays next track depending on condition of straiaght play or shuffle.
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

    // Plays previous track depending on condition of striaght play or shuffle.
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
       

    // display Playing
    @Override
    public boolean isPlaying() {
      
        return isPlaying;

    }

    // display paused
    @Override
    public boolean isPaused() {
        
        return isPaused;
    }

    @Override
    public void loadTrackList(File trackListSource) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getTrackList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCurrentTrackFileName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
