/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/*Flow Control & Operators Assignment
Author: Terra D Dukes, duetea@gmail.com
Week 2- Tuesday, September 27, 2016
 */
package edu.uca.aca2016.basics.terradukes;
             
//Build a Java class with a main method

public class FlowControlOperators {
    
    public static void main(String[] args) {
        
//Establish interger

        int temp, i;
//The program loops from 0 to 200

        for(i = 0; i <= 200; i++) {
            
//When loop is evenly divisible by 10

            if( i % 10 == 0) {
                
//Print this statement           

                System.out.println(i + " is divisible by 10");
                }
            
//When loop is divisible by 50 
            if(i == 50) {
                
//Divide by 5
                temp = 50 / 5;
                
//Print this statement                
                System.out.println("50 divided by 5 is " + temp);
                }
            //When the loop increment is 100 break
                
            if(i == 100) {
                break;
                }
            }
        //Prin this statement for final increment value
        
            System.out.println(i + " is the final increment value");
            System.out.println("This assignment sent me in LOOPS :/");
        }
    }

