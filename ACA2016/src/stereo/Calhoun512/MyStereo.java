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
    int currentTrackNumber;
    
    

    @Override
    
    public void loadUSB() {
        
        int bound = 1000;
        Random r = new Random();
        
        NumberOfTracks = r.nextInt(bound +1);
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
        if (isUSBLoaded){}
        return this.currentTrackNumber;
       
    }

    @Override
    public int totalTrackCount() {
        if (isUSBLoaded){}
        return this.NumberOfTracks;
                
    }

    @Override
    public void enableStraightPlayMode() {
        if (isUSBLoaded){}
        this.enableStraightPlayMode = true;
        this.enableShufflePlayMode = false;
    }

    @Override
    public void enableShufflePlayMode() {
        if (isUSBLoaded){}
        this.enableShufflePlayMode = true;
        this.enableStraightPlayMode = false;
        
        
    }

    @Override
    public void stop() {
       if (isUSBLoaded){
       isStopped = true;
       isPlaying = false;
    }
  
    }

    @Override
    public void pause() {
        if (isUSBLoaded){
        isPaused = true;
        isPlaying = false;
        }
    }

    @Override
    public void nextTrack() {
      if (isUSBLoaded){
        if (enableStraightPlayMode) {
           this.currentTrackNumber++;
            if (currentTrackNumber > NumberOfTracks) {
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
    }

    @Override
    public void previousTrack() {
            if (isUSBLoaded){
        if (enableStraightPlayMode) {
           this.currentTrackNumber--;
            if (currentTrackNumber < 1) {
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
    }

        
    @Override
    public boolean isPlaying() {
        if (isUSBLoaded){
        isPaused = false;
        isStopped = false;
        }
        
        return isPlaying = true;
        
        
    }

    @Override
    public boolean isPaused() {
        if (isUSBLoaded){
        isPlaying = false;
        isStopped = false;
        }
        return isPaused = true;
        
    }
    
}
