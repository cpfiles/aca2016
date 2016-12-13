/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
In this assignment you are going to build a class named ChinookManager. 
The class needs to be in a Java Package named: edu.uca.aca2016.jdbc.<github username>. 
Where <github username> is your github username. 
For this assignment I want you to make a branch in git named <github username>-005. 
All of your work will need to be completed in this branch. 
Note that this branch will be made off of the master branch.
Your class will have the following scope. 

1. Create a class constructor that takes zero parameters. 
This constructor needs to connect to the Chinook database we have been using in class. 
The database connection object should be a class level field. 
The configuration for the database (the path to the sqlite database) should come from a Java properties file. 
The file should be located in resources/config/<github username>/ and should be named ChinookManager.properties.

2. Create a method named addArtist that has a single parameter for the artist’s name. 
This method should insert a row into the Artist database table in order to make a new Artist record.

3. Create a method named getArtist that takes a single parameter for the artist’s name. 
This method needs to query the Artist table and attempt to find the artist the user requested. 
This needs to be a case insensitive search. 
The method should return the ID of the artist if one is found. 
If there is no match or there are multiple rows returned the method should return -1.

4. Create a method named updateArtist that takes two parameters: 
int id The id of the artist to be updated
String name The new name of the artist.
The method should find the artist record with the id provided, then update the name of the artist with the name provided. 
The method should return a boolean; true if the update was successful, false otherwise. 

5. Create a method named deleteArtist that takes a single parameter for the artist’s id. 
The method should find the artist with the id provided and delete it. 
The method should return a boolean; true if the operation was successful, false otherwise.

 */
/**
 *
 * @author Cory's HP Pavilion
 */
public class ChinookManager {

    private Connection con;
    private final Properties defaultProperties = new Properties();

    public ChinookManager() throws SQLException {
        this.loadDefaultProperties();
        String url = this.defaultProperties.getProperty("MyCreatedFile");
        con = DriverManager.getConnection(url);
        System.out.println(url);
    }

    private void loadDefaultProperties() {
        FileInputStream in = null;

        try {
            Path inpath = Paths.get("resources", "config", "coopecor", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.defaultProperties.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, "Properties file was not found", ex);
        } catch (IOException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, "Exception reading properties file", ex);
        }

    }

    public void addArtist(String newArtistName) throws SQLException {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO Artist (Name) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, newArtistName);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getArtist(String newArtistName) throws SQLException {
        int artistID = -1;

        try {
            String artist = ("SELECT ArtistId FROM Artist WHERE Upper (Name) = Upper (?)");
            PreparedStatement ps = con.prepareStatement(artist);
            ps.setString(1, newArtistName.toUpperCase());
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                artistID = result.getInt("ArtistId");
            }

            if (result.next()) {
                artistID = -1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            artistID = -1;
        }
        return artistID;
    }

    public boolean updateArtist(String newArtistName, int ID) throws SQLException {
        PreparedStatement ps = null;
        try {
            String update = "UPDATE Artist SET Name = ? WHERE ArtistId = ?";
            ps = con.prepareStatement(update);
            ps.setString(1, newArtistName);
            ps.setInt(2, ID);

            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteArtist(int artistID) throws SQLException {
        PreparedStatement ps = null;
        try {
            String update = "DELETE FROM Artist WHERE ArtistId = ?";
            ps = con.prepareStatement(update);
            ps.setInt(1, artistID);

            int result = ps.executeUpdate();
            if (result != 1) {
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*
    Below is the next assignment after completion:
    Load a CSV file. Only concered with the Artist Name. 
    Use a method called batchLoadArtist (File IO for Artist Name as the parameter)
     */
    public void batchLoadArtist(File path) throws SQLException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            String[] all = line.split(",");
            int col = 0;
            for( int i = 0; i < all.length; i++)
                if(all[i].equalsIgnoreCase("artist"))
                    col = i;
            
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                all = line.split(",");
                String artist;
                if(all[col].charAt(0) == '\"')
                {
                    artist = all[col] + "," + all[col+1];
                    artist = artist.replace("\"", " ");
                    artist = artist.trim();
                }
                else
                    artist = all[col];
                System.out.println(artist);
                addArtist(artist);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void batchLoadArtist (File path, int column) throws SQLException{
        try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line;
                while ((line = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line,",");
                    String artistName="";
                    for (int i=0; i<column; i++) {
                        artistName = st.nextToken();
                    }
                    addArtist(artistName);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void main(String[] args)
    {
        try {
            ChinookManager javadb = new ChinookManager();
            javadb.batchLoadArtist(new File ("resources/config/coopecor/Book4.csv"));
            System.out.println("---------------------------------------------");
            javadb.addArtist("Joy");
            System.out.println("---------------------------------------------");
            System.out.println(javadb.getArtist("Chico Buarque"));
            System.out.println("---------------------------------------------");
            System.out.println(javadb.updateArtist("Chico Science", 18));
            System.out.println("---------------------------------------------");
            System.out.println(javadb.deleteArtist(278));
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
