/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.clintlemons;

import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
import java.io.File;
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
     * Test of ChinookManager method, of class ChinookManager.
     */
    @Test
    public void testChinookManager() {
        System.out.println("ChinookManager");
        ChinookManager instance = new ChinookManager();
        instance.ChinookManager();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addArtist method, of class ChinookManager.
     */
    @Test
    public void testAddArtist() {
        System.out.println("addArtist");
        String Name = "";
        ChinookManager instance = new ChinookManager();
        instance.addArtist(Name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getArtist method, of class ChinookManager.
     */
    @Test
    public void testGetArtist() throws Exception {
        System.out.println("getArtist");
        String Name = "";
        ChinookManager instance = new ChinookManager();
        int expResult = 0;
        int result = instance.getArtist(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateArtist method, of class ChinookManager.
     */
    @Test
    public void testUpdateArtist() throws Exception {
        System.out.println("updateArtist");
        int ArtistId = 0;
        String Name = "";
        ChinookManager instance = new ChinookManager();
        boolean expResult = false;
        boolean result = instance.updateArtist(ArtistId, Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteArtist method, of class ChinookManager.
     */
    @Test
    public void testDeleteArtist() throws Exception {
        System.out.println("deleteArtist");
        int ArtistId = 0;
        ChinookManager instance = new ChinookManager();
        boolean expResult = false;
        boolean result = instance.deleteArtist(ArtistId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of BatchLoadArtist method, of class ChinookManager.
     */
    @Test
    public void testBatchLoadArtist() throws Exception {
        System.out.println("BatchLoadArtist");
        File f = null;
        int Col = 0;
        ChinookManager instance = new ChinookManager();
        instance.BatchLoadArtist(f, Col);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
