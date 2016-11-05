/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.Calhoun512;


import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

// Importing the Random Number Generator utility (I'm thankful they included)

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author calho
 */
public class MyStereo implements StereoExtended {

    
    
    private int NumberOfTracks = 0;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private int currentTrackNumber = 0;
    private int totalTrackCount = 0;
    private ArrayList <String> trackList;
    
    private static final Logger logger = Logger.getLogger(MyStereo.class.getName());
    private int currentTrack;
    
   
    

    @Override
    /**
     * The following lines load the data/songs to the player and determine the
     * total number of tracks.  In this case, a number generated at "random."
     */
    public void loadUSB() {
        
        int bound = 1000;
        Random r = new Random();
        
        this.NumberOfTracks = r.nextInt(bound +1);
        this.NumberOfTracks++;
        isUSBLoaded = true;
        currentTrackNumber = 1;
        this.isPlaying = true;
        
        logger.info("Found "+ this.totalTrackCount + " tracks");
        
        }
        
     @Override  
        
            
   // This line returns a true value if and when the data has been loaded
     /**
      * Loads USB and returns True if the data is already loaded.
      */

    public boolean isUSBLoaded() {
        
        logger.info("isUSBLoaded? " + this.isUSBLoaded);
        return this.isUSBLoaded = true;
        
    }

    @Override
    
    /** Unloads the Data.  Upon the storage device
    *    being removed it resets the Track Count to zero.
    */
        
    public void unloadUSB() {       
        isUSBLoaded = false;
        this.NumberOfTracks = 0;
        this.totalTrackCount = 0;
        this.isPaused = false;
        this.isPlaying = false;
           
        
    }

    @Override
    /**
     * returns the current track number
     * 
     * @return
     */
    public int currentTrackNumber() {
        return this.currentTrackNumber;
       
    }

    @Override
    
    /**
     * returns the total number of tracks
     * 
     * @return
     */
    
    public int totalTrackCount() {
        return this.NumberOfTracks;
                
    }

    @Override
    
    // These lines turn on Straight Play Mode to play the tracks consecutively.
    
    /**
     * enables straight play mode, disables Shuffle mode
     */
    
    public void enableStraightPlayMode() {
        this.enableStraightPlayMode = true;
        this.enableShufflePlayMode = false;
    }

    @Override
    
    //These lines enable shuffle, randomly queing the next track.
    
    /**
     * Enables shuffle mode, disables straight play mode
     */
    
    public void enableShufflePlayMode() {
        this.enableShufflePlayMode = true;
        this.enableStraightPlayMode = false;
        
        
        
    }

    @Override
    
    // This stops the stereo from playing.
    
    /**
     * Stops the Stereo, makes false isPlaying and isPaused
     */
    
    public void stop() {
       isStopped = true;
       isPlaying = false;
       isPaused = false;
    
  
    }

    @Override
    
    // This pauses the stereo.
    
    /**
     * pauses the stereo, makes false isPlaying and isStopped
     */
    
    public void pause() {
        isPaused = true;
        isPlaying = false;
        isStopped = false;
        
    }

    @Override
    
    /* These lines advance to the next track and also differentiate how to do so
        whether the player is set to Shuffle or Straight-Play.
    */
    
    /**
     * Advances to the next track and differentiates functions between Shuffle and 
     * Straight play mode.
     */
    public void nextTrack() {
      if (isUSBLoaded){
        if (enableStraightPlayMode) {
           this.currentTrackNumber++;
            if (currentTrackNumber > NumberOfTracks) 
                this.currentTrackNumber = 1;
            } else {
                    if (enableShufflePlayMode) {
                    int bound = NumberOfTracks;
                    Random r = new Random();
                    currentTrackNumber = r.nextInt ((bound)+1);
                    
                  
                }
            }
            }
      }
    

    @Override
    
    /* These lines replay the last-played track in Straight-Play mode, or randomly
        select a new track to be played in Shuffle mode.        
    */
    
    /**
     * regresses to the previous track, differentiates between straight play and 
     * shuffle mode.
     */
    
    public void previousTrack() {
            if (isUSBLoaded){
        if (enableStraightPlayMode) {
           this.currentTrackNumber--;
            if (currentTrackNumber < 1) 
                this.currentTrackNumber = NumberOfTracks;
            } else {
                    if (enableShufflePlayMode) {
                    int bound = NumberOfTracks;
                    Random r = new Random();
                    currentTrackNumber = r.nextInt ((bound) + 1);
                    
                  
                }
            }
            }
      }
    


        
    @Override
    
    // These lines indicate whether the stereo is playing and play it if it is not
    
    /**
     * plays the stereo, makes false isPaused and isStopped.
     * 
     * @return
     */
    public boolean isPlaying() {
      
        isPaused = false;
        isStopped = false;
        
        
        return isPlaying = true;
        
        
    }

    @Override
    
    //  These lines pause the Stereo. 
    
    /**
     * Pauses the stereo.
     * 
     * @return
     */
    
    public boolean isPaused() {
       
        isPlaying = false;
        isStopped = false;
        
        return isPaused = true;
        
    }

    @Override
    
    /**
     * Loads the audio files and starts the stereo.
     */
    public void loadTrackList(File trackListSource)throws IOException {
       
        Scanner s = null; 
        this.isUSBLoaded = true;
        this.isPlaying = true;      
        try{
            s = new Scanner (trackListSource);            
            while (s.hasNextLine()) {
                this.trackList.add(s.nextLine());               
            }   
            
            
        }catch (IOException ex) {
            try {           
                throw new Exception ("IO Error:" + ex.getMessage());
            } catch (Exception ex1) {
                Logger.getLogger(MyStereo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        
    }

    @Override
    
    /**
     * Starts the stereo to play.  Sets stopped and Paused to false.
     */
    public void play() {
        isPaused = false;
        isStopped = false;
        isPlaying = true;
    }

    @Override
    
    /**
     * Gives the names of the tracks that have been.
     * 
     * @return
     */
    public ArrayList<String> getTrackList() {
        return this.trackList;
    }
            
    
    
/**
 * Displays the current track's name
 * 
 * @return 
 */

    @Override
    public String getCurrentTrackFileName() {
        return this.trackList.get(this.currentTrackNumber + 1);
    }


    
    
}

