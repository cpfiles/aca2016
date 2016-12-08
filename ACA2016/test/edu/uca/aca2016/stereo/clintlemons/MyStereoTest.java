/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.clintlemons;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Username
 */
public class MyStereoTest {
    
    public MyStereoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadUSB method, of class MyStereo.
     */
    @Test
    public void testLoadUSB() {
        System.out.println("loadUSB");
        MyStereo instance = new MyStereo();
        instance.loadUSB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextTrack method, of class MyStereo.
     */
    @Test
    public void testNextTrack() {
        System.out.println("nextTrack");
        MyStereo instance = new MyStereo();
        instance.nextTrack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of previousTrack method, of class MyStereo.
     */
    @Test
    public void testPreviousTrack() {
        System.out.println("previousTrack");
        MyStereo instance = new MyStereo();
        instance.previousTrack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUSBLoaded method, of class MyStereo.
     */
    @Test
    public void testIsUSBLoaded() {
        System.out.println("isUSBLoaded");
        MyStereo instance = new MyStereo();
        boolean expResult = false;
        boolean result = instance.isUSBLoaded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unloadUSB method, of class MyStereo.
     */
    @Test
    public void testUnloadUSB() {
        System.out.println("unloadUSB");
        MyStereo instance = new MyStereo();
        instance.unloadUSB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentTrackNumber method, of class MyStereo.
     */
    @Test
    public void testCurrentTrackNumber() {
        System.out.println("currentTrackNumber");
        MyStereo instance = new MyStereo();
        int expResult = 0;
        int result = instance.currentTrackNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalTrackCount method, of class MyStereo.
     */
    @Test
    public void testTotalTrackCount() {
        System.out.println("totalTrackCount");
        MyStereo instance = new MyStereo();
        int expResult = 0;
        int result = instance.totalTrackCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableStraightPlayMode method, of class MyStereo.
     */
    @Test
    public void testEnableStraightPlayMode() {
        System.out.println("enableStraightPlayMode");
        MyStereo instance = new MyStereo();
        instance.enableStraightPlayMode();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableShufflePlayMode method, of class MyStereo.
     */
    @Test
    public void testEnableShufflePlayMode() {
        System.out.println("enableShufflePlayMode");
        MyStereo instance = new MyStereo();
        instance.enableShufflePlayMode();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class MyStereo.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        MyStereo instance = new MyStereo();
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pause method, of class MyStereo.
     */
    @Test
    public void testPause() {
        System.out.println("pause");
        MyStereo instance = new MyStereo();
        instance.pause();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPlaying method, of class MyStereo.
     */
    @Test
    public void testIsPlaying() {
        System.out.println("isPlaying");
        MyStereo instance = new MyStereo();
        boolean expResult = false;
        boolean result = instance.isPlaying();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPaused method, of class MyStereo.
     */
    @Test
    public void testIsPaused() {
        System.out.println("isPaused");
        MyStereo instance = new MyStereo();
        boolean expResult = false;
        boolean result = instance.isPaused();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTrackList method, of class MyStereo.
     */
    @Test
    public void testLoadTrackList() throws Exception {
        System.out.println("loadTrackList");
        File trackListSource = null;
        MyStereo instance = new MyStereo();
        instance.loadTrackList(trackListSource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class MyStereo.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        MyStereo instance = new MyStereo();
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrackList method, of class MyStereo.
     */
    @Test
    public void testGetTrackList() {
        System.out.println("getTrackList");
        MyStereo instance = new MyStereo();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getTrackList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTrackFileName method, of class MyStereo.
     */
    @Test
    public void testGetCurrentTrackFileName() {
        System.out.println("getCurrentTrackFileName");
        MyStereo instance = new MyStereo();
        String expResult = "";
        String result = instance.getCurrentTrackFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
