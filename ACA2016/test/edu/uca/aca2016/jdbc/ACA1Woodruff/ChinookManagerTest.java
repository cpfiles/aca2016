/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.ACA1Woodruff;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author awood
 */
public class ChinookManagerTest {
    
    public ChinookManagerTest() {
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
     * Test of addArtist method, of class ChinookManager.
     */
    @Test
    public void testAddArtist() throws Exception {
        System.out.println("addArtist");
        String artist_name = "Fleetwood Mac";
        ChinookManager instance = new ChinookManager();
        instance.addArtist(artist_name);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getArtist method, of class ChinookManager.
     */
    @Test
    public void testGetArtist() throws Exception {
        System.out.println("getArtist");
        String artist_name = "Fleetwood Mac";
        ChinookManager instance = new ChinookManager();
        int expResult = 276;
        int x = instance.getArtist("Fleetwood Mac");
        assertEquals(276, x);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateArtist method, of class ChinookManager.
     */
//    @Test
//    public void testUpdateArtist() throws Exception {
//        System.out.println("updateArtist");
//        int Id = 276;
//        String Name = "Fleetwood Mac";
//        ChinookManager instance = new ChinookManager();
//        boolean expResult = false;
//        boolean result = instance.updateArtist(276, "Fleetwood Mac");
//        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteArtist method, of class ChinookManager.
//     */
//    @Test
//    public void testDeleteArtist() throws Exception {
//        System.out.println("deleteArtist");
//        int Id = 275;
//        ChinookManager instance = new ChinookManager();
//        boolean expResult = false;
//        boolean result = instance.deleteArtist(276);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
