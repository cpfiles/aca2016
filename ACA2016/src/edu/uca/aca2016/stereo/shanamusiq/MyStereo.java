
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
import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author Shana
 */
public class MyStereo implements Stereo {

    private static final int STOPPED = 0;
    private static final int PLAYING = 1;
    private static final int PAUSED = 2;
    private int state = STOPPED;
    private static final int MAXTRACKS = 1000;
    private boolean shuffle = false;
    private int currentTrack = 1;
    private int previousTrack = 1;
    private int minTrack = 1;
    private int maxTrack = 1000;
    private boolean loadedUSB = false;
    Random rand = new Random();
    //This method should load mp3s from a USB drive.

    @Override
    public void loadUSB() {
        if (loadedUSB) {
            return;
        }
        maxTrack = rand.nextInt(MAXTRACKS) + 1;
        loadedUSB = true;
    }
    //This method tells the caller if the USB drive has been scanned for MP3 file

    @Override
    public void isUSBLoaded() {
        if (loadedUSB) {
            System.out.println("USB is loaded.");
        } else {
            System.out.println("USB is not loaded.");
        }
    }

    //This method unloads the USB drive by resetting counts & counters.
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

    // Returns the total number of tracks loaded from the USB drive.
    @Override
    public int totalTrackCount() {
        return maxTrack;
    }

    //Method plays tracks in sequential order.
    @Override
    public void enableStraightPlayMode() {
        shuffle = false;
        currentTrack = 1;
        previousTrack = 1;
    }

    //Method plays tracks in random order.
    @Override
    public void enableShufflePlayMode() {
        shuffle = true;
        currentTrack = rand.nextInt(maxTrack);
        previousTrack = currentTrack;
    }

    //Method stops playing.
    @Override
    public void stop() {
        state = STOPPED;
    }

    //Pauses playing when playing
    @Override
    public void pause() {
        if (state == PLAYING) {
            state = PAUSED;
        }

    }

    //Method to advance to next track.
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

    //Method to move to previous track.
    @Override
    public void previousTrack() {
        if (!loadedUSB) {
            return;
        }
        currentTrack = previousTrack;
    }

    //Method tells caller if stereo is playing.
    @Override
    public boolean isPlaying() {
        return (state == PLAYING);
    }

    //Method tells caller if stereo is paused.
    @Override
    public boolean isPaused() {
        return (state == PAUSED);
    }

}
