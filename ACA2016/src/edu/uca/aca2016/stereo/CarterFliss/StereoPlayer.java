/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.CarterFliss;

/**
 *
 * @author Carter
 */
import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

public class StereoPlayer implements Stereo {

    /**
     * @param args the command line arguments
     *
     * instantiating the variables necessary for the rest of the program
     * clarification: isPlaying only stores whether stereo is currently playing,
     * regardless of current play mode. isPlayingStraight and isPlayingShuffle
     * stores value of which play mode stereo is currently in.
     */
    private int trackTotal;
    private boolean isPlaying = false;
    private boolean isPlayingStraight = false;
    private boolean isPlayingShuffle = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private boolean isUSBLoaded = false;
    private int currentTrack;

    /*
    *  loads USB device and enables starting variables
    *  such as isUSBLoaded, isPlaying, and generates trackTotal
    *  Defaults on Straight Play mode.
     */
    public void loadUSB() {
        isUSBLoaded = true;
        isPlaying = true;
        isPlayingStraight = true;
        Random genTL = new Random();
        trackTotal = (genTL.nextInt(1000) + 1);
        while (trackTotal == 0) {
            trackTotal++;
            break;
        }
    }

    /*
    *  checks if USB device is loaded, providing appropriate message
    *  in relation to current device state
     */
    public boolean isUSBLoaded() {
        if (isUSBLoaded == true) {
            System.out.println("USB input recognized.  Loading tracks...");
        } else {
            System.err.println("No USB device detected.");
        }
        return isUSBLoaded;
    }

    /*
    *  reverts all ints to 0 and all booleans to false.
     */
    public void unloadUSB() {
        isUSBLoaded = false;
        while (isUSBLoaded == false) {
            System.out.println("Removing USB device.");
            currentTrack = 0;
            trackTotal = 0;
            isPlayingStraight = false;
            isPlayingShuffle = false;
            isPlaying = false;
            isPaused = false;
            isStopped = false;
            break;
        }
    }

    /*
    *  Generates and returns a current track number, defaulting at first track
     */
    public int currentTrackNumber() {
        return currentTrack;
    }

    /*
    *  returns trackTotal
     */
    public int totalTrackCount() {
        return trackTotal;
    }

    /*
    * establishes and stores appropriate states for Straight Play mode.
     */
    public void enableStraightPlayMode() {
        isPlaying = true;
        isPlayingStraight = true;
        isPlayingShuffle = false;
        isPaused = false;
        isStopped = false;
        System.out.println("Straight play enabled.");
    }
    /*
    * establishes and stores appropriate states for Shuffle Play mode.
     */
    public void enableShufflePlayMode() {
        isPlaying = true;
        isPlayingShuffle = true;
        isPlayingStraight = false;
        isPaused = false;
        isStopped = false;
        System.out.println("Shuffle play enabled.");
    }

    /*
    * stops all play modes and reverts back to first track
     */
    public void stop() {
        System.out.println("Stopping music.");
        isStopped = true;
        currentTrack = 1;
        isPlaying = false;
        isPaused = false;
    }
    /*Pauses music without reverting other variables
     */
    public void pause() {
        isPaused = true;
        isPlayingStraight = false;
        isPlayingShuffle = false;
        isPlaying = false;
        isStopped = false;

        System.out.println("Music paused.");
    }

    /*
    *  moves to next track in list. if on last track of list while on Straight
    *  Play mode, loops back to first track.  On Shuffle Play, moves to random
    *  track w/in trackTotal
     */
    public void nextTrack() {
        isPaused = false;
        isStopped = false;
        System.out.println("Next Track");
        if (isPlayingStraight == true) {
            if (currentTrack == trackTotal) {
                currentTrack = (trackTotal - (trackTotal - 1));
            } else {
                do {
                    currentTrack++;
                    break;
                } while (currentTrack != trackTotal);
            }
        } else if (isPlayingShuffle == true) {
            Random curTrack = new Random();
            currentTrack = (curTrack.nextInt(trackTotal) + 1);
        }
        System.out.println("Currently playing Track " + currentTrack + " of " + trackTotal);
    }

    /*
    *  moves to previous track in list. if on first track of list while on Straight
    *  Play mode, loops back to first track.  On Shuffle Play, moves to random
    *  track w/in trackTotal
     */
    public void previousTrack() {
        isPaused = false;
        isStopped = false;
        System.out.println("Previous Track");
        if (isPlayingStraight == true) {
            if (currentTrack == (trackTotal - (trackTotal - 1))) {
                currentTrack = trackTotal;
            } else {
                do {
                    currentTrack--;
                    break;
                } while (currentTrack != trackTotal);
            }
        } else if (isPlayingShuffle == true) {
            Random curTrack = new Random();
            currentTrack = (curTrack.nextInt(trackTotal) + 1);
        }
        System.out.println("Currently playing Track " + currentTrack + " of " + trackTotal);
    }

    //returns isPlaying
    @Override
    public boolean isPlaying() {
        if (isPlayingStraight == true || isPlayingShuffle == true) {
            isPlaying = true;
        }
        return isPlaying;
    }

    //returns isPaused
    @Override
    public boolean isPaused() {
        return isPaused;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //testing code for Straight play.  Will test other functions here.
//        StereoPlayer straightStereoTest = new StereoPlayer();
//        straightStereoTest.loadUSB();
//        straightStereoTest.enableStraightPlayMode();
//        straightStereoTest.stop();
//        straightStereoTest.previousTrack();
//        straightStereoTest.unloadUSB();
        //testing code for Shuffle play.
//        StereoPlayer randStereoTest = new StereoPlayer();
//        randStereoTest.loadUSB();
//        randStereoTest.currentTrackNumber();
//        randStereoTest.enableShufflePlayMode();
//        randStereoTest.stop();
//        randStereoTest.nextTrack();
//        randStereoTest.unloadUSB();
//          StereoPlayer t = new StereoPlayer();
//          t.loadUSB();
//          t.enableStraightPlayMode();
//          t.nextTrack();
//          t.nextTrack();
//          t.nextTrack();
//          t.enableShufflePlayMode();
//          t.previousTrack();
//          t.stop();
//          t.unloadUSB();

    }

}
