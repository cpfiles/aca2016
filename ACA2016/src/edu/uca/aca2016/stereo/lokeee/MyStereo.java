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
public class MyStereo implements Stereo {
private boolean playing =false;
private boolean isUSBLoaded = false;
private boolean isStopped = false;
private boolean straightPlaymode = false;
private int track;   
private int totalTracks =0;
private int Numbers;

/* */
public void loadUSB(){
    Random rand = new Random();
    totalTracks = rand.nextInt(1000)+1 ;
    totalTracks++ ;
    straightPlaymode = true;
    
    
}

   public void isUSBLoaded() {
       isUSBLoaded = true;
   }
   
   public static void main(String[] args) {
       MyStereo bill = new MyStereo();
       bill.loadUSB();
       System.out.println (bill.totalTracks());
   }
}