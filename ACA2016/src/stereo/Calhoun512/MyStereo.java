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
    private int currentTrackNumber;
    

    @Override
    
    public void loadUSB() {
        
        int bound = 1000;
        Random r = new Random();
        
        NumberOfTracks = r.nextInt(bound);
        NumberOfTracks++;
        isUSBLoaded = true;
        
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
        this.currentTrackNumber = 1;
        return currentTrackNumber;
       
    }

    @Override
    public int totalTrackCount() {
        
        return this.NumberOfTracks;
                
    }

    @Override
    public void enableStraightPlayMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enableShufflePlayMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPaused() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
