/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.lokeee;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author lokeee
 */
public class MyStereo implements Stereo {

    private boolean isPlaying = false;
    private boolean USBLoaded = false;
    private boolean isStopped = false;
    private boolean straightPlaymode = false;
    private boolean shufflePlaymode = false;
    private boolean isPaused = false;
    private int track = 1;
    private int totalTracks;
    private int randomTracks;
    private int Numbers;
    private boolean Playing = false;
    private boolean Paused = false;

    /* */
    public void loadUSB() {
        Random rand = new Random();
        totalTracks = rand.nextInt(1000) + 1;
        //totalTracks++ ;
        straightPlaymode = true;
        USBLoaded = true;

    }

    @Override
    public void isUSBLoaded() {

    }

    @Override
    public void unloadUSB() {
        USBLoaded = false;
        totalTracks = 0;
    }

    @Override
    public int currentTrackNumber() {
        return totalTracks;
    }

    @Override
    public int totalTrackCount() {
        return totalTracks;
    }

    @Override
    public void enableStraightPlayMode() {

    }

    @Override
    public void enableShufflePlayMode() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void nextTrack() {
        if (USBLoaded = true) {
            if (straightPlaymode == true) {
                track++;
                if (track > totalTracks) {
                    track = 1;
                } else if (shufflePlaymode == true) {
                    Random rand = new Random();
                    randomTracks = rand.nextInt(totalTracks) + 1;
                }

            }

        }

    }

    @Override
    public void previousTrack() {

    }

    @Override
    public boolean isPlaying() {
        return Playing;
    }

    @Override
    public boolean isPaused() {
        return Paused;

    }

    public static void main(String[] args) {
        MyStereo bill = new MyStereo();
        bill.loadUSB();
        //System.out.println (bill.totalTracks());
    }
}
