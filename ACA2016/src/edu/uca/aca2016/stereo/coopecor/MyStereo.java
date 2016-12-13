package edu.uca.aca2016.stereo.coopecor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cory's HP Pavilion
 */
import edu.uca.aca2016.interfaces.StereoExtended;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MyStereo implements StereoExtended {

    //create variables
    private int track;
    private int totalTrack;
    private boolean stopped;
    private boolean playing;
    private boolean paused;
    private boolean loaded;
    private boolean shuffle;
    private final int maxTrack = 1000;
    private final int minTrack = 1;
    private boolean straight;

    /**
     * Default Constructor
     */
    public MyStereo() {
        loaded = false;
        stopped = false;
        playing = false;
        paused = false;
        shuffle = false;
        straight = false;
        track = 0;
        totalTrack = 0;
    }

    //When USB is loaded it should play the first track.
    //Assume straight play mode
    @Override
    public void loadUSB()
    {
        Random rand = new Random();
        totalTrack = rand.nextInt(maxTrack) + 1;
        track++;
        playing = true;
        straight = true;
        loaded = true;
    }

    //Answering if the USB has been loaded.
    //Assume that it has and will play
    @Override
    public boolean isUSBLoaded() {
        return loaded;
    }

    //Answering if the USB is unloaded.
    //Assume that it isn't and will continue to play
    @Override
    public void unloadUSB() {
        stopped = false;
        playing = false;
        paused = false;
        track = 0;
        totalTrack = 0;
        loaded = false;
    }

    //Want to know what the current track is now
    @Override
    public int currentTrackNumber()
    {
        return track;
    }

    //Want to know what the total track number that was loaded
    @Override
    public int totalTrackCount()
    {
        return totalTrack;

    }

    //Allows for straight Play of USB file
    @Override
    public void enableStraightPlayMode() {
        straight = true;
        shuffle = false;
    }

    //Allows for shuffle Play of USB file
    @Override
    public void enableShufflePlayMode() {
        if (!shuffle) {
            shuffle = true;
        }
        straight = false;

    }

    //Allows Play to stop. Once pressed the track will start at 1.
    @Override
    public void stop()
    {
        stopped = true;
        playing = false;
        paused = false;
        track = minTrack;
    }

    //Allows Pause
    @Override
    public void pause()
    {
        stopped = false;
        playing = false;
        paused = true;
    }

    //Allows for track to skip forward by 1 if in straight play mode
    @Override
    public void nextTrack() {
        if (isUSBLoaded()) {
            if (straight) {
                track++;
                if (track > totalTrack) {
                    track = minTrack;
                }
            } else {
                Random rand = new Random();
                track = rand.nextInt(totalTrack) + 1;
            }
        }
    }

    /**
     * Allows for track to skip back by 1 if in straight play mode
     **/
    @Override
    public void previousTrack() 
    {
        if (isUSBLoaded()) 
        {
            if (straight) 
            {
                track--;
                if (track < minTrack) 
                {
                    track = totalTrack;
                }
            }
            else
            {
                Random rand = new Random();
                track = rand.nextInt(totalTrack) + 1;
            }
        }
    }

    //Answering question is USB files playing
    @Override
    public boolean isPlaying() 
    {
        return playing;
    }

    
    /**
     * Answering question is USB files that was playing paused
     * 
     **/
    @Override
    public boolean isPaused()
    {
        return paused;
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
