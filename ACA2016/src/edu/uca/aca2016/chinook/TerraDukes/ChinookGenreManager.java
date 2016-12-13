/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.chinook.TerraDukes;

import edu.uca.aca2016.config.PropertiesExample;
import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.util.Arrays.stream;
import static java.util.Arrays.stream;
import static java.util.Arrays.stream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DueTe
 */
public class ChinookGenreManager {

    Enumeration<URL> url;
    InputStream stream;
    Properties props = new Properties();

    public ChinookGenreManager() {
        try {
            this.stream = new FileInputStream(url.nextElement().getPath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.url = ChinookManager.class.getClassLoader().getResources("config/duete/ChinookManager.properties");
        } catch (IOException ex) {
            Logger.getLogger(ChinookGenreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    
    
}
/**
    "Connecting to database: " + props.getProperty("db.connection"));
            
            // the properties file loaded, attempt to connect using the value of the "db.connection" property
    Class.forName (
            

"org.sqlite.JDBC");
}if (this.con

            == null) {
        try {
            Connection con = DriverManager.getConnection(props.getProperty("db.connection"));
            catch(FileNotFoundException ex){
                    logger.severe("File Not Found: " + ex.getMessage());
                    }
            catch(IOException ex){
                    logger.severe("IO Exception: " + ex.getMessage());
                    }
            catch(SQLException ex){
                    logger.severe("SQL Issue: " + ex.getMessage());
                    }
            catch(ClassNotFoundException ex){
                    logger.severe("Class not found: " + ex.getMessage());
                    

}
                
            
        } catch (SQLException ex) {
            Logger.getLogger(ChinookGenreManager.class
.getName()).log(Level.SEVERE, null, ex);
        }
}


    public static void main(String[] args) {
        PropertiesExample pe = new PropertiesExample();
*/


    






    
