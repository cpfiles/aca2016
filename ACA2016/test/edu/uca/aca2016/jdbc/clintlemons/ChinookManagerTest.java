/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.clintlemons;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static com.oracle.nio.BufferSecrets.instance;
import java.sql.*;
import java.io.IOException;
import java.sql.SQLException;
import static jdk.nashorn.internal.objects.Global.instance;
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
      //  String Artist = "1";
        String Name = "Leonard Cohen";
        ChinookManager instance = new ChinookManager();
        instance.addArtist(Name);
        // TODO review the generated test code and remove the default call to fail.
        
    }
//        @Test
//    public void testaddArtist(){
//        System.out.println("addArtist");
//        String Name = "Leonard Cohen";
        //ChinookManager  = new ChinookManager();
//}//this.instance.addArtist(Name);
       //this.testaddArtist("1", "Leonard Cohen");
       //return ("Name");

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
        assertEquals("ArtistId", "Name");
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
    public void testDeleteArtist() {
        System.out.println("deleteArtist");
        int ArtistId = 0;
        ChinookManager instance = new ChinookManager();
        boolean expResult = false;
        boolean result = instance.deleteArtist(ArtistId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    public void testBatchLoader(){
        
    }
      
    }   
    

    
    
    
    
    
    
    
    
    /**
     *Test of ChinookManager method, of class ChinookManager.
     */
       
//    public void testGetArtist()
//       int result = instance.updateArtist(1,"artist_here");
//        assertEquals(1, result);
//       public void testupdateArtist()
//       boolean result = 
    
    
     /**
     * Test of addArtist method, of class ChinookManager.
     */    
//    @Test 
//    public void testChinookManager() {
//        System.out.println("ChinookManager");
//        ChinookManager instance = new ChinookManager();
        //instance.ChinookManager();
        // TODO review the generated test code and remove the default call to fail.
       
   
