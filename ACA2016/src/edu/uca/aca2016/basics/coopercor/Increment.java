/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.coopercor;

/**
 *
 * @author Cory's HP Pavilion
 */
public class Increment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean breakLoop = false;
        while (!breakLoop) {
            for(int i=0; i<=200; i++){
                if (i%10 == 00)
                System.out.println("Number is: " + i);
                else if (i == 50)
                System.out.println ("Number is divided by 5: " + i/5);
                else if (i <=100) {
                breakLoop = true;
                System.out.println ("Final Number is: " + i);
                }
            }
        }
    }
}
        
    

