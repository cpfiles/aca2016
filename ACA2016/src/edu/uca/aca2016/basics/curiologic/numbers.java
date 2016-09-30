/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.curiologic;

/**
 *
 * @author xulix
 */
public class numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int n = 200;
        for (int i = 0; i <= 200; i ++) {
            if (i == 100) {
               System.out.println(i + " is the final increment value");
                break;
                // breaks loop at 100 and stops loop
            }
            if (i % 10 == 0 ) {
                // checks if number is divisible by 10
                System.out.println(i + " is divisible by 10");
            } else
                 System.out.println(i);
            if (50/ 5 == i) {
               // divides 50 by 5
                System.out.println( "50 divided by 5 is "+ i);
                

                }
            }

        }
    }

