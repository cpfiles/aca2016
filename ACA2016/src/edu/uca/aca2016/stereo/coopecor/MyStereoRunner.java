/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.coopecor;
import edu.uca.aca2016.interfaces.Stereo;

/**
 *
 * @author Cory's HP Pavilion
 */
public class MyStereoRunner {
    
    //Main function that calls my functions from Stereo Class
    public static void main(String[] args)
    {
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
