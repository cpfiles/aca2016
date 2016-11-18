/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.sethdumas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sethd
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
        //assertTrue("");
    }

    /**
     * Test of addArtist method, of class ChinookManager.
     */
    @Test
    public void testAddArtist() throws Exception {
        System.out.println("addArtist");
        ChinookManager instance = new ChinookManager();
        instance.addArtist();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
