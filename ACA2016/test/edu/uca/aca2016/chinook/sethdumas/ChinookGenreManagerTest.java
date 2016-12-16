/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.sethdumas;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
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
public class ChinookGenreManagerTest {

    private Connection con;
    
    public ChinookGenreManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
     public void setUp() throws SQLException{
        File db = new File(System.getProperty("user.home"), "Chinook_Sqlite.sqlite");

        this.con = DriverManager.getConnection("jdbc:sqlite:" + db.getAbsolutePath());
    }
    
    
    @After
    public void tearDown() throws SQLException{
        this.con.close();
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    /**
     * Test of getGenres method, of class ChinookGenreManager.
     */
    @Test
    public void testGetGenres() {
        System.out.println("getGenres");
        ChinookGenreManager instance = new ChinookGenreManager();
        HashMap<Integer, String> expResult = null;
        HashMap<Integer, String> result = instance.getGenres();
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
        String genrename = "Psycho Flute Rock";
        ChinookGenreManager instance = new ChinookGenreManager();
        boolean expResult = true;
        boolean result = instance.addGenre(genrename);
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
        int id = 12;
        ChinookGenreManager instance = new ChinookGenreManager();
        String expResult = "Easy Listening";
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
        int id = 8;
        String name = "Roots Reggae";
        ChinookGenreManager instance = new ChinookGenreManager();
        boolean expResult = true;
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
        int id = 11;
        ChinookGenreManager instance = new ChinookGenreManager();
        boolean expResult = true;
        boolean result = instance.deleteGenre(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getArtistName method, of class ChinookGenreManager.
     */
    

    
}
