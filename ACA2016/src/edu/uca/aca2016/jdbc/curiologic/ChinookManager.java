/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.curiologic;

import java.io.File;
import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author xulix
 */

public class ChinookManager{
    private Properties ChinookManager = new Properties();
    
       Connection con;
    
    public ChinookManager() throws SQLException{
        this.loadChinookManager();
       con = DriverManager.getConnection(ChinookManager.getProperty("db.connection"));
        
    }

    private void loadChinookManager() {
        FileInputStream in = null;
        
        try{
            Path inpath = Paths.get("resources","config","curiologic","ChinookManager.properties");
            in = new FileInputStream(inpath.toFile());
            this.ChinookManager.load(in);
            in.close();
        }
        catch(FileNotFoundException ex){
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE,"Properties file was not found",ex);
        }
        catch(IOException ex){
            Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE,"Exception reading properties file",ex);
        }
        finally{
            try{
                if (in != null) {
                    in.close();
                }
            }
            catch(IOException ex){
                Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    
public void addArtist (String addArtist) throws SQLException {
    
    PreparedStatement ppst = null;
    try {
    
     String sql = "INSERT INTO Artist(Name)VALUES (?)"; 
      ppst = con.prepareStatement(sql);
      ppst.setString(1, "Rage");
      ppst.executeUpdate();
}
    catch (SQLException ex) {
        Logger.getLogger(ChinookManager.class.getName()).log(Level.SEVERE,null,ex);
}
    finally {
        if (ppst !=null){
            ppst.close();
        }
    }
}
}



   

