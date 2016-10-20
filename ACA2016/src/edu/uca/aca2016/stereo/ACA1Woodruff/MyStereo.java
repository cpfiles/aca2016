/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author awood
 */
public class MyStereo implements Stereo {

    private int NumberOfTracks;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private int currentTrackNumber;

    @Override

    public void loadUSB() {
        int bound = 1000;
        Random r = new Random();

        NumberOfTracks = r.nextInt(bound);
        NumberOfTracks++;
        isUSBLoaded = true;
        currentTrackNumber = 1;
    }

    @Override
    public boolean isUSBLoaded() {
        return isUSBLoaded;
        /**
         * This method scans the USB drive for * mp3 files.
         */
    }

    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        this.NumberOfTracks = 0;
    }

    @Override
    public int currentTrackNumber() {
        return currentTrackNumber;
    }

    @Override
    public int totalTrackCount() {
        return NumberOfTracks;
    }

    @Override
    public void enableStraightPlayMode() {
        enableStraightPlayMode = true;
        enableShufflePlayMode = false;


        /*while loops needed*/
    }

    @Override
    public void enableShufflePlayMode() {
        enableShufflePlayMode = true;
        enableStraightPlayMode = false;

    }

    @Override
    public void stop() {
        this.isPlaying = false;
        this.isStopped = true;
    }

    @Override
    public void pause() {
        this.isPlaying = true;
        this.isStopped = false;
    }

    @Override
    public void nextTrack() {
        if (isUSBLoaded) {
            if (enableStraightPlayMode);

        }
    }

    @Override
    public int previousTrack() {

    }

    @Override
    public boolean isPlaying() {

    }

    @Override
    public boolean isPaused() {

    }

}
