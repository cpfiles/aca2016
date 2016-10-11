/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stereo.CarterFliss;

/**
 *
 * @author Carter
 */
import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

public class StereoPlayer {

    /**
     * @param args the command line arguments
     */
    private int trackTotal;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private boolean isUSBLoaded = false;
    private boolean playingStraight = false;
    private boolean playingRandom = false;
    private int currentTrack;

    /*
    *  loads USB device and enables starting variables
    *  such as isUSBLoaded, isPlaying, and generates trackTotal
     */
    public void loadUSB() {
        isUSBLoaded = true;
        Random genTL = new Random();
        trackTotal = (genTL.nextInt(1000) + 1);
        while (trackTotal == 0) {
            trackTotal++;
            break;
        }
        isPlaying = true;
    }

    /*
    *  checks if USB device is loaded, providing appropriate message
    *  in relation to current device state
     */
    public void isUSBLoaded() {
        if (isUSBLoaded == true) {
            System.out.println("USB input recognized.  Loading tracks...");
        } else {
            System.err.println("No USB device detected.");
        }
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
            isPlaying = false;
            isPaused = false;
            isStopped = false;
            playingRandom = false;
            playingStraight = false;
            break;
        }
    }

    /*
    *  Generates and returns a current track number, defaulting at first track
     */
    public int currentTrackNumber() {
        currentTrack = (trackTotal - (trackTotal - 1));
        return currentTrack;
    }

    /*
    *  returns trackTotal
     */
    public int totalTrackCount() {
        return trackTotal;
    }

    /*
    * for loop provides sequential counter for current track list, stopping at
    * last track
    * breaks for loop when paused or stopped
     */
    public void enableStraightPlayMode() {
        playingStraight = true;
        System.out.println("Straight play enabled.");
        while (playingStraight == true || isPaused == false || isStopped == false
                || isUSBLoaded == true) {
            while (currentTrack != trackTotal) {
                currentTrack++;
                System.out.println("Currently playing Track " + currentTrack + " of " + trackTotal);

            }
            break;
        }
    }


    /*
    * changes currentTrack randomly w/in bounds of trackTotal (+1 because final
    * track would be exclusive)
    * breaks while loop when paused or stopped
     */
    public void enableShufflePlayMode() {
        playingRandom = true;
        System.out.println("Shuffle play enabled.");
        while (playingRandom == true || isPaused == false || isStopped == false
                || isUSBLoaded == true || currentTrack != trackTotal) {
            while (currentTrack <= trackTotal) {
                Random curTrack = new Random();
                currentTrack = curTrack.nextInt(trackTotal + 1);
                System.out.println("Currently playing Track " + currentTrack + " of " + trackTotal);
            }
            break;
        }

    }

    /*
    * stops all play modes and reverts back to first track
     */
    public void stop() {
        System.out.println("Stopping music.");
        isStopped = true;
        currentTrack = 1;
        isPlaying = false;
        playingRandom = false;
        playingStraight = false;
    }

    /*
    *  Pauses music without reverting other variables
     */
    public void pause() {
        isPaused = true;
        isPlaying = false;
        playingStraight = false;
        playingRandom = false;
        System.out.println("Music paused.");
    }

    /*
    *  moves to next track in list. if on last track of list, loops back to first
    *  track
     */
    public void nextTrack() {
        System.out.println("Next Track");
        do {
            if (currentTrack != trackTotal) {
                currentTrack++;
            } else {
                currentTrack = (trackTotal - (trackTotal - 1));
            }
        } while (currentTrack != trackTotal);
        System.out.println("Currently playing Track " + currentTrack + " of " + trackTotal);
    }

    /*
    *  moves to previous track in list. if on first track of list, loops back to 
    *  last track
     */
    public void previousTrack() {
        System.out.println("Previous Track");
        do {
            if (currentTrack != trackTotal) {
                currentTrack--;
            } else {
                currentTrack = trackTotal;
            }
        } while (currentTrack != trackTotal);
        System.out.println("Currently playing Track " + currentTrack + " of " + trackTotal);
    }

    //returns isPlaying
    public boolean isPlaying() {
        return isPlaying;
    }

    //returns isPaused
    public boolean isPaused() {
        return isPaused;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //testing code for Straight play.  Will test other functions here.
        StereoPlayer straightStereoTest = new StereoPlayer();
        straightStereoTest.loadUSB();
        straightStereoTest.currentTrackNumber();
        straightStereoTest.enableStraightPlayMode();
        straightStereoTest.pause();
        straightStereoTest.enableStraightPlayMode();
        straightStereoTest.nextTrack();
        straightStereoTest.enableStraightPlayMode();
        straightStereoTest.previousTrack();
        straightStereoTest.stop();
        straightStereoTest.unloadUSB();
        //testing code for Shuffle play.
//        StereoPlayer randStereoTest = new StereoPlayer();
//        randStereoTest.loadUSB();
//        randStereoTest.currentTrackNumber();
//        randStereoTest.enableShufflePlayMode();
//        randStereoTest.unloadUSB();

    }

}
