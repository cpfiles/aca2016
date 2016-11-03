package edu.uca.aca2016.junit;

import edu.uca.aca2016.stereo.cpfiles.MyStereo;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cfiles
 */
public class MyStereoTest{
    private MyStereo stereo;
    
    public MyStereoTest(){
    }
    
    /*
        This method is executed once, before the start of all tests. It is 
        used to perform time intensive activities, for example, to connect to a 
        database. Methods marked with this annotation need to be defined as 
        static to work with JUnit.
    */
    @BeforeClass
    public static void setUpClass(){
    }
    
    /*
        This method is executed once, after all tests have been finished. It 
        is used to perform clean-up activities, for example, to disconnect from 
        a database. Methods annotated with this annotation need to be defined 
        as static to work with JUnit.
    */
    @AfterClass
    public static void tearDownClass(){
    }
    
    /*
        This method is executed before each test. It is used to prepare the test 
        environment (e.g., read input data, initialize the class).
    */
    @Before
    public void setUp(){
        this.stereo = new MyStereo();
    }
    
    /*
        This method is executed after each test. It is used to cleanup the test 
        environment (e.g., delete temporary data, restore defaults). It can also 
        save memory by cleaning up expensive memory structures.
    */
    @After
    public void tearDown(){
    }
    
    /*
        @Test 
        public void method()    
        The @Test annotation identifies a method as a test method.
        
        @Test (expected = Exception.class)  
        Fails if the method does not throw the named exception.

        @Test(timeout=100)
        Fails if the method takes longer than 100 milliseconds.
    */
    @Test // The @Test annotation identifies a method as a test method.
    public void testLoadUSB() {
        this.stereo.loadUSB();
        
        // http://www.vogella.com/tutorials/JUnit/article.html#usingjunit_asserts
        assertTrue("The USB drive should report it is loaded", this.stereo.isUSBLoaded());
        assertTrue("There should be more than one track", this.stereo.totalTrackCount() > 0);
        assertTrue("There should be 1000 or fewer tracks", this.stereo.totalTrackCount() <= 1000);
        assertTrue("The player should be 'playing'", this.stereo.isPlaying());
        
        assertFalse("The player should not be paused after a load", this.stereo.isPaused());
    }
    
    @Test
    public void testUnloadUSB() {
        this.stereo.loadUSB();
        this.stereo.unloadUSB();
        
        assertFalse("The USB drive status should be unloaded", this.stereo.isUSBLoaded());
        assertFalse("There is no USB drive, the stereo should not be 'playing'", this.stereo.isPlaying());
    }
    
    @Test
    public void testNextTrack_StraightPlay() {
        this.stereo.loadUSB();
        
        assertEquals(this.stereo.currentTrackNumber(), 1);
        assertTrue("There should be 1000 or fewer tracks", this.stereo.totalTrackCount() <= 1000);
        
        // force the player to advance to the last track.
        for (int i = 1; i < this.stereo.totalTrackCount(); i++) {
            this.stereo.nextTrack();
        }
        
        assertEquals(this.stereo.currentTrackNumber(), this.stereo.totalTrackCount());
        
        // advance past the last track
        this.stereo.nextTrack();
        
        assertEquals(this.stereo.currentTrackNumber(), 1);
    }
    
    @Test
    public void testNextTrack_ShufflePlay() {
        this.stereo.loadUSB();
        
        assertEquals(this.stereo.currentTrackNumber(), 1);
        assertTrue("There should be 1000 or fewer tracks", this.stereo.totalTrackCount() <= 1000);
        
        // for the rest of this test to work, we need at least 15 tracks.
        // we should unload and reload until we get there.
        while (this.stereo.totalTrackCount() < 15) {
            this.stereo.unloadUSB();
            this.stereo.loadUSB();
        }
        
        // enable shuffle play
        this.stereo.enableShufflePlayMode();
        
        // we are going to attempt to store 15 random tracks in a set
        Set<Integer> s = new HashSet<>();
            
        for (int i = 1; i < 15; i++) {
            this.stereo.nextTrack();
            
            s.add(this.stereo.currentTrackNumber());
        }
        
        // the idea is we *should* always get more than 5 random tracks out of 15 attempts.
        assertTrue("There should be at least 5 random tracks in 15 attempts", s.size() >= 5);
    }
}
