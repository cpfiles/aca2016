/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.shanamusiq;

import edu.uca.aca2016.config.PropertiesExample;
import edu.uca.aca2016.jdbc.JDBCExample;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

/**
 *
 * @author Shana
 */
public class ChinookManager {

    private Properties defaultProperties = new Properties();
    private String dbURL;
    private Connection con;

    /*
    Create a class constructor that takes zero parameters. This constructor needs to connect to the Chinook database we have been using in class. The database connection object should be a class level field. The configuration for the database (the path to the sqlite database) should come from a Java properties file. The file should be located in resources/config/<github username>/ and should be named ChinookManager.properties.
     */
    public ChinookManager() throws SQLException {
        this.loadDefaultProperties();
        dbURL = this.defaultProperties.getProperty("ChinookDatabase.connection");
        con = DriverManager.getConnection(dbURL);
        System.out.println(dbURL);
    }

    public static void main(String[] args) throws SQLException {
        ChinookManager cm = new ChinookManager();
        cm.addArtist("Shana");
        System.out.println("Added artist Shana");
        int id = cm.getArtist("Aerosmith");
        System.out.println(id);
        System.out.println(cm.updateArtist("Drake", 20));
        System.out.println(cm.deleteArtist(278));
    }

    private void loadDefaultProperties() {
        FileInputStream in = null;

        try {

            //Path inpath = Paths.get("resources","config","shanamusiq","ChinookManager.properties");
            File f = new File("C:\\Users\\Shana\\Documents\\NetBeansProjects\\aca2016\\ACA2016\\resources\\config\\shanamusiq\\ChinookManager.properties");
            in = new FileInputStream(f);
            this.defaultProperties.load(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, "Properties file was not found", ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, "Exception reading properties file", ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*Create a method named addArtist that has a single parameter for the artist’s name. 
    This method should insert a row into the Artist database table in order to
    make a new Artist record.
     */
    public void addArtist(String artistName) throws SQLException {

        PreparedStatement ps = null;

        try {

            String sql = "INSERT INTO Artist (Name) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, artistName);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    getArtist method takes a single parameter for the artist’s name.
    This method needs to query the Artist table and attempt to find the artist the user requested.
    The method should return the ID of the artist if one is found. If there is
    no match or there are multiple rows returned the method should return null.
     */
    public int getArtist(String artistName) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Statement stmt = con.createStatement();
        int artistID = -1;

        try {
            String sql = ("SELECT artistID FROM Artist WHERE Upper (Name) = Upper (?)");
            ps = con.prepareStatement(sql);
            ps.setString(1, artistName.toUpperCase());
            rs = ps.executeQuery();

            if (rs.next()) {
                artistID = rs.getInt("artistId");
            }
            if (rs.next()) {
                artistID = -1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            artistID = -1;
        }
        return artistID;
    }

    /*
    updateArtist method that takes two parameters: 
    int id The id of the artist to be updated
    String name The new name of the artist.
 
     */
    public boolean updateArtist(String artistName, int artistId) throws SQLException {
        PreparedStatement ps = null;

        try {

            String sql = "UPDATE Artist SET Name = ? WHERE artistId = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, artistName);
            ps.setInt(2, artistId);

            int rs = ps.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*	deleteArtist method takes a single parameter for the
artist’s id. The method should find the artist with the id provided and delete it.
The method should return a boolean; true if the operation was successful, false
otherwise.
     */
    public boolean deleteArtist(int artistId) throws SQLException {
        PreparedStatement ps = null;

        try {

            String sql = "DELETE FROM Artist WHERE artistId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, artistId);

            int rs = ps.executeUpdate();
            if (rs == 1) {
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
            return true;
    }

    /**
     * This method reads the first column of the CSV file and loads it into the
     * database. Update artist column.
     *
     * @param csvFile
     * @param col
     * @throws SQLException
     */
    public void batchLoadArtist(File csvFile, int col) throws SQLException {
        BufferedReader br = null;
        int i;
        PreparedStatement ps = null;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] artist = line.split(",");
                String sql = "INSERT into Artist (Name) VALUES (?)";
                ps.setString(1, artist[col]);
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

