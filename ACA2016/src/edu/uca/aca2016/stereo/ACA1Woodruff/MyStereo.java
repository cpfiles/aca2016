/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;


import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;
/**
 *
 * @author awood
 */
public class MyStereo implements Stereo {
private int NumberOfTracks;
private boolean isUSBLoaded;
private boolean unloadUSB;
private int currentTrackNumber;
private int totalTrackCount;
private boolean enableStraightPlayMode;
private boolean enableShufflePlayMode;
private boolean enableStop;
private boolean enablePause;
private boolean enableNextTrack;
private boolean enablePreviousTrack;
private int nextTrack;
private int previousPlaying;
private boolean isPlaying;
private boolean isPaused;
        
    @Override
        
    public void loadUSB() {
    int origin = 0;
    int bound = 999;
    Random r = new Random();
    r.nextInt(1000 +1);
        
    }

    @Override
    public boolean isUSBLoaded(); {
        
        
      /**
     * This method scans the USB drive for * mp3 files.
     */   
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  enableStraightPlayMode() {
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
