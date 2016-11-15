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
import edu.uca.aca2016.jdbc.Calhoun512.ChinookManager.properties;
import java.sql.Statement;



public class ChinookManager{

    private Properties chinook = new Properties();

    public chinookManager() throws IOException, SQLException {
        FileInputStream in = null;
        try{
            Path inpath = Paths.get("resources", "config", "Calhoun512", "ChinookManager");
            in = new FileInputStream(inpath.toFile()};
            this.chinook.load(in);
        
        
        System.out.println(this.chinookManager.getProperty("db.connection"));
        }

      private void loadDefaultProperties() {
          FileInputStream
        
}


}