/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.interfaces.stereo.christinamassingill;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author Chris
 */
public class MyStereo implements Stereo {

    private boolean isUSBLoaded = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isShufflePlayMode = false;
    private boolean isStraightPlayMode = false;
    private int totalTrackCount = 0;
    private int currentTrackNumber = 0;
    private int previousTrack = 0;

    @Override
    public void loadUSB() {
        if (!isUSBLoaded) {
            totalTrackCount = new Random().nextInt(1000) + 1;
            isPlaying = false;
            isPaused = false;
            isShufflePlayMode = false;
            isStraightPlayMode = false;
            currentTrackNumber = 1;
            isUSBLoaded = true;
        }
    }

    @Override
    public boolean isUSBLoaded() {
        return isUSBLoaded;
    }

    @Override
    // Reset all the values if load usb is called.
    public void unloadUSB() {
        isUSBLoaded = false;
        isPlaying = false;
        isPaused = false;
        isShufflePlayMode = false;
        isStraightPlayMode = false;
        totalTrackCount = 0;
        currentTrackNumber = 0;
    }

    @Override
    public int currentTrackNumber() {
        return currentTrackNumber;
    }

    @Override
    public int totalTrackCount() {
        return totalTrackCount;
    }

    @Override
    public void enableStraightPlayMode() {
        isShufflePlayMode = false;
        isStraightPlayMode = true;
    }

    @Override
    public void enableShufflePlayMode() {
        isShufflePlayMode = true;
        isStraightPlayMode = false;
    }

    @Override
    public void stop() {
        isPlaying = false;
        isPaused = false;
    }

    @Override
    public void pause() {
        isPaused = true;
        isPlaying = false;

    }

    @Override
    public void nextTrack() {

        if (isUSBLoaded) {

            if (isShufflePlayMode) {
                currentTrackNumber = new Random(totalTrackCount).nextInt() + 1;
            } else if (currentTrackNumber == totalTrackCount) {
                currentTrackNumber = 1;
            } else {

                currentTrackNumber++;
            }
        }
    }

    @Override
    public void previousTrack() {
        if (isUSBLoaded) {

            if (isShufflePlayMode) {
                currentTrackNumber = new Random(totalTrackCount).nextInt() - 1;
            } else if (currentTrackNumber == totalTrackCount) {

            } else {

                currentTrackNumber--;

            }




    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public boolean isPaused() {
        return isPaused;
    }

}
