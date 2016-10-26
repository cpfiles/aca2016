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

    /*
    loadUSB - generate the totalTracks on usb, enable straight play mode, start playing, sets usbloaded to true
     */
    public void loadUSB() {
        Random rand = new Random();
        totalTracks = rand.nextInt(1000) + 1;
        //totalTracks++ ;
        straightPlaymode = true;
        USBLoaded = true;

    }

    /*
    is usb loaded should retun a boolean if it is loaded or not
     */
    //@Override
    public boolean USBLoaded() {
       if (USBLoaded == true || USBLoaded == false )
           return USBLoaded;
       else 
           return USBLoaded;
    }

    /*
    unloadusb - sets usb loaded to false and totalTracks to 0
     */
    @Override
    public void unloadUSB() {
        USBLoaded = false;
        totalTracks = 0;
    }

    /*
    Current Track number should return the track
     */
    @Override
    public int currentTrackNumber() {
        return totalTracks;
    }

    /*
    Total track count should return the total number of tracks on loadusb.
     */
    @Override
    public int totalTrackCount() {
        return totalTracks;
    }

    /*
    enable straight play mode should be set to boolean true to turn on enable shuffle play should be false.
     */
    @Override
    public void enableStraightPlayMode() {
        Playing = true;
        straightPlaymode = true;
        shufflePlaymode = false;

    }

    /*
    enable shuffle play should return boolean true an enable straight play mode should return false
     */
    @Override
    public void enableShufflePlayMode() {
        Playing = true;
        straightPlaymode = false;
        shufflePlaymode = true;

    }

    /*
    Stop boolean true if music has stopped or false if not
     */
    @Override
    public void stop() {
        isStopped = true;
        isPlaying = false;
        Paused = false;

    }

    /*
    Pause boolean true if paused, false if not.
     */
    @Override
    public void pause() {
        Paused = true;
        isPlaying = false;
        isStopped = false;
    }

    /*
    This should goto the next track 
    */
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
                    randomTracks++;
                }

            }

        }

    }

    @Override
    
    /*
    This should go back one track.
    */
    public void previousTrack() {
        if (USBLoaded = true) {
            if (straightPlaymode == true) {
                track--;
                if (track == 1) {
                    track = totalTracks;

                } else if (shufflePlaymode == true) {
                    Random rand = new Random();
                    randomTracks = rand.nextInt(totalTracks) + 1;
                    randomTracks--;

                }

            }

        }

    }

    /*
       Is Playing retrun true if playing false if not
     */
    @Override
    public boolean isPlaying() {
        return Playing;
    }

    /*
        Is paused retrun true if paused false if not
     */
    @Override
    public boolean isPaused() {
        return Paused;

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStereo test = new MyStereo();
        test.loadUSB();
        //System.out.println (test.totalTracks());
    }

    @Override
    public boolean isUSBLoaded() {
        return USBLoaded;
    }

}
