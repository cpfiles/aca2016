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
public abstract class MyStereo implements Stereo {
    
    private int NumberOfTracks;
    private boolean isUSBLoaded;
    private boolean enableStraightPlayMode;
    private boolean enableShufflePlayMode;
    private boolean isPlaying;
    private boolean isPaused;
    
    public MyStereo (int NumberOfTracks, boolean isUSBLoaded, boolean enableStraightPlayMode,
        boolean enableShufflePlayMode, boolean isPlaying, boolean isPaused){
        
        this.NumberOfTracks = NumberOfTracks;
        this.isUSBLoaded = 
    
        }
    //@Override
    
    public void loadUSB() {
        
        int bound = 1000;
        Random r = new Random();
        
        NumberOfTracks = r.nextInt(bound);
        NumberOfTracks++;
        
        }
        
     @Override  
        
            
   

    public boolean isUSBLoaded() {
        
        this.isUSBLoaded = true;
        
    }

    @Override
    public void unloadUSB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int currentTrackNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int totalTrackCount() {
        
        return NumberOfTracks;
                
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
