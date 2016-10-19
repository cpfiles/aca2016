/*
 * To change this license header, choose License Headers in Project PropertiesExample.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.config;

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
 * @author cfiles
 */
public class PropertiesExample{
    private Properties defaultProperties = new Properties();
    
    public PropertiesExample(){
        this.loadDefaultProperties();
        
        System.out.println(this.defaultProperties.getProperty("db.connection"));
    }

    private void loadDefaultProperties() {
        FileInputStream in = null;
        
        try{
            Path inpath = Paths.get("resources","config","PropertiesExample.properties");
            in = new FileInputStream(inpath.toFile());
            this.defaultProperties.load(in);
            in.close();
        }
        catch(FileNotFoundException ex){
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE,"Properties file was not found",ex);
        }
        catch(IOException ex){
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE,"Exception reading properties file",ex);
        }
        finally{
            try{
                if (in != null) {
                    in.close();
                }
            }
            catch(IOException ex){
                Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        PropertiesExample pe = new PropertiesExample();
    }
}
