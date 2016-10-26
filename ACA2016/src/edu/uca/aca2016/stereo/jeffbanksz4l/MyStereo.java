/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.jeffbanksz4l;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 * Initializing MyStereo class.
 *
 * @author jeffb
 */
public class MyStereo implements Stereo {

    private int number_of_tracks;
    private int currentTrackNumber;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;

    /**
     * Setup the random generator between 1-1000. Defaulted Current Track Number
     * to 1. Set state of USB to true.
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
     * Returning true if USB has been loaded.
     * 
     * @return
     */
    @Override
    public boolean isUSBLoaded() {
        return isUSBLoaded;
    }

    /**
     * Setup unLoadUSB to show isUSBLoaded is unloaded and the number of tracks
     * has been returned to 0.
     */
    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        number_of_tracks = 0;
    }

    /**
     * Returning the Current Track Number.
     *
     * @return The current track number.
     */
    @Override
    public int currentTrackNumber() {
        return currentTrackNumber;
    }

    /**
     * Returning the Total Track Count from the Random generator from the
     * loadUSB method.
     *
     * @return The total number of tracks
     */
    @Override
    public int totalTrackCount() {
        return number_of_tracks;
    }

    /**
     * Setup default to enable Straight Play Mode with Shuffle Play Mode
     * disabled.
     */
    @Override
    public void enableStraightPlayMode() {
        enableStraightPlayMode = true;
        enableShufflePlayMode = false;
    }

    /**
     * Setup default to enable Shuffle Play Mode with Straight Play Mode
     * disabled.
     */
    @Override
    public void enableShufflePlayMode() {
        enableShufflePlayMode = true;
        enableStraightPlayMode = false;
    }

    /**
     * Setup isStopped if stopped and isPlaying has to be false.
     */
    @Override
    public void stop() {
        isStopped = true;
        isPlaying = false;
    }

    /**
     * Setup isPaused if paused and isPlaying has to be false.
     */
    @Override
    public void pause() {
        isPaused = true;
        isPlaying = false;
    }

    /**
     * Setup Next Track to advance forward one track if in Straight Play 
     * Mode and to loop back to the beginning if the last track has been reached.
     * Also, setup to generate a random number if Shuffle Play Mode in enabled.
     */
    @Override
    public void nextTrack() {
        if (isUSBLoaded && isPlaying) {
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
    }

    /**
     * Setup Previous Track to advance backwards one track if in Straight Play 
     * Mode and to loop back to the end if at the first track has been reached.
     * Also, setup to generate a random number if Shuffle Play Mode in enabled.
     */
    @Override
    public void previousTrack() {
        if (isUSBLoaded && isPlaying) {
            if (enableStraightPlayMode) {
                currentTrackNumber--;
                if (currentTrackNumber < 1) {
                    currentTrackNumber = number_of_tracks;
                } else if (enableShufflePlayMode) {
                    int bound = number_of_tracks;
                    Random r = new Random();
                    currentTrackNumber = r.nextInt(bound);
                    currentTrackNumber++;
                }
            }
        }
    }

    /**
     * Returned isPlaying to true when isPaused and isStopped are false.
     *      
     * @return
     */
    @Override
    public boolean isPlaying() {
        isPaused = false;
        isStopped = false;
        return isPlaying = true;
    }

    /**
     * Returned isPaused to true when isPlaying and isStopped are false.
     *
     * @return
     */
    @Override
    public boolean isPaused() {
        isPlaying = false;
        isStopped = false;
        return isPaused = true;
    }
}
