/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.Calhoun512;

/**
 *
 * @author calho
 */

import java.sql.*
import java.util.properties;
import java.io.File;
import java.nio.Path;
import java.nio.Paths;
import java.io.FileInputStream;
import ChinookManager.properties;



public class ChinookManager{

    private Properties chinookManager = new Properties();

    public Properties(){
        this.loadDefaultProperties();
        
        System.out.println(this.chinookManager.getProperty("db.connection"));
        }

      private void loadDefaultProperties() {
          FileInputStream
        
}


}