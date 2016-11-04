package edu.uca.aca2016.stereo.sethdumas;

import edu.uca.aca2016.interfaces.Stereo;
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

// @author sethd
public class MyStereo implements StereoExtended {

    //assign fields to variables
    private int TotalTracks = 0;
    private int CurrentTrack = 0;
    private boolean isUSBLoaded = false;
    private boolean isPlaying = false;
    private boolean isPlayingStraight = false;
    private boolean isPaused = false;

    private static final Logger logger = Logger.getLogger(edu.uca.aca2016.stereo.sethdumas.MyStereo.class.getName());

//load a random number of mp3s
    @Override
    public void loadUSB() {
        this.isUSBLoaded = true;

        Random rand = new Random();
        this.TotalTracks = rand.nextInt(1000);
        this.TotalTracks++;
        this.CurrentTrack = 1;
        this.isPlayingStraight = true;
        this.isPlaying = true;
    }

    //tell if USB drive has been loaded
    @Override
    public boolean isUSBLoaded() {
        return this.isUSBLoaded;
    }

    //unload USB drive and reset
    @Override
    public void unloadUSB() {
        this.isUSBLoaded = false;
        this.TotalTracks = 0;
        this.CurrentTrack = 0;
        this.isPlayingStraight = false;
        this.isPlaying = false;
        this.isPaused = false;
    }

    //return current track number
    @Override
    public int currentTrackNumber() {
        return this.CurrentTrack;
    }

    //return the totaal number of tracks
    @Override
    public int totalTrackCount() {
        return this.TotalTracks;
    }

    //play tracks in sequential order
    @Override
    public void enableStraightPlayMode() {

        this.isPlayingStraight = true;
    }

    //play the tracks in a random order
    @Override
    public void enableShufflePlayMode() {
        this.isPlayingStraight = false;
    }

    //stop playing
    @Override
    public void stop() {
        this.isPlaying = false;
        this.isPaused = false;
    }

    //pause playing
    @Override
    public void pause() {
        this.isPaused = true;
        this.isPlaying = false;
    }

    //advance to next track
    @Override
    public void nextTrack() {
        if (!this.isUSBLoaded && !this.isPlaying) {
            return;
        }
        if (this.isPlayingStraight) {
            this.CurrentTrack++;

            if (this.CurrentTrack > this.TotalTracks) {
                this.CurrentTrack = 1;
            }
        } else {
            Random rand = new Random();
            this.CurrentTrack = rand.nextInt(this.TotalTracks);
            this.CurrentTrack++;
        }
    }

//revert to previous track
    @Override
    public void previousTrack() {
        if (!this.isUSBLoaded && !this.isPlaying) {
            return;
        }

        if (this.isPlayingStraight) {
            this.CurrentTrack--;

            if (this.CurrentTrack == 0) {
                this.CurrentTrack = this.TotalTracks;
            }
        } else {
            Random rand = new Random();
            this.CurrentTrack = rand.nextInt(this.TotalTracks);
            this.CurrentTrack++;
        }
    }

    //return whether or not track is playing
    @Override
    public boolean isPlaying() {
        return this.isPlaying;
    }

    //return whether or not track is paused
    @Override
    public boolean isPaused() {
        return this.isPaused;
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
