/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.jrob582;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author johna
 */
public class MyStereo implements Stereo {

    private int number_of_tracks;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private int currentTrackNumber;

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
        isUSBLoaded = false;
        this.number_of_tracks = 0;
    }

    /**
     * This method should return the number of the current track that is
     * "playing".
     *
     * @return The current track number.
     */
    @Override
    public int currentTrackNumber() {

        return currentTrackNumber;

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
     * Move to the previous track.
     */
    @Override
    public void previousTrack() {
        if (isUSBLoaded && isPlaying) {
            if (enableStraightPlayMode) {
                currentTrackNumber--;
                if (currentTrackNumber < number_of_tracks) {
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
     * Tell the caller if the stereo is playing.
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
     * Tell the caller if the stereo has been paused.
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
