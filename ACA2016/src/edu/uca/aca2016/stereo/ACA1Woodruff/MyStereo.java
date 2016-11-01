/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;

//import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;

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
        return isUSBLoaded;

    }
//**This method should tell the caller if the USB drive has been scanned for mp3 files */

    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        this.NumberOfTracks = 0;
    }
//**This method should unload the USB drive by resetting all of the counts and counters.*/

    @Override
    public int currentTrackNumber() {
        return currentTrackNumber;
    }
//**This method should return the number of the current track that is "playing".*/

    @Override
    public int totalTrackCount() {
        return NumberOfTracks;
    }
//**Return the total number of tracks loaded from the USB drive.*/

    @Override
    public void enableStraightPlayMode() {
        enableStraightPlayMode = true;
        enableShufflePlayMode = false;

    }
//**Plays the tracks in sequential order. This method should set the current track 
//to the first track and keep a record of the current track. Note the only way the 
//program moves to the next track is by calls to nextTrack and previousTrack.*/

    @Override
    public void enableShufflePlayMode() {
        enableShufflePlayMode = true;
        enableStraightPlayMode = false;

    }
//**Plays tracks in a random order. This method should set the current track to a random
//track and keep a record of the current track. Note the only way the program moves to the 
//next track is by calls to nextTrack and previousTrack.*/

    @Override
    public void stop() {
        this.isPlaying = false;
        this.isStopped = true;
    }
//**Stops the playing*/

    @Override
    public void pause() {
        this.isPlaying = true;
        this.isStopped = false;
    }
//*Pauses the playing*/

    @Override

    public void nextTrack() {
        if (isUSBLoaded && isPlaying) {
            if (enableStraightPlayMode) {
            }
        }
        this.currentTrackNumber++;
        if (currentTrackNumber > NumberOfTracks) {
            this.currentTrackNumber = 1;
        } else {
            int bound = NumberOfTracks;
            Random r = new Random();
            currentTrackNumber = r.nextInt((bound) + 1);
        }
    }
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
//**Tells the caller if the stereo is playing.*/

    @Override
    public void loadTrackList(File trackListSource) throws IOException {

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(trackListSource)))) {

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }
/**
 * Restarts the playing process.
 */
   
@Override
        public void play() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Return a list of all the tracks that are loaded.
 * @return
 */
    @Override
        public ArrayList<String> getTrackList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Get the full file name of the current track
 * @return The current track's file name
 */
    @Override
    public String getCurrentTrackFileName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
