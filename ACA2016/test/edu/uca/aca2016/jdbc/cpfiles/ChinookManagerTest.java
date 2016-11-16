package edu.uca.aca2016.jdbc.cpfiles;

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
public class ChinookManagerTest{
    ChinookManager instance;
    
    public ChinookManagerTest(){
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            Path inpath = Paths.get("resources","config","cpfiles", "ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());
            Properties props = new Properties();
            props.load(in);
            in.close();
            
            con = DriverManager.getConnection(props.getProperty("db.connection"));
            
            ps = con.prepareStatement("DELETE FROM Artist");
            ps.executeUpdate();
            
            ps = con.prepareStatement("INSERT INTO Artist(id, name) VALUES(1, 'Aerosmith')");
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
    public static void tearDownClass(){
    }
    
    @Before
    public void setUp(){
        this.instance = new ChinookManager();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test of addArtist method, of class ChinookManager.
     */
    @Test
    public void testAddArtist(){        
        this.instance.addArtist("AC/DC");
    }

    /**
     * Test of getArtist method, of class ChinookManager.
     */
    @Test
    public void testGetArtist(){
        int result = instance.getArtist("Aerosmith");
        assertEquals(1, result);
    }

    /**
     * Test of updateArtist method, of class ChinookManager.
     */
    @Test
    public void testUpdateArtist(){
        boolean result = instance.updateArtist(1, "Aerosmith Reunited");
        assertEquals(true,result);
    }

    /**
     * Test of deleteArtist method, of class ChinookManager.
     */
    @Test
    public void testDeleteArtist(){
        boolean result = instance.deleteArtist(1);
        assertEquals(true,result);
    }
}
