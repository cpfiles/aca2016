/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.cpfiles;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author cpfil
 */
public class MyStereo implements Stereo {
    private boolean isUSBLoaded = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int totalTrackCount = 0;
    private int currentTrack = 0;
    private boolean straightPlayMode = true;
    
    private static final Logger logger = Logger.getLogger(MyStereo.class.getName());


    @Override
    public void loadUSB() {
        this.isUSBLoaded = true;
        
        Random rand = new Random();
        this.totalTrackCount = rand.nextInt(1000);
        this.totalTrackCount++;
        
        logger.info("Found "+ this.totalTrackCount + " tracks");
        
        this.currentTrack = 1;
        this.isPlaying = true;
    }

    @Override
    public boolean isUSBLoaded() {
        logger.info("isUSBLoaded? " + this.isUSBLoaded);
        return this.isUSBLoaded;
    }

    @Override
    public void unloadUSB() {
        this.isUSBLoaded = false;
        this.currentTrack = 0;
        this.totalTrackCount = 0;
        this.isPlaying = false;
        this.isPaused = false;
    }

    @Override
    public int currentTrackNumber() {
        return this.currentTrack;
    }

    @Override
    public int totalTrackCount() {
        return this.totalTrackCount;
    }

    @Override
    public void enableStraightPlayMode() {
        this.straightPlayMode = true;
    }

    @Override
    public void enableShufflePlayMode() {
        this.straightPlayMode = false;
    }

    @Override
    public void stop() {
        this.isPlaying = false;
        this.isPaused = false;
    }

    @Override
    public void pause() {
        this.isPlaying = false;
        this.isPaused = true;
    }

    @Override
    public void nextTrack() {
        if (!this.isUSBLoaded && !this.isPlaying) {
            return;
        }
        
        logger.finer("Straight Play Mode?" + this.straightPlayMode + " Current Track:" + this.currentTrack );
        
        if (this.straightPlayMode) {
            this.currentTrack++;
            
            if (this.currentTrack > this.totalTrackCount) {
                this.currentTrack = 1;
            }
        }
        else {
            Random rand = new Random();
            this.currentTrack = rand.nextInt(this.totalTrackCount);
            this.currentTrack++;
        }
    }

    @Override
    public void previousTrack() {
        if (!this.isUSBLoaded && !this.isPlaying) {
            return;
        }
        
        if (this.straightPlayMode) {
            this.currentTrack--;
            
            if (this.currentTrack == 0) {
                this.currentTrack = this.totalTrackCount;
            }
        }
        else {
            Random rand = new Random();
            this.currentTrack = rand.nextInt(this.totalTrackCount);
            this.currentTrack++;
        }
    }

    @Override
    public boolean isPlaying() {
        return this.isPlaying;
    }

    @Override
    public boolean isPaused() {
        return this.isPaused;
    }
}
