/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.stereo.ACA1Woodruff;

/**
 *
 * @author awood
 */
public class passwordvalidation {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
//      String passwd = "aaZZa44@"; 
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        System.out.println(passwd.matches(pattern));
    }
}
// TODO code application logic here

