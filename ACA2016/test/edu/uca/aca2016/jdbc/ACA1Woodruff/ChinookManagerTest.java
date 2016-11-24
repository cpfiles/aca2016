/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.ACA1Woodruff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
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
    ChinookManager instance;
    private static FileInputStream in;
    edu.uca.aca2016.jdbc.ACA1Woodruff.ChinookManager instance;
   
    public ChinookManagerTest(){
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            Path inpath = Paths.get("resources","config","ACA1Woodruff","ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());
            Properties Chinook = new Properties();
            Chinook.load(in);
            in.close();
            
            con = DriverManager.getConnection(Chinook.getProperty("db.connection"));
            
            ps = con.prepareStatement("DELETE FROM Artist");
            ps.executeUpdate();
            
            ps = con.prepareStatement("INSERT INTO Artist(id, name) VALUES(276, 'Fleetwood Mac')");
            ps.executeUpdate();
        }
        catch(FileNotFoundException ex){
            
        }
        catch(IOException ex){
            
        }
        catch(SQLException ex){
            
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.instance = new edu.uca.aca2016.jdbc."ACA1Woodruff".ChinookManager();
    }    
//        try {
//            this.instance = new ChinookManager();
//
//        } catch (IOException ex) {
//            Logger.getLogger(ChinookManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ChinookManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }*/
    
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testSomeMethod() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//        
    @Test
    public void testAddArtist() throws SQLException{        
        this.instance.addArtist("Fleetwood Mac");
    }

    /**
     * Test of getArtist method, of class ChinookManager.
     */
    @Test
    public void testGetArtist() throws SQLException{
        int result = instance.getArtist("Fleetwood Mac");
        assertEquals(1, result);
    }

    /**
     * Test of updateArtist method, of class ChinookManager.
     */
    @Test
    public void testUpdateArtist(){
        boolean result = instance.updateArtist(276, "Fleetwood Mack");
        assertEquals(true,result);
    }

    /**
     * Test of deleteArtist method, of class ChinookManager.
     */
    @Test
    public void testDeleteArtist(){
        boolean result = instance.deleteArtist(276);
        assertEquals(true,result);
    }
} 

