package edu.uca.aca2016.jdbc.cpfiles;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    Connection con;

    /**
     * Creates a sqlite Chinook database instance and stages the artist table.
     * 
     * @throws IOException
     * @throws SQLException
     */
    @BeforeClass
    public static void setUpClass() throws IOException, SQLException{
        File db = new File(System.getProperty("user.home"), "Chinook_Sqlite.sqlite");
        db.deleteOnExit();

        Connection con = DriverManager.getConnection("jdbc:sqlite:" + db.getAbsolutePath());

        Statement s = con.createStatement();
        s.executeUpdate(
            "CREATE TABLE [Artist] " +
            "( " +
            "    [ArtistId] INTEGER  NOT NULL, " +
            "    [Name] NVARCHAR(120), " +
            "    CONSTRAINT [PK_Artist] PRIMARY KEY  ([ArtistId]) " +
            ")");

        s = con.createStatement();
        s.addBatch("INSERT INTO [Artist] ([ArtistId], [Name]) VALUES (1, 'AC/DC')");
        s.addBatch("INSERT INTO [Artist] ([ArtistId], [Name]) VALUES (2, 'Alice In Chains')");
        s.addBatch("INSERT INTO [Artist] ([ArtistId], [Name]) VALUES (3, 'Aerosmith')");
        s.executeBatch();

        s.close();
        con.close();
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass(){
    }
    
    /**
     * Creates an open connection to the test database so each test can 
     * check results.
     */
    @Before
    public void setUp() throws SQLException{
        File db = new File(System.getProperty("user.home"), "Chinook_Sqlite.sqlite");

        this.con = DriverManager.getConnection("jdbc:sqlite:" + db.getAbsolutePath());
    }
    
    /**
     * Closes the open connection to the test database
     */
    @After
    public void tearDown() throws SQLException{
        this.con.close();
    }

    /**
     * Test of addArtist method, of class ChinookManager.
     */
    @Test
    public void testAddArtist() throws SQLException{    
        ChinookManager instance = new ChinookManager();
        instance.addArtist("Buddy Guy");
        
        Statement s = this.con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Artist WHERE Name = 'Buddy Guy'");
        
        rs.next();
        assertEquals(4, rs.getInt("ArtistId"));
    }

    /**
     * Test of getArtist method, of class ChinookManager.
     */
    @Test
    public void testGetArtist(){
        ChinookManager instance = new ChinookManager();
        int result = instance.getArtist("Alice In Chains");
        assertEquals(2, result);
    }

    /**
     * Test of updateArtist method, of class ChinookManager.
     */
    @Test
    public void testUpdateArtist() throws SQLException{
        ChinookManager instance = new ChinookManager();
        boolean result = instance.updateArtist(3, "Aerosmith Reunited");
        assertEquals(true,result);
        
        Statement s = this.con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Artist WHERE Name = 'Aerosmith Reunited'");
        
        rs.next();
        assertEquals(3, rs.getInt("ArtistId"));
    }

    /**
     * Test of deleteArtist method, of class ChinookManager.
     */
    @Test
    public void testDeleteArtist() throws SQLException{
        ChinookManager instance = new ChinookManager();
        boolean result = instance.deleteArtist(1);
        assertEquals(true,result);
        
        Statement s = this.con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Artist WHERE Name = 'AC/DC'");
        
        boolean r = rs.next();
        assertEquals(false, r);
    }
}
