/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.lokeee;

import edu.uca.aca2016.interfaces.Stereo;
import java.util.Random;
/**
 *
 * @author lokeee
 */
public class MyStereo {
private boolean isPlaying =false;
private boolean isPaused = false;
private boolean isUSBLoaded = false;
private boolean isStopped = false;
private int Tracks;    

    
 public void loadUSB() {

Random rand = new Random();

int  Tracks =   rand.nextInt(1000)+1;
System.out.println (Tracks);


}

 public static void main(String[] args) {
     System.out.println (Tracks);
 }
 
}