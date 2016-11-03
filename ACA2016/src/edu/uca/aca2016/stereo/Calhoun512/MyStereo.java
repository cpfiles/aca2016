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
import java.util.ArrayList;

// Importing the Random Number Generator utility (I'm thankful they included)

import java.util.Random;
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
    
    private static final Logger logger = Logger.getLogger(MyStereo.class.getName());
   
    

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

    public boolean isUSBLoaded() {
        
        logger.info("isUSBLoaded? " + this.isUSBLoaded);
        return this.isUSBLoaded = true;
        
    }

    @Override
    
    /* These lines deal with the data being unloaded.  Upon the storage device
        being removed it resets the Track Count to zero.
    */
        
    public void unloadUSB() {       
        isUSBLoaded = false;
        this.NumberOfTracks = 0;
        this.totalTrackCount = 0;
        this.isPaused = false;
        this.isPlaying = false;
           
        
    }

    @Override
    
    /* These lines tell you what Track is currently playing, assuming the data
        has been loaded into the player.
    */
    
    public int currentTrackNumber() {
        return this.currentTrackNumber;
       
    }

    @Override
    
    /* These lines give the user the total amount of tracks on the storage device.
        Thus enabling the user and the program to navigate the data.
    */
    
    public int totalTrackCount() {
        return this.NumberOfTracks;
                
    }

    @Override
    
    // These lines turn on Straight Play Mode to play the tracks consecutively.
    
    public void enableStraightPlayMode() {
        this.enableStraightPlayMode = true;
        this.enableShufflePlayMode = false;
    }

    @Override
    
    //These lines enable shuffle, randomly queing the next track.
    
    public void enableShufflePlayMode() {
        this.enableShufflePlayMode = true;
        this.enableStraightPlayMode = false;
        
        
        
    }

    @Override
    
    // This stops the stereo from playing.
    
    public void stop() {
       isStopped = true;
       isPlaying = false;
       isPaused = false;
    
  
    }

    @Override
    
    // This pauses the stereo.
    
    public void pause() {
        isPaused = true;
        isPlaying = false;
        isStopped = false;
        
    }

    @Override
    
    /* These lines advance to the next track and also differentiate how to do so
        whether the player is set to Shuffle or Straight-Play.
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
    
    public boolean isPlaying() {
        if (isUSBLoaded){
        isPaused = false;
        isStopped = false;
        }
        
        return isPlaying = true;
        
        
    }

    @Override
    
    //  These lines pause the Stereo. 
    
    public boolean isPaused() {
        if (isUSBLoaded){
        isPlaying = false;
        isStopped = false;
        }
        return isPaused = true;
        
    }

    @Override
    public void loadTrackList(File trackListSource) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getTrackList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCurrentTrackFileName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

