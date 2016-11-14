/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.cpfiles;

import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author cpfil
 */
public class MyStereo implements StereoExtended {
    private boolean isUSBLoaded = false;
    private boolean isPlaying = false;
    private boolean isPaused = false;
    private int totalTrackCount = 0;
    private int currentTrack = 0;
    private boolean straightPlayMode = true;
    
    private static final Logger logger = Logger.getLogger(MyStereo.class.getName());
    
    private ArrayList<String> tracks = new ArrayList<>();

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

    @Override
    public void loadTrackList(File trackListSource) throws IOException{
        if (trackListSource == null || !trackListSource.exists()) {
            throw new IOException("Cannot read the input file");
        }

        BufferedReader br = new BufferedReader(new FileReader(trackListSource));
 
        String line = null;
        while ((line = br.readLine()) != null) {
            this.tracks.add(line);
        }

        br.close();
        this.isPlaying = true;
        this.isUSBLoaded = true;
        
        this.totalTrackCount = this.tracks.size();
        this.currentTrack = 1;
    }

    @Override
    public void play(){
        if (this.isUSBLoaded) {
            this.isPaused = false;
            this.isPlaying = true;
        }
    }

    @Override
    public ArrayList<String> getTrackList(){
        return this.tracks;
    }

    @Override
    public String getCurrentTrackFileName(){
        try {
            if (this.isUSBLoaded) {
                return this.tracks.get(currentTrack-1);
            }
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }

        return null;
    }
}
