/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.ACA1Woodruff;

//import edu.uca.aca2016.config.PropertiesExample;*/
import java.io.FileInputStream;
//import java.io.FileNotFoundException;*/
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author awood
 */
public class ChinookManager {

    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());

    private Properties Chinook = new Properties();
//    private Object Chinook;
//    private String chk;

    public ChinookManager() throws IOException, SQLException {
        FileInputStream in = null;
        try {
            Path inpath = Paths.get("resources", "config", "ACA1Woodruff", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.Chinook.load(in);
            this.con = DriverManager.getConnection(Chinook.getProperty("db.connection"));
            logger.log(Level.INFO, "Connecting to database:()", Chinook.getProperty("db.connection"));
        } finally {

            if (in != null) {
                in.close();
            }

        }
    }

    /**
     *
     * @param artist_name
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public void addArtist(String artist_name) throws SQLException {
        PreparedStatement ps = null;

        String sql = "INSERT INTO Artist(Name) VALUES(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artist_name);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     *
     * @param artist_name
     * @return
     * @thrown SQLException
     */

    public int getArtist(String artist_name) throws SQLException {
        PreparedStatement ps = null;
        int ArtistId = -1;
        String sql = "SELECT * FROM Artist WHERE UPPER (Name) = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artist_name.toUpperCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ArtistId = rs.getInt("ArtistId");
            }
            if (rs.next()) {
                ArtistId = -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.log(Level.INFO, "Return Artist Id:" + ArtistId);
        return ArtistId;
    }

    /**
     * @param id
     * @param Name
     * @return
     * @throws SQLException
     */
    public boolean updateArtist(int Id, String Name) throws SQLException {
        PreparedStatement ps = null;
        boolean update = false;
        String sql = "UPDATE Artist SET Name = ? WHERE ArtistId = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setInt(2, Id);
            int rtrn = ps.executeUpdate();
            if (rtrn == 1) {
                return true;
//           } else {
//               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();

            }

        }
        logger.log(Level.INFO, "Return Artist Name: {0}", Name);

        return update;
    }

    /**
     * @param Id
     * @param Name
     * @return
     * @thrown SQLException
     */

    public boolean deleteArtist(int Id) throws SQLException {
        PreparedStatement ps = null;
        boolean update = false;
//        PreparedStatement qs = null;
        String sql = "DELETE FROM Artist WHERE ArtistId = ?";
//        String chk = "SELECT * FROM Artist WHERE ArtistId = ?"; 
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
             int rtrn = ps.executeUpdate();
            if (rtrn == 1) {
                return true;
//           } else {
//               return true;
            }
            
//            qs = con.prepareStatement(chk);
//            qs.setInt(1, Id);            }
        } catch (SQLException ex) {
            logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
//            if (qs != null) {
//                qs.close();
//            }
        }
        return update;
    }
}

/**
 *
 * @param artist_name
 * @return
 * @throws java.sql.SQLException
 * @thrown SQLException
 */
//public boolean updateArtist(int id, String artist_name) throws SQLException {
//        PreparedStatement ps = null;
//        PreparedStatement qs = null;
//        String sql = "UPDATE Artist SET Name = (?) WHERE ArtistId = (?)";
//        String chk = "SELECT * FROM Artist WHERE Name = ?";
//        String ArtistName = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, Name);
//            ps.setInt(1,id);
//            ps.executeUpdate();
//            qs = con.prepareStatement(chk);
//            qs.setString(1, Name);
//            ResultSet rs = qs.executeQuery();
//            
//            if (rs.next()) {
//                ArtistName = Name;
//            }
//            
//            if (rs.next()) {
//                return false;
//            }
//        } catch (SQLException ex) {    
//           logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (qs != null) {
//                qs.close();
//            }
//        }
//    
