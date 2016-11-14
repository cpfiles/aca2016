/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.curiologic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xulix
 */
public class MyStereoRunnerIO  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MyStereo MyTracks = new MyStereo();
        MyTracks.loadUSB();
        MyTracks.isUSBLoaded();
       MyTracks.enableStraightPlayMode();
       MyTracks.enableShufflePlayMode();
//        File tracks = new File("c:\\Users\\xulix\\Desktop\\tracks.txt");
//        Path inpath = Paths.get("c:\\Users\\xulix\\Desktop\\tracks.txt");
//       
//        try {
//            MyTracks.loadTrackList(tracks);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MyStereoRunnerIO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        
       
    
    }
}
