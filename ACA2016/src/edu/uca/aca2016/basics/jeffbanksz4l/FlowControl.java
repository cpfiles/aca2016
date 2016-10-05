/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.jeffbanksz4l;

/**
 *
 * @author jeffb
 */
public class FlowControl {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 201; i++) {
            // Loop from 0 to 200 showing number that are divisible by 10
            if (i % 10 == 0) {
                System.out.println(i + " is Divisible by 10");
            }

            // Increment of 50 from the above loop
            if (i == 50) {
                int result = i / 5;
                System.out.println("50 divided by 5 " + result);
            }

            // Breaking the loop at 100 and printing the break value
            if (i == 100) {
                System.out.println(i + " is the final increment value");
                break;
            }
        }
    }
}
