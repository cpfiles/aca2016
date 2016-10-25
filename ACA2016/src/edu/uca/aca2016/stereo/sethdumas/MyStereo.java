package edu.uca.aca2016.stereo.sethdumas;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

// @author sethd
public abstract class MyStereo implements Stereo {

    //assign fields to variables
    private int TotalTracks;
    private int CurrentTrack;
    private boolean isUSBLoaded;
    private boolean isPlaying;
    private boolean isPlayingStraight;
    private boolean isPlayingShuffle;
    private boolean isPaused;
    private boolean isStopped;

    //load a random number of mp3s
    @Override
    public void loadUSB() {
        isUSBLoaded = true;
        isPlaying = true;
        isPlayingStraight = true;
        Random rand = new Random();
        TotalTracks = (rand.nextInt(1000) + 1);
        while (TotalTracks == 0) {
            TotalTracks++;
            break;
        }
    }

    //tell if USB drive has been loaded
    @Override
    public void isUSBLoaded(){
        isUSBLoaded = true;
        while (isUSBLoaded = true) {
            isPlaying = true;
        }
    }

    //unload USB drive and reset
    @Override
    public void unloadUSB() {
        isUSBLoaded = false;
        while (isUSBLoaded == false) {
            TotalTracks = 0;
            CurrentTrack = 0;
            isPlayingStraight = false;
            isPlayingShuffle = false;
            isPlaying = false;
            isPaused = false;
            isStopped = false;
            break;
        }
    }

    //return current track number
    @Override
    public int currentTrackNumber() {
        return CurrentTrack;
    }

    //return the totaal number of tracks
    @Override
    public int totalTrackCount() {
        return TotalTracks;
    }

    //play tracks in sequential order
    @Override
    public void enableStraightPlayMode() {
        isPlaying = true;
        isPlayingStraight = true;
        isPlayingShuffle = false;
        isPaused = false;
        isStopped = false;
    }

    //play the tracks in a random order
    @Override
    public void enableShufflePlayMode() {
        isPlaying = true;
        isPlayingStraight = false;
        isPlayingShuffle = true;
        isPaused = false;
        isStopped = false;
    }

    //stop playing
    @Override
    public void stop() {
        isStopped = true;
    }

    //pause playing
    @Override
    public void pause() {
        isPaused = true;
        isPlaying = false;
        isStopped = false;
    }

    //advance to next track
    @Override
    public void nextTrack() {
        isPaused = false;
        isStopped = false;
        if (isUSBLoaded == true) {
            if (isPlayingStraight == true) {
                CurrentTrack++;
                if (CurrentTrack > TotalTracks);
                {
                    this.CurrentTrack = 1;
                }
                if (isPlayingShuffle == true) {
                    Random nextShuffle = new Random();
                    CurrentTrack = (nextShuffle.nextInt(TotalTracks++));
                }
            }

        }

    }

    //revert to previous track
    @Override
    public void previousTrack() {
        if (isUSBLoaded = true) {
            if (isPlayingStraight = true) {
                CurrentTrack--;
                if (CurrentTrack < 1);
                {
                    CurrentTrack = TotalTracks;
                }
            }
        }
    }

    //return whether or not track is playing
    @Override
    public boolean isPlaying() {
        isPlaying = true;
        isStopped = false;
        isPaused = false;
        return isPlaying;
    }

    //return whether or not track is paused
    @Override
    public boolean isPaused() {
        isPaused = true;
        isPlaying = false;
        isStopped = false;
        return isPaused;
    }
}
