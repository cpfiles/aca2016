/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.clintlemons;
import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;

/**
 *
 * @author Username
 */
public class StereoImp implements Stereo {

    private boolean IsUSBLoaded=false;
    private boolean loadUSB=true;
    private int Number_of_Tracks;
    private int Current_Track;
    private boolean IsPlaying = false;
    private boolean IsPaused = false;
    private boolean IsStopped = false;
    private boolean EnableShufflePlay = false;
    private boolean EnableStraightPlay = false;
    
        
    //public/private void loadUSB()?
    public void loadUSB(){
        Current_Track = 1;
        ShuffleTrack = new Random();
    }   
    //increment next track
    public void nextTrack(){
        if (IsUSBLoaded = true);
        if (EnableStraightPlay = true);
            Current_Track ++;
            if (Current_Track > Number_of_Tracks)
        if (EnableShufflePlay = true);
            Current_Track = new Random;
           // if (Current_Track < Number_of_Tracks);
    }
    //Decrement previous track
    public void previousTrack(){
        if (IsUSBLoaded = true);
        if (EnableStraightPlay = true);
            Current_Track --;
            if (Current_Track > Number_of_Tracks)
            if (Current_Track < Number_of_Tracks);
            
        
            
    
    
//    @Override
//    public void loadUSB() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void isUSBLoaded() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void unloadUSB() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int currentTrackNumber() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int totalTrackCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void enableStraightPlayMode() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void enableShufflePlayMode() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void stop() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void pause() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void nextTrack() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void previousTrack() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isPlaying() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isPaused() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            
//    
//    //public/private void loadUSB()?
//    public void loadUSB(){
//        Current_Track = 1;
//    }   
//    //increment next track
//    public void nextTrack(){
//        IsUSBLoaded = true;
//        EnableStraightPlay = true;
//            Current_Track ++;
//            Current_Track > Number_of_Tracks++;
//            if (Current_Track < Number_of_Tracks);
//    }
//    //Decrement previous track
//    public void previousTrack(){
//        if (IsUSBLoaded = true);
//        if (EnableStraightPlay = true);
//            Current_Track --;
//            if (Current_Track > Number_of_Tracks)
//            if (Current_Track < Number_of_Tracks);
//            
//        
    }
    
}
