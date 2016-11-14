/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.clintlemons;

import java.util.Properties;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import static java.lang.System.in;
import java.util.Dictionary;
/**
 *
 * @author Username
 */
public class ChinookManager {

    private Object defaultProperties;
    /**
     *Properties
     */
    public void loadDefaultProperties() {
            defaultProperties = file.in("ChinookManager.properties");
            Path inpath = Paths.get("ChinookManager.properties");
           // in = new FileInputStream(inpath.toFile());
          //  this.defaultProperties.load();
           // in.close();
           
           
        }
        
//        default.FileInputStream = ("ChinookManager.properties") {
//        this.toString();
//        default.Properties = 
//        
//    }
//  
//            
}


    

