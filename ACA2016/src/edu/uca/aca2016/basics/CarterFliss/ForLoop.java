/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.CarterFliss;

/**
 *
 * @author Carter
 */
public class ForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //for loop checks int i and increments by 1.
        for (int i = 0; i <= 200; i++) {
            //checks if i is divisible by 10 and prints out when true.  
            if (i % 10 == 0) {
                System.out.println(i + " is divisible by 10.");
            }
            //checks when i = 50 and performs math when true.
            if (i == 50) {
                int divide = i / 5;
                System.out.println("50 divided by 5 is " + divide + ".");
            }
            /* checks if i = 100 and breaks loop when true.
            *since loop breaks at 100, final increment is when i = 100.
            */
            if (i == 100) {
                System.out.println(i + " is the final increment value.");
                break;
            }

        }
    }

}
