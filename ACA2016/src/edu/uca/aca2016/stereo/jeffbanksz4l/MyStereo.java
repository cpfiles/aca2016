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
    private boolean isPlaying = false;
    private boolean isPaused = false;

    /**
     * Setup the random generator between 1-1000. Defaulted Current Track Number
     * to 1. Set state of USB to true.
     */
    @Override
    public void loadUSB() {

        int bound = 1000;

        Random r = new Random();

        this.number_of_tracks = r.nextInt(bound);
        this.number_of_tracks++;
        this.isUSBLoaded = true;
        this.currentTrackNumber = 1;
        this.isPlaying = true;
    }

    /**
     * Returning true if USB has been loaded.
     *
     * @return
     */
    @Override
    public boolean isUSBLoaded() {
        return this.isUSBLoaded;
    }

    /**
     * Setup unLoadUSB to show isUSBLoaded is unloaded and the number of tracks
     * has been returned to 0.
     */
    @Override
    public void unloadUSB() {
        this.isUSBLoaded = false;
        this.number_of_tracks = 0;
    }

    /**
     * Returning the Current Track Number.
     *
     * @return The current track number.
     */
    @Override
    public int currentTrackNumber() {
        return this.currentTrackNumber;
    }

    /**
     * Returning the Total Track Count from the Random generator from the
     * loadUSB method.
     *
     * @return The total number of tracks
     */
    @Override
    public int totalTrackCount() {
        return this.number_of_tracks;
    }

    /**
     * Setup default to enable Straight Play Mode with Shuffle Play Mode
     * disabled.
     */
    @Override
    public void enableStraightPlayMode() {
        this.enableStraightPlayMode = true;
    }

    /**
     * Setup default to enable Shuffle Play Mode with Straight Play Mode
     * disabled.
     */
    @Override
    public void enableShufflePlayMode() {
        this.enableStraightPlayMode = false;
    }

    /**
     * Setup isStopped if stopped and isPlaying has to be false.
     */
    @Override
    public void stop() {
        this.isPaused = true;
        this.isPlaying = false;
    }

    /**
     * Setup isPaused if paused and isPlaying has to be false.
     */
    @Override
    public void pause() {
        this.isPaused = true;
        this.isPlaying = false;
    }

    /**
     * Setup Next Track to advance forward one track if in Straight Play Mode
     * and to loop back to the beginning if the last track has been reached.
     * Also, setup to generate a random number if Shuffle Play Mode in enabled.
     */
    @Override
    public void nextTrack() {
        if (!isUSBLoaded && !isPlaying) {
            return;
        }

        if (this.enableStraightPlayMode) {
            this.currentTrackNumber++;

            if (this.currentTrackNumber > this.number_of_tracks) {
                this.currentTrackNumber = 1;
            }
        } else {
            int bound = number_of_tracks;
            Random r = new Random();
            this.currentTrackNumber = r.nextInt(bound);
            this.currentTrackNumber++;
        }
    }

    /**
     * Setup Previous Track to advance backwards one track if in Straight Play
     * Mode and to loop back to the end if at the first track has been reached.
     * Also, setup to generate a random number if Shuffle Play Mode in enabled.
     */
    @Override
    public void previousTrack() {
        if (!isUSBLoaded && !isPlaying) {
            return;
        }

        if (this.enableStraightPlayMode) {
            this.currentTrackNumber--;

            if (this.currentTrackNumber > this.number_of_tracks) {
                this.currentTrackNumber = 1;
            }
        } else {
            int bound = this.number_of_tracks;
            Random r = new Random();
            this.currentTrackNumber = r.nextInt(bound);
            this.currentTrackNumber++;
        }
    }

    /**
     * Returned isPlaying to true when isPaused and isStopped are false.
     *
     * @return
     */
    @Override
    public boolean isPlaying() {
        return this.isPlaying;
    }

    /**
     * Returned isPaused to true when isPlaying and isStopped are false.
     *
     * @return
     */
    @Override
    public boolean isPaused() {
        return this.isPaused;
    }
}
