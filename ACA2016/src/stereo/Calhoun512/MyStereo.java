/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stereo.Calhoun512;


import edu.uca.aca2016.interfaces.Stereo;

import java.util.Random;

/**
 *
 * @author calho
 */
public class MyStereo implements Stereo {
    
    private int NumberOfTracks;
    private boolean isUSBLoaded = false;
    private boolean enableStraightPlayMode = true;
    private boolean enableShufflePlayMode = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private int currentTrackNumber;
    

    @Override
    
    public void loadUSB() {
        
        int bound = 1000;
        Random r = new Random();
        
        NumberOfTracks = r.nextInt(bound);
        NumberOfTracks++;
        isUSBLoaded = true;
        currentTrackNumber = 1;
        
        }
        
     @Override  
        
            
   

    public boolean isUSBLoaded() {
        
        return this.isUSBLoaded = true;
        
    }

    @Override
    public void unloadUSB() {       
        isUSBLoaded = false;
        this.NumberOfTracks = 0;
           
        
    }

    @Override
    public int currentTrackNumber() {
        return this.currentTrackNumber;
       
    }

    @Override
    public int totalTrackCount() {
        
        return this.NumberOfTracks;
                
    }

    @Override
    public void enableStraightPlayMode() {
        this.enableStraightPlayMode = true;
        this.enableShufflePlayMode = false;
    }

    @Override
    public void enableShufflePlayMode() {
        this.enableShufflePlayMode = true;
        this.enableStraightPlayMode = false;
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
        this.currentTrackNumber++;
    }

    @Override
    public void previousTrack() {
        this.currentTrackNumber--;
    }

    @Override
    public boolean isPlaying() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPaused() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
