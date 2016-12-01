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
    private boolean q;

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
        logger.log(Level.INFO, ("Artist Id:" + ArtistId));
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

        return q;
    }

    /**
     * @param Id
     * @param Name
     * @return
     * @thrown SQLException
     */
    public boolean deleteArtist(int Id) throws SQLException {
        PreparedStatement ps = null;
        boolean q = false;
//        PreparedStatement qs = null;
        String sql = "DELETE FROM Artist WHERE ArtistId = ?";
//        String chk = "SELECT * FROM Artist WHERE ArtistId = ?"; 
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            int rtrn = ps.executeUpdate();
            if (rtrn == 1) {
                q = true;
            }

        } catch (SQLException ex) {
            logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return q;
    }
}
    public void loadBatchArtist (File f, int column) throws FileNotFoundException, SQLException {
        PreparedStatement ps = null;
        String line = "";
        String SplitBy = ",";

        try {
            BufferReader br = new BufferedReader (new FileReader(f));
            String sql = "INSERT INTO Artist WHERE Values = (?)";
            ps = con.prepareStatement(sql);
        }
    }

    public boolean saveOrUpdate(MonitoredData mData) {
        try {
            PreparedStatement prep;
            String timeID = this.getTimeLastRowID();

            for (CpuData o : mData.getCpu()) {
                prep = this.conn.prepareStatement(String.format(
                        INSERT_CPU_USAGE, this.nodeID, timeID, o.toString()));
                prep.addBatch();
                // saveOrUpdateToDatabase(String.format(INSERT_CPU_USAGE,
                // this.nodeID, timeID, o.toString()));
            }
            for (DiskData o : mData.getDisk()) {
                prep = this.conn.prepareStatement(String.format(
                        INSERT_DISK_USAGE, this.nodeID, timeID, o.toString()));
                prep.addBatch();
                // saveOrUpdateToDatabase(String.format(INSERT_DISK_USAGE,
                // this.nodeID, timeID, o.toString()));

            }
            for (NetworkData o : mData.getNet()) {
                prep = this.conn.prepareStatement(String
                        .format(INSERT_NETWORK_USAGE, this.nodeID, timeID, o
                                .toString()));
                prep.addBatch();
                // saveOrUpdateToDatabase(String.format(INSERT_NETWORK_USAGE,
                // this.nodeID, timeID, o.toString()));

            }

            prep = this.conn.prepareStatement(String.format(
                    INSERT_MEMORY_USAGE, this.nodeID, timeID, mData.getMem()
                            .toString()));
            // saveOrUpdateToDatabase(String.format(INSERT_MEMORY_USAGE,
            // this.nodeID, timeID, mData.getMem().toString()));

            conn.setAutoCommit(false);
            int[] r = prep.executeBatch();
            conn.setAutoCommit(true);

            return true;
     
        } catch (SQLException ex) {
            Logger.getLogger(HistoricalDatabase.class


            .getName()).log(
                    Level.SEVERE, null, ex);
        }
        return false;
    }

//public boolean saveOrUpdate(MonitoredData mData) {
//    try {
//        PreparedStatement prep;
//        String timeID = this.getTimeLastRowID();
//        conn.setAutoCommit(false);
//        for (CpuData o : mData.getCpu()) {
//            prep = this.conn.prepareStatement(INSERT_CPU_USAGE);
//            prep.setObject(1, this.nodeID);
//            prep.setObject(2, timeID);
//            prep.setObject(3, o);
//            prep.addBatch();
//            // saveOrUpdateToDatabase(String.format(INSERT_CPU_USAGE,
//            // this.nodeID, timeID, o.toString()));
//        }
//        prep.executeBatch();
//        for (DiskData o : mData.getDisk()) {
//            prep = this.conn.prepareStatement(INSERT_DISK_USAGE);
//            prep.setObject(1, this.nodeID);
//            prep.setObject(2, timeID);
//            prep.setObject(3, o);
//            prep.addBatch();
//            // saveOrUpdateToDatabase(String.format(INSERT_DISK_USAGE,
//            // this.nodeID, timeID, o.toString()));
//        }
//        prep.executeBatch();
//        for (NetworkData o : mData.getNet()) {
//            prep = this.conn.prepareStatement(INSERT_NETWORK_USAGE);
//            prep.setObject(1, this.nodeID);
//            prep.setObject(2, timeID);
//            prep.setObject(3, o);
//            prep.addBatch();
//            // saveOrUpdateToDatabase(String.format(INSERT_NETWORK_USAGE,
//            // this.nodeID, timeID, o.toString()));
//
//        }
//        prep.executeBatch();
//        prep = this.conn.prepareStatement(INSERT_MEMORY_USAGE);
//        prep.setObject(1, this.nodeID);
//        prep.setObject(2, timeID);
//        prep.setObject(3, o);
//        prep.executeUpdate();
//        // saveOrUpdateToDatabase(String.format(INSERT_MEMORY_USAGE,
//        // this.nodeID, timeID, mData.getMem().toString()));
//
//        conn.setAutoCommit(true);
//        return true;
//
//    } catch (SQLException ex) {
//        Logger.getLogger(HistoricalDatabase.class.getName()).log(
//                Level.SEVERE, null, ex);
//    }
//    return false;
//}
//You may need to modify those SQL query defined in the constants.
//
