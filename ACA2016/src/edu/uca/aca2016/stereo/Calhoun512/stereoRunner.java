/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.Calhoun512;



/**
 *
 * @author calho
 */
public class stereoRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MyStereo Tracks = new MyStereo();
        
        Tracks.currentTrackNumber();
        Tracks.loadUSB();
        Tracks.isUSBLoaded();
      
        
        
        System.out.println("Number of Tracks: " + Tracks.totalTrackCount());
        System.out.println("Currently Playing: " + Tracks.currentTrackNumber);
        System.out.println("USB Loaded?: " + Tracks.isUSBLoaded());
        
        
        
        
        
        
                
    }
    
}
