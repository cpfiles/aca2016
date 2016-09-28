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
        //creating breakloop for the loop function
        boolean breakLoop = false;
        //creating a while loop first
        while (!breakLoop) {
            //setting for loop to count to 200
            for(int i=0; i<=200; i++){
                //if the number is divisible by 10                
                if (i%10 == 00)
                System.out.println("Number is divisible by 10: " + i);
                //if the nuber is equal to 50 then divid by 5
                    if (i == 50)
                System.out.println ("Number is divided by 5: " + i/5);
                //if the number is greater or equal to 100 then stop the loop
                    if (i <=100) 
                breakLoop = true;
                System.out.println ("Final Number is: " + i);
                
            }
        }
    }
}
        
    

