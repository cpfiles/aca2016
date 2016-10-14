package edu.uca.aca2016.interfaces;

/**
 * An interface to unify a simple stereo firmware
 * @author cfiles
 */
public interface Stereo{
    /**
     * This method should load mp3s from a USB drive.
     * 
     * For our purposes, generate a random number of tracks between 1 and 1000.
     * This method should silently fail if the USB drive has already been loaded
     * and has not been unloaded.
     */
    public void loadUSB();

    /**
     * This method should tell the caller if the USB drive has been scanned for
     * mp3 files
     * @return
     */
    public boolean isUSBLoaded();

    /**
     * This method should unload the USB drive by resetting all of the counts
     * and counters.
     */
    public void unloadUSB();    
    
    /**
     * This method should return the number of the current track that is "playing".
     * @return The current track number.
     */
    public int currentTrackNumber();

    /**
     * Return the total number of tracks loaded from the USB drive.
     * @return The total number of tracks
     */
    public int totalTrackCount();
    
    /**
     * Plays the tracks in sequential order.
     * 
     * For our purposes, this method should set the current track to the first 
     * track and keep a record of the current track. Note the only way the program
     * moves to the next track is by calls to nextTrack and previousTrack.
     */
    public void enableStraightPlayMode();

    /**
     * Plays tracks in a random order. 
     * 
     * For our purposes, this method should set the current track to a random
     * track and keep a record of the current track.  Note the only way the program
     * moves to the next track is by calls to nextTrack and previousTrack.
     */
    public void enableShufflePlayMode();
    
    /**
     * Stop the playing process.
     */
    public void stop();

    /**
     * Pause the playing process.
     */
    public void pause();
    
    /**
     * Advance to the next track.
     */
    public void nextTrack();
    
    /**
     * Move to the previous track.
     */
    public void previousTrack();

    /**
     * Tell the caller if the stereo is playing.
     * @return
     */
    public boolean isPlaying();
    
    /**
     * Tell the caller if the stereo has been paused.
     * @return
     */
    public boolean isPaused();
}
