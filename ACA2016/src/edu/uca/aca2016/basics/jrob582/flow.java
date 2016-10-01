/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.jrob582;

/**
 *
 * @author johna
 */
public class flow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        // TODO code application logic here
        //for loop checks int i and increments by 1.
        for (i = 0; i <= 200; i++) {
            // check if i is divisible by 10
            if (i % 10 == 0) {
                System.out.println(i + "is divisible by 10.");
            }
            // check when i = 50
            if (i == 50) {
                int divide = i / 5;
                System.out.println("50 divided by 5 is " + divide + ".");
            
            if (i == 100){
                System.out.println(i + "is the final increment value.");
            }
                        
            }
        }
    }
    
}
