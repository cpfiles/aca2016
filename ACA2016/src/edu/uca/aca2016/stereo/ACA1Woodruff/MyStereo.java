/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;

//import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author awood
 */
public class MyStereo implements StereoExtended {
//public class MyStereo extends Object implements Stereo

    private int NumberOfTracks;
    private int currentTrackNumber;
    private boolean isUSBLoaded = false;
    private final boolean enableStraightPlayMode = true;
    private boolean isPlayingStraight = true;
    private final boolean enableShufflePlayMode = false;
    private boolean isPlayingShuffle = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private Object trackList;
//    private int trackTotal;

    @Override
    public void loadUSB() {
        int bound = 1000;
        Random r = new Random();

        NumberOfTracks = r.nextInt(bound);
        NumberOfTracks++;
        isUSBLoaded = true;
        currentTrackNumber = 1;
    }
//**This method should load mp3s from a USB drive. It will generate a 
//random number of tracks between 1 and 1000.*/ 

    @Override
    public boolean isUSBLoaded() {
        if (isUSBLoaded == true) {
            System.out.println("USB input recognized.  Loading tracks...");
        } else {
            System.err.println("No USB device detected.");
        }
        return isUSBLoaded;
    }

//**This method should tell the caller if the USB drive has been scanned for mp3 files */
    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        while (isUSBLoaded == false) {
            System.out.println("Removing USB device.");
            currentTrackNumber = 0;
            NumberOfTracks = 0;
            isPlayingStraight = false;
            isPlayingShuffle = false;
            isPlaying = false;
            isPaused = false;
            isStopped = false;
            break;
        }
    }

//**This method should unload the USB drive by resetting all of the counts and counters.*/
    @Override
    public int currentTrackNumber() {
        return currentTrackNumber;
    }
//**This method should return the number of the current track that is "playing".*/

    @Override
    public int NumberOfTracks() {
        return NumberOfTracks;
    }
//**Return the total number of tracks loaded from the USB drive.*/

    @Override
    public void enableStraightPlayMode() {
        isPlaying = true;
        isPlayingStraight = true;
        isPlayingShuffle = false;
        isPaused = false;
        isStopped = false;
        System.out.println("Straight play enabled.");
    }
//        enableStraightPlayMode = true;
//        enableShufflePlayMode = false;
//        isPlayingStraightPlayMode = true;
//    }
//**Plays the tracks in sequential order. This method should set the current track 
//to the first track and keep a record of the current track. Note the only way the 
//program moves to the next track is by calls to nextTrack and previousTrack.*/

    @Override
    public void enableShufflePlayMode() {
        isPlaying = true;
        isPlayingShuffle = true;
        isPlayingStraight = false;
        isPaused = false;
        isStopped = false;
        System.out.println("Shuffle play enabled.");
    }
//        enableShufflePlayMode = true;
//        enableStraightPlayMode = false;
//        isPlayingStraightPlayMode = false;
//    }
//**Plays tracks in a random order. This method should set the current track to a random
//track and keep a record of the current track. Note the only way the program moves to the 
//next track is by calls to nextTrack and previousTrack.*/

    @Override
    public void stop() {
        isStopped = true;
        currentTrackNumber = 1;
        isPlaying = false;
        isPaused = false;
        System.out.println("Stopping music.");
    }

//**Stops the playing*/
    @Override
    public void pause() {
        isPaused = true;
        isPlayingStraight = false;
        isPlayingShuffle = false;
        isPlaying = false;
        isStopped = false;
        System.out.println("Music paused.");
    }

//*Pauses the playing*/
    @Override
    public void nextTrack() {
        isPaused = false;
        isStopped = false;
        System.out.println("Next Track");
        if (isPlayingStraight == true) {
            if (currentTrackNumber == NumberOfTracks) {
                currentTrackNumber = (NumberOfTracks - (NumberOfTracks - 1));
            } else {
                do {
                    currentTrackNumber++;
                    break;
                } while (currentTrackNumber != NumberOfTracks);
            }
        } else if (isPlayingShuffle == true) {
            Random curTrack = new Random();
            currentTrackNumber = (curTrack.nextInt(NumberOfTracks) + 1);
        }
        System.out.println("Currently playing Track " + currentTrackNumber + " of " + NumberOfTracks);
    }
// *   if (isUSBLoaded && isPlaying) {
//            if (enableStraightPlayMode) {
//            }
//        }
//    this.currentTrackNumber
//    ++;
//    if (currentTrackNumber > NumberOfTracks) {
//    this.currentTrackNumber = 1;
//    }
//        else {
//            int bound = NumberOfTracks;
//        Random r = new Random();
//        currentTrackNumber = r.nextInt((bound) + 1);
//    }
//}
//**Advances to next track*/

    @Override
    public void previousTrack() {
        if (isUSBLoaded && isPlaying) {
            if (enableStraightPlayMode) {
            }
        }
        this.currentTrackNumber--;
        if (currentTrackNumber < NumberOfTracks) {
            this.currentTrackNumber = 1;
        } else {
            int bound = NumberOfTracks;
            Random r = new Random();
            currentTrackNumber = r.nextInt((bound) - 1);
        }
    }
//**Moves to the next track/

    @Override
    public boolean isPlaying() {
        isStopped = false;
        isPaused = false;
        return isPlaying = true;
    }

    @Override
    public boolean isPaused() {
        isStopped = false;
        isPlaying = false;
        return isPaused = true;
    }
//**@param trackListSource A file thatcontains a list of mp3 tracks. There
//is one track per line.
//@throws IOException. Any IO exceptions are caught and re-thrown as this
//type of exception*/

    @Override
    public void loadTrackList(File trackListSource) throws IOException {
        Scanner s = null;
        this.isUSBLoaded = true;
        this.isPlaying = true;
        this.isPlayingStraight = true;
        this.NumberOfTracks = (this.trackList.size() - 1);
        try {
            s = new Scanner(trackListSource);
            while (s.hasNextLine()) {
                this.trackList.add(s.nextLine());
                List<string> Tracks = arrayList < > () 
// *               boolean equals = this.trackList.equals(trackList);*/
            }
//* s = new Scanner(new BufferedReader(new FileReader(trackListSource)));*/
//            while (s.hasNext()) {

            System.out.println(s.next());
        } catch (IOException ex) {
            new Exception("IO Error:" + ex.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    /**
     * Restarts the playing process.
     */
    @Override
    public void play() {
    }

    /**
     * Return a list of all the tracks that are loaded.
     *
     * @return
     */
    @Override
    public ArrayList<String> getTrackList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the full file name of the current track
     *
     * @return The current track's file name
     */
    @Override
    public String getCurrentTrackFileName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int totalTrackCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

    
