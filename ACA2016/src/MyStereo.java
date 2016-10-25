/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cory's HP Pavilion
 */
import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

public class MyStereo implements Stereo {

    //create variables
    private int track;
    private int totalTrack;
    private boolean stopped;
    private boolean playing;
    private boolean paused;
    private boolean loaded;
    private boolean shuffle;
    private int maxTrack;
    private int minTrack;
    private boolean straight;

    //initalize variables
    public MyStereo() {
        loaded = false;
        stopped = false;
        playing = false;
        paused = false;
        shuffle = false;
        straight = false;
        track = 0;
        totalTrack = 0;
        maxTrack = 1000;
        minTrack = 1;
    }

    //When USB is loaded it should play the first track.
    //Assume straight play mode
    @Override
    public void loadUSB() {
        Random rand = new Random();
        track = rand.nextInt(maxTrack) + 1;
        totalTrack++;
        playing = true;
        straight = true;
    }

    //Answering if the USB has been loaded.
    //Assume that it has and will play
    @Override
    public void isUSBLoaded() {
        loaded = true;
        straight = true;
    }

    //Answering if the USB is unloaded.
    //Assume that it isn't and will continue to play
    @Override
    public void unloadUSB() {
        stopped = false;
        playing = false;
        paused = false;
        track = 0;
    }

    //Want to know what the current track is now
    @Override
    public int currentTrackNumber() {
        return track;
    }

    //Want to know what the total track number that was loaded
    @Override
    public int totalTrackCount() {
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
    public void stop() {
        stopped = true;
        playing = false;
        paused = false;
        track = minTrack;
    }

    //Allows Pause
    @Override
    public void pause() {
        stopped = false;
        playing = false;
        paused = true;
    }

    //Allows for track to skip forward by 1 if in straight play mode
    @Override
    public void nextTrack() {
        if ((playing == true) && (loaded == true)) {
             if (straight == true){
             track++;
             if (track > totalTrack){
                 track = minTrack;
             }
            }
            else{   Random rand = new Random();
                    track = rand.nextInt(totalTrack) + 1;
                    }
        }
    }

    //Allows for track to skip back by 1 if in straight play mode
    @Override
    public void previousTrack() {
        if ((playing == true) && (loaded == true)) {
             if (straight == true){
             track--;
             if (track < minTrack){
                 track = totalTrack;
             }
            }
            else{   Random rand = new Random();
                    track = rand.nextInt(totalTrack) + 1;
                    }
        }
    }

    //Answering question is USB files playing
    @Override
    public boolean isPlaying() {
        return playing;
    }

    //Answering question is USB files that was playing paused
    @Override
    public boolean isPaused() {
        return paused;
    }

    //Main function that calls my functions from Stereo Class
    public static void main(String[] args) {
        Stereo stereo = new MyStereo();
        stereo.loadUSB();
        stereo.currentTrackNumber();
        stereo.enableShufflePlayMode();
        stereo.enableStraightPlayMode();
        stereo.isPaused();
        stereo.isPlaying();
        stereo.isUSBLoaded();
        stereo.loadUSB();
        stereo.nextTrack();
        stereo.pause();
        stereo.previousTrack();
        stereo.stop();
        stereo.totalTrackCount();
        stereo.unloadUSB();
    }

}
