/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.curiologic;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author xulix
 */
public class MyStereo implements Stereo {

    private Boolean isPaused = false;
    private Boolean isPlaying = false;
    private int number_of_tracks;
    private Boolean enableStraightPlayMode = true;
    private Boolean enableShufflePlayMode = false;
    private Boolean loadUSB = false;
    private int currentTrack;
    private boolean stop = false;
    private boolean pause = false;
    private boolean isUSBLoaded = false;
// loading the USB and returning the number of tracks on the USB

    @Override
    public void loadUSB() {
        int bound = 1000;
        Random gen = new Random();
        number_of_tracks = gen.nextInt(bound);
        number_of_tracks++;
        currentTrack = 1;
        isUSBLoaded = true;
        isPlaying = true;
    }
// determing if USB is loaded

    @Override
    public boolean isUSBLoaded() {

        return isUSBLoaded;
    }
// unloading USB and resetting values

    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        this.number_of_tracks = 0;

    }
// setting the current track that is playing

    @Override
    public int currentTrackNumber() {

        return this.currentTrack;
    }
// setting total number of tracks from the USB

    @Override
    public int totalTrackCount() {
        return number_of_tracks;
    }
// making the tracks move over forward forward or backward by 1 track at a time

    @Override
    public void enableStraightPlayMode() {
        enableShufflePlayMode = false;
        enableStraightPlayMode = true;
        isPlaying = true;
        isUSBLoaded = true;
        stop = false;
        this.currentTrack++;

    }
// allows tracks to move forward or backward to random tracks on USB

    @Override
    public void enableShufflePlayMode() {
        enableStraightPlayMode = false;
        enableShufflePlayMode = true;
        isPlaying = true;
        int bound = number_of_tracks;
        Random genS = new Random();
        currentTrack = genS.nextInt(bound);
        this.currentTrack++;

    }
// setting the conditions for stopping playback

    @Override
    public void stop() {
        isUSBLoaded = true;
        isPlaying = false;
        isPaused = false;
        stop = true;
    }
// setting conditions for pausing play mode

    @Override
    public void pause() {
        isUSBLoaded = true;
        isPlaying = false;
        stop = false;
        isPaused = true;
    }
// setting conditions for next track during straight play and shuffle mode

    @Override
    public void nextTrack() {

        if (isUSBLoaded && isPlaying) {

            if (enableStraightPlayMode) {
                if (currentTrack < number_of_tracks) {
                    this.currentTrack++;
                    if (currentTrack > number_of_tracks) {
                        this.currentTrack = 1;
                    }
                }

                System.out.println(this.currentTrack);
            } else if (enableShufflePlayMode) {
                int bound = number_of_tracks;
                Random genSh = new Random();
                this.currentTrack = genSh.nextInt(bound + 1);
            }

        }

    }
// setting conditions for previous track during straight play and shuffle mode

    @Override
    public void previousTrack() {
        if (isUSBLoaded && isPlaying) {

            if (enableStraightPlayMode) {
                if (currentTrack > 0) {
                    this.currentTrack--;
                    if (currentTrack < 1) {
                        currentTrack = number_of_tracks;
                    }
                }

                System.out.println(currentTrack);
            } else if (enableShufflePlayMode) {
                int bound = number_of_tracks;
                Random genSh = new Random();
                this.currentTrack = genSh.nextInt(bound + 1);
            }

        }

    }

// determines if the USB is playing
    @Override
    public boolean isPlaying() {
        isUSBLoaded = true;
        isPaused = false;
        stop = false;
        return isPlaying = true;

    }
// determines if USB is paused

    @Override
    public boolean isPaused() {
        isUSBLoaded = true;
        stop = false;
        isPlaying = false;
        return isPaused = true;
    }

}
