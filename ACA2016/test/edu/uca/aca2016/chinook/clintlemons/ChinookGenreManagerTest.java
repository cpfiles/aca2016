/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.clintlemons;

import java.util.HashMap;
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
public class ChinookGenreManagerTest {
    
    public ChinookGenreManagerTest() {
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
     * Test of getGenres method, of class ChinookGenreManager.
     */
    @Test
    public void testGetGenres() {
        System.out.println("getGenres");
        int GenreID = 0;
        String Name = "";
        ChinookGenreManager instance = new ChinookGenreManager();
        HashMap<Integer, String> expResult = null;
        HashMap<Integer, String> result = instance.getGenres(GenreID, Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addGenre method, of class ChinookGenreManager.
     */
    @Test
    public void testAddGenre() {
        System.out.println("addGenre");
        String name = "";
        ChinookGenreManager instance = new ChinookGenreManager();
        boolean expResult = false;
        boolean result = instance.addGenre(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getGenreName method, of class ChinookGenreManager.
     */
    @Test
    public void testGetGenreName() {
        System.out.println("getGenreName");
        int id = 0;
        ChinookGenreManager instance = new ChinookGenreManager();
        String expResult = "";
        String result = instance.getGenreName(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateGenre method, of class ChinookGenreManager.
     */
    @Test
    public void testUpdateGenre() {
        System.out.println("updateGenre");
        int id = 0;
        String name = "";
        ChinookGenreManager instance = new ChinookGenreManager();
        boolean expResult = false;
        boolean result = instance.updateGenre(id, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGenre method, of class ChinookGenreManager.
     */
    @Test
    public void testDeleteGenre() {
        System.out.println("deleteGenre");
        int id = 0;
        ChinookGenreManager instance = new ChinookGenreManager();
        boolean expResult = false;
        boolean result = instance.deleteGenre(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
