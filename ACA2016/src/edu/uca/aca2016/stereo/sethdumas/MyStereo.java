package edu.uca.aca2016.stereo.sethdumas;

import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;

import java.util.logging.Logger;

// @author sethd
public class MyStereo implements StereoExtended {

    //assign fields to variables and set default states
    //@param args set arguments
    
    private int TotalTracks = 0;
    private int CurrentTrack = 0;
    private boolean isUSBLoaded = false;
    private boolean isPlaying = false;
    private boolean isPlayingStraight = false;
    private boolean isPaused = false;
    private ArrayList<String> trackList;

//load a random number of mp3s between 1 and 1000 and begin playing in straight mode
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

    //return the current track number
    @Override
    public int currentTrackNumber() {
        return this.CurrentTrack;
    }

    //return the total number of tracks
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

    //return whether or not the track is playing
    @Override
    public boolean isPlaying() {
        return this.isPlaying;
    }

    //return whether or not the track is paused
    @Override
    public boolean isPaused() {
        return this.isPaused;
    }

    /**
     * Loads a list of track names from the specified file.
     *
     * @param trackListSource A file that contains a list of mp3 tracks. There
     * is one track per line.
     *
     * @throws IOException Any IO exceptions are caught and re-thrown as this
     * type of exception
     *
     *
     */
    @Override
    public void loadTrackList(File trackListSource) throws IOException {

        Scanner s = null;
        this.isUSBLoaded = true;
        this.isPlayingStraight = true;
        this.isPlaying = true;
        try {
            s = new Scanner(trackListSource);
            while (s.hasNextLine()) {
                this.trackList.add(s.nextLine());
            }
        } catch (IOException ex) {
            try {
                throw new Exception("IO Error:" + ex.getMessage());
            } catch (Exception ex1) {
                Logger.getLogger(MyStereo.class.getName()).log(Level.SEVERE, null, ex1);
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }
    }

    //Restarts the playing process.
    @Override
    public void play() {
        this.isPlaying = true;
        this.isPaused = false;
    }

    // Return a list of all the tracks that are loaded.
    //I'm running out of time and falling asleep.
    //* @return
    @Override
    public ArrayList<String> getTrackList() {
        return this.trackList;
    }

    /**
     * Get the full file name of the current track
     *
     * @return The current track's file name.
     */
    @Override
    public String getCurrentTrackFileName() {
        return this.trackList.get(this.CurrentTrack + 1);
    }
}
