/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.clintlemons;

import java.io.BufferedReader;
import java.io.File;
import java.util.Properties;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.in;
import java.sql.*;
import java.util.logging.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 *
 * @author Username
 */
public class ChinookManager {
    Connection con;
    private final Properties defaultProperties =new Properties();
    int ArtistId = -1;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    /**
     *loads properties file
     * 
     */
    public void ChinookManager (){
        FileInputStream in;
        try{
            stmt = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            Path inpath = Paths.get("resources","config","clintlemons","ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.defaultProperties.load(in);
            defaultProperties.getProperty("ChinookManager.properties");
           con=DriverManager.getConnection(defaultProperties.getProperty("db.connection"));
           in.close();
        } catch (FileNotFoundException Properties_Not_Found) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.WARNING, null, Properties_Not_Found);
        } catch (IOException Properties_IO_Error) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.WARNING, null, Properties_IO_Error);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     *Add Artist Name
     * @param Name
     */
    public void addArtist(String Name){
        try {con=DriverManager.getConnection(defaultProperties.getProperty("db.connection"));
        }
        catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }       
           try {
               String query= ("INSERT INTO ARTIST (Name)VALUES(?,?)");
               con.createStatement();
               ps.setString(1, Name);
               ps.executeUpdate(query);
               in.close();
           } catch (SQLException | IOException ex) {
               Logger.getLogger(ChinookManager.class.getName()).log(Level.WARNING, null, ex);
           }
    }
    /**
     *Get Artist Name
     * @param  Name
     * @return
     * @throws SQLException
     */
    public int getArtist(String Name) throws SQLException{
        rs = stmt.executeQuery("SELECT*FROM Artist WHERE UPPER (Name)=(?)"); 
            if (!con.isValid(30)) {
            } else {
                    con.rollback();
                    con.close();
                    Logger.getLogger("connection time-out");
                }
            try {
            String query= ("INSERT INTO ARTIST (Name)VALUES(?,?)");
            con.prepareStatement("String Name %NaMe%");
            ps.setString(1, Name.toUpperCase());
            rs = ps.executeQuery(query);
            if (rs.next()){
               rs.getInt("ArtistId");
            }
            if (rs.next()){
               return ArtistId=-1;
            }
            }catch (SQLException ex) {
               Logger.getLogger("Exception!"+ChinookManager.class.getName()).log(Level.WARNING, null, ex);
            }
            finally {
                if (ps !=null);
                ps.close();
            }
            return this.ArtistId;
    }   
    
    /**
     *
     * @param ArtistId
     * @param Name
     * @return
     * @throws SQLException
     */
    public boolean updateArtist(int ArtistId, String Name){
                boolean update = false;    
            try {rs = stmt.executeQuery("SELECT*FROM Artist WHERE UPPER (Name)=(?)");
                if (!con.isValid(30)) {
            } 
                else {
                con.rollback();
                con.close();
                Logger.getLogger("connection time-out");
            }
        } catch (SQLException ex) {
            Logger.getLogger("Exception"+ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
                try {
                    String query= ("UPDATE ARTIST (Name)VALUES(?,?)");
                    ps =con.prepareStatement("UPDATE ARTIST WHERE ARTIST ");
                    ps.setString(1, Name.toUpperCase());
                    ps.setInt(2, ArtistId);
                    ps.executeUpdate(query);
                    if(ArtistId == 1){
                        update = true;
                    }        
                } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
                    try {
                        if(ps !=null);
                        ps.close();
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger("Exception!"+ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return update;
        }
    
    /**
     *
     * @param ArtistId
     * @return
     * @throws SQLException
     */
    public boolean deleteArtist(int ArtistId) throws SQLException{
            boolean update = false;
            rs = stmt.executeQuery("DELETE FROM Artist"+ "WHERE ArtistId =(?)");
            if (!con.isValid(30)) {
            } else {
                    con.rollback();
                    con.close();
                    Logger.getLogger("connection time-out");
                }
            try {
            con.prepareStatement("String Name %NaMe%");
            ps.setInt(1, ArtistId);
            int Id = ps.executeUpdate();
            if(ArtistId == 1){
                update = true;
            }        
            } 
            catch (SQLException ex) {
            Logger.getLogger("Exception!"+ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
            }   finally {
                if (ps !=null);
                ps.close();
                con.close();
            }return update;    
    }
    /**
     *BatchLoadArtist
     * @param f
     * @param Col
     */
    public void BatchLoadArtist(File f, int Col){      
        String query = "INSERT INTO ARTIST (Name)VALUES(?)"+"";
        String line = "";
        String cvsSplitBy = ",";
        String[] set = null;
        final int batchSize = 1000;
        int count = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while ((query = br.readLine()) != null) {
                set = query.split(cvsSplitBy);
                
            }   for(String name : set){
                this.ps = this.con.prepareStatement(query);
                this.ps.setString(1,set[Col]);
                ps.addBatch();
                if(++count % batchSize == 0) {
		ps.executeBatch();
                }
                ps.close();
                con.close();         
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger("Exception!"+ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                
}
