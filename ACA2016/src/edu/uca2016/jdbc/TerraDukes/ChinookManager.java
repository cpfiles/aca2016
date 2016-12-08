/*
C:\Users\DueTe\Downloads\ChinookDatabase1.4_Sqlite
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca2016.jdbc.TerraDukes;

/**
 *
 * @author DueTe
 */
import edu.uca.aca2016.config.PropertiesExample;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import static java.io.FileDescriptor.in;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Paths;

/**
 * Build a class named ChinookManager
 */
public class ChinookManager {

    public static void main(String[] args) throws SQLException {

    }
    /**
     * Establish Connection to the database. IQ & SQL Exception thrown
     *
     *
     */
    private Connection con;

    private Properties defaultProperties = new Properties();

    public ChinookManager() {
        try {
            Path inpath = Paths.get("resources", "config", "TerraDukes", "ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());
            Properties props = new Properties();
            props.load(in);
            in.close();

            con = DriverManager.getConnection(props.getProperty("db.connection"));
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (SQLException ex) {

        }
    }

    /*create method  connect-and delete- add/get/update/deleteArtist-single parameter for name.
     */
    public void connectAndDelete(String url) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
    }

    public void addArtist(String Artistname) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT into Artistname (Name) VALUES(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Artistname);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public int getArtist(String name) throws SQLException {
        PreparedStatement ps = null;
        int id = -1;
        try {

            String sql = "INSERT into Artist (Name) VALUES(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            id = rs.getInt("ArtistId");
            if (rs.next()) {
                id = -1;
            }
        } catch (SQLException ex) {

            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return id;
    }

    public Connection getCon() {
        return con;
    }

    public Properties getDefaultProperties() {
        return defaultProperties;
    }

    public void updateArtist(int id, String name) {
        String sql = "UPDATE ARTIST SET Email = ? WHERE Email= ?";
        ps.setString(1, "john@example.com");
        ps.setString(2, "example@example.com");
        ps.executeUpdate();
    }

    public void deleteArtist(int id, String name) throws SQLException {

        String sql = "DELETE ARTIST = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps.setString(1, "john@example.com");
        ps.executeUpdate();
        ChinookManager CM = new ChinookManager();
        CM.addArtist("MJB");
    }

    private boolean deleteArtist(int id) {

        return false;

    }

    public void batchLoadArtist(File Artist, int col) {
        try {
            PreparedStatement ps = null;
            String sql = "INSERT into Artistname (Name) VALUES(?)";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            ps = con.prepareStatement(sql);
            String[] ArtList;
            try {

                br = new BufferedReader(new FileReader(Artist));
                while ((line = br.readLine()) != null) {
                    ArtList = line.split(cvsSplitBy);

                    ps.setString(1, ArtList[col]);
                    ps.addBatch();

                }
                ps.executeBatch();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
