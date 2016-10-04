/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.clintlemons;

/**
 *
 * @author Username
 */
   /**
     Build a Java class (with a main method) that satisfies the following scope:

The program loops from 0 to 200. 
When the loop increment is evenly divisible by 10, print “<number> is Divisible by 10” where <number> is the current increment of the loop.
When the loop increment is 50, divide the increment by 5 and print “50 divided by 5 is <number>” where <number> is the quotient of the division operation. 
When the loop increment is 100 break the loop.
Print “<number>" is the final increment value” where "<number>" is the final increment value.

     */
  //https://www.dotnetperls.com/for-java
  //fixed order of operations errors on lines 36 & 39)
public class Loop{
  // create loop that steps through 0-200 incrementally //
    public static void main(String[] args){
        
        for(int i=0; i<200; i++){
         //if number is divisible by 10
        if(i%10 == 0){        
        System.out.println ("number is divisible by 10"+1);
        //if i is 50 divide by 5
        }if(i == 50){
        System.out.println ("number is divisible by 5"+i/5);
        //if i is 100 break the loop
        }else if (i==100){
            System.out.println ("number is the final increment value"+i);
            break;
            }
        }
    }
}