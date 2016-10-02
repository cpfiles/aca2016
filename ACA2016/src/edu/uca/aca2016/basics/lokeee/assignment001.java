/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.lokeee;

/**
 *
 * @author Bill Morgan
 */
public class assignment001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int index = 0; //Start index at 0
        int max = 100; // max index number
        // Using a while-loop expression.
        while (index++ < 200) {

            if ((index % 10) == 0) {  // using modulo to determine if the index is divisible by 10
                System.out.println(index + " Divisible by 10"); // if index is divisible by 10 this line will print

                if (index == 50) {
                    System.out.println("50 divided by 5 is " + index / 5); // when index hits 50 it will print the quotient of the division operation.    
                }
                if (index == max) {
                    System.out.println(index + " is the final increment value."); //once index reaches max this is the output
                    break; //break out of loop.
                }

            }
        }
    }
}
