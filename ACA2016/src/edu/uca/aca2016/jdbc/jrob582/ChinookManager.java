/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jrob582;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.JDBC;

/**
 *
 * @author johna
 */
public class ChinookManager {

    Connection con;

    private final Properties Properties;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());

    public ChinookManager() throws SQLException, IOException {
        this.Properties = new Properties();
        this.loadProperties();

        con = DriverManager.getConnection(this.Properties.getProperty("db.connection"));
    }

    private void loadProperties() throws IOException, SQLException {
        FileInputStream in = null;

        try {

            Path inpath = Paths.get("resources", "config", "jrob", "ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.Properties.load(in);
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, "null", ex);

        } catch (IOException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, "null", ex);

        } finally {

            if (in != null) {
                in.close();
            }

        }
    }

    /**
     *
     * @param Artistname
     * @throws SQLException
     */
    public void addArtist(String Artistname) throws SQLException {
        PreparedStatement ps = null;

        String sql = "INSERT into Artist (Name) VALUES(?)";
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

    /**
     *
     * @param Artistname
     * @return
     * @throws SQLException
     */
    public int getArtist(String Artistname) throws SQLException {
        PreparedStatement ps = null;
        int ArtistId = -1;
        String sql = "SELECT * FROM Artist WHERE UPPER (Name) = (?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Artistname.toUpperCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ArtistId = rs.getInt("ArtistId");
            }
            if (rs.next()) {
                ArtistId = -1;
            }

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        logger.log(Level.INFO, "Return ArtistId: (0)", ArtistId);
        return ArtistId;

    }

    /**
     *
     * @param ArtistId
     * @param Name
     * @return
     * @throws SQLException
     */
    public boolean updateArtist(int ArtistId, String Name) throws SQLException {
        PreparedStatement ps = null;

        String sql = "UPDATE Artist SET Name = (?) WHERE ArtistId = (?)";

        String ArtistName = Name;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setInt(2, ArtistId);
            int rs = ps.executeUpdate();

            if (rs == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();

            }

        }

        return false;
    }

    /**
     *
     * @param Id
     * @return
     * @throws SQLException
     */
    public boolean deleteArtist(int Id) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM Artist WHERE ArtistId = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, Id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();

            }

        }
        return false;
    }
//        public void batchLoadArtist(,int col){
//            
//        }
}

