/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.jdbc.jeffbanksz4l;

import java.io.File;
import java.sql.SQLException;

/**
 *
 * @author jeffb
 */
public class DB_Runner {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        ChinookManager CM = new ChinookManager();
        
        String db = System.getProperty("user.home") + File.separator + "Chinook_Sqlite.sqlite";
        
        CM.addArtist("jdbc:sqlite:" + db);
//        CM.addArtist("jdbc:sqlite:" + db);
        System.out.println("---------------------------------------------");
//        CM.connectAndUpdate("jdbc:sqlite:" + db);
//        CM.connectToAndQueryDatabase("jdbc:sqlite:" + db);
//        System.out.println("---------------------------------------------");
//        CM.connectAndDelete("jdbc:sqlite:" + db);
//        CM.connectToAndQueryDatabase("jdbc:sqlite:" + db);        
    }    
}
