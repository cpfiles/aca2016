/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;

///*import edu.uca.aca2016.interfaces.Stereo;
//import java.util.Random;*/
/**
 *
 * @author awood
 */
public class StereoRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStereo myTracks = new MyStereo();

        for (int x = 0; x < 4; x++) {
            System.out.println("Playing (false): " + myTracks.isPlaying());
            myTracks.loadUSB();
            System.out.println("Track Count: " + myTracks.totalTrackCount());
            System.out.println("Playing (true):" + myTracks.isPlaying());

            System.out.println("Straight Play:");
            for (int i = 1; i < myTracks.totalTrackCount() + 1; i++) {
                System.out.print(myTracks.currentTrackNumber() + "");
                myTracks.nextTrack();
            }
            System.out.println();

            for (int i = myTracks.totalTrackCount() + 3; i > 0; i--) {
                System.out.print(myTracks.currentTrackNumber() + " ");
                myTracks.previousTrack();
            }
            System.out.println();

            myTracks.pause();
            System.out.println("Paused (true): " + myTracks.isPaused());
            System.out.println("Playing (false): " + myTracks.isPlaying());

            myTracks.enableShufflePlayMode();

            for (int i = 0; i < 10; i++) {
                myTracks.nextTrack();
                System.out.print(myTracks.currentTrackNumber() + " ");
            }
            System.out.println();

            for (int i = 0; i < 10; i++) {
                myTracks.previousTrack();
                System.out.print(myTracks.currentTrackNumber() + " ");
            }
            System.out.println();

            myTracks.stop();
            System.out.println("Paused (false): " + myTracks.isPaused());
            System.out.println("Playing (false): " + myTracks.isPlaying());

            myTracks.enableStraightPlayMode(); // the enable straight play
            myTracks.unloadUSB();
            System.out.println("Loaded (false): " + myTracks.isUSBLoaded());
            System.out.println("Paused (false): " + myTracks.isPaused());
            System.out.println("Playing (false): " + myTracks.isPlaying());
        }
    }

}
