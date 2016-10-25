/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.config;

import java.util.Map;

/**
 *
 * @author cfiles
 */
public class SysProp{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
        
        System.out.println("The HOME property is: " + System.getProperty("home"));
        System.out.println("The user.home property is: " + System.getProperty("user.home"));
    }
}
