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
        for (int i= 0; i<201; i++) {
            if (i % 10 == 0)
            System.out.println(i + ":" + "is Divisible by 10");
            
            if (i == 50) {
              int  j = i / 5;
            System.out.println("50 divided by 5 is" + " " + j );
            }
            if (i == 100)
            break;
                
        }
        
    }
    
}
