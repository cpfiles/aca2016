package edu.uca.aca2016.jdbc.cpfiles;

import edu.uca.aca2016.config.PropertiesExample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChinookManager{
    Connection con;
    private static final Logger logger = Logger.getLogger(ChinookManager.class.getName());
    
    public ChinookManager(){
        try{
            Path inpath = Paths.get("resources","config","cpfiles", "ChinookManager.properties");
            FileInputStream in = new FileInputStream(inpath.toFile());
            Properties props = new Properties();
            props.load(in);
            in.close();
            
            logger.info("Connecting to database: " + props.getProperty("db.connection"));
            
            con = DriverManager.getConnection(props.getProperty("db.connection"));
        }
        catch(FileNotFoundException ex){
            logger.severe("File Not Found: " + ex.getMessage());
        }
        catch(IOException ex){
            logger.severe("IO Exception: " + ex.getMessage());
        }
        catch(SQLException ex){
            logger.severe("SQL Issue: " + ex.getMessage());
        }
    }
    
    public void addArtist(String name) {
        logger.info("Added artist '" + name + "' to the database ");
    }
    
    public int getArtist(String name) {
        logger.info("Not implemented");
        return -1;
    }
    
    public boolean updateArtist(int id, String name) {
        logger.info("Not implemented");
        return false;
    }
    
    public boolean deleteArtist(int id) {
        logger.info("Not implemented");
        return false;
    }
}
