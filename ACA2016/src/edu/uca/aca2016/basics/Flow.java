/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics;

/**
 *
 * @author brela
 */
public class Flow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set loop from 0 to 200
        for (int i= 0; i<201; i++) {
            // prints out the numbers divisible by 10
            if (i % 10 == 0)
            System.out.println(i + " " + "is divisible by 10");
           //  when the number is 50 it will divide it by 5
            if (i == 50) {
              int  j = i / 5;
            System.out.println("50 divided by 5 is" + " " + j );
            // Once it gets to 100 it will stop and display the number
            }
            if (i == 100) {
                System.out.println(i + " " + "is the final increment number");
            break;
            }
                
        }
        
    }
    
}
