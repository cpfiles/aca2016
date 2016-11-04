/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.clintlemons;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collection;
import java.util.Collections;
import java.io.ObjectInput;
import java.io.ObjectOutput;
        

/**
 *
 * @author Username
 */
public class MyStereo implements StereoExtended {
      
    //Constructor variables
    private boolean Is_USB_Loaded;
    private boolean Load_USB;
    private int Max_Track;
    private int Min_Track;
    private int Number_of_Tracks;
    private int Current_Track;
    private boolean Is_Playing;
    private boolean Is_Paused;
    private boolean Is_Stopped;
    private boolean Enable_Shuffle_Play;
    private boolean Enable_Straight_Play;
    //Initializer variables
    
    public MyStereo() {
        this.Enable_Straight_Play = false;
        this.Enable_Shuffle_Play = false;
        this.Is_Stopped = false;
        this.Is_Paused = false;
        this.Is_Playing = false;
        this.Max_Track = 1000;
        this.Is_USB_Loaded = false;
        this.Load_USB = false;
        this.Min_Track = 1;
        this.Current_Track = 0;
    }
    
   
    /**
     *Loads USB and begins playing in Straight Play mode
     */
    @Override
    public void loadUSB(){
        Enable_Straight_Play = true;
        Is_Playing = true;
        Min_Track = 1;
        Current_Track ++; 
        Random ran = new Random();   
 
    }
    /**
     * Increment next track
     */
    @Override
    public void nextTrack(){
        if (Is_USB_Loaded == true&&Is_Playing){
        if (Enable_Straight_Play == true)
            Current_Track ++;}
            if (Current_Track > Min_Track){
                Current_Track = 1;}
            else {Random ran = new Random();{
                  Current_Track = ran.nextInt(Min_Track)+1;
}
    
        }
    }
    //Decrement previous track
      @Override
    public void previousTrack(){
        if (Is_USB_Loaded = true&&Is_Playing){
        if (Enable_Straight_Play = true)
            Current_Track --;}
            if (Current_Track < Min_Track){
                Current_Track = 1;}
            else {Random ran = new Random();{
                  Current_Track = ran.nextInt(Min_Track)+1;
}
    
        }
    }
    //Play in Straight mode if true
    @Override
    public boolean isUSBLoaded() {
        Is_USB_Loaded = true;
        Enable_Straight_Play = true;
        return Is_USB_Loaded;
    }
    //Stop if USB is unloaded
    @Override
    public void unloadUSB() {
        Is_Playing = false;
        Is_Stopped = true;
        Is_Paused = false;
        
    }
    //return current track
    @Override
    public int currentTrackNumber() {
        return Current_Track;
    }
    //return total number of tracks
    @Override
    public int totalTrackCount() {
        return Max_Track;
    }
    //Enables straight play mode
    @Override
    public void enableStraightPlayMode() {
        Enable_Straight_Play = true;
        Enable_Shuffle_Play = false;
    }
    //Enables shuffle play mode
    @Override
    public void enableShufflePlayMode() {
        Enable_Shuffle_Play=true;
        Enable_Straight_Play=false;
    }
    // Stops play
    @Override
    public void stop() {
         Is_Stopped = true;
         Is_Playing = false;
    }
    //Puases play
    @Override
    public void pause() {
        Is_Stopped = false;
        Is_Playing = false;
    }
    //Answers if USB is playing
    @Override
    public boolean isPlaying() {
        return Is_Playing;
    }
    //Answers if USB is paused
    @Override
    public boolean isPaused() {
        return Is_Paused;
    }
    //**

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
                    
