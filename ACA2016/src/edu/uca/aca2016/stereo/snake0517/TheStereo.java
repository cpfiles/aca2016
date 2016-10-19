/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.snake0517;

import edu.uca.aca2016.interfaces.Stereo;

import java.util.Random;

/**
 *
 * @author brela
 */
public class TheStereo implements Stereo {

    private int number_of_tracks;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int current_track;
    private boolean isStopped = false;
    
    @Override
    public void loadUSB() {
        int bound = 1000;
        
        Random r = new Random();
        
        number_of_tracks = r.nextInt(bound);
        number_of_tracks++;
        isUSBLoaded = true;
        current_track = 1;
    }

    @Override
    public boolean isUSBLoaded() {
        return isUSBLoaded;
        
    }

    @Override
    public void unloadUSB() {
       isUSBLoaded = false;
       this.number_of_tracks = 0;
        
    }

    @Override
    public int currentTrackNumber() {
        
        return this.current_track;
    }

    @Override
    public int totalTrackCount() {
        
        return this.number_of_tracks;
    }

    @Override
    public void enableStraightPlayMode() {
       enableStraightPlayMode = true;
       enableShufflePlayMode = false;
       
    }

    @Override
    public void enableShufflePlayMode() {
        enableShufflePlayMode = true;
        enableStraightPlayMode = false;
    }

    @Override
    public void stop() {
        isStopped = true;
        isPlaying = false;
    }

    @Override
    public void pause() {
       isPaused = true;
       isPlaying = false;
    }

    @Override
    public void nextTrack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void previousTrack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPlaying() {
        isPaused = false;
        isStopped = false;
        return isPlaying = true;
                
    }

    @Override
    public boolean isPaused() {
       isPlaying = false;
       isStopped = false;
       return isPaused = true;
    }
    
    
}
