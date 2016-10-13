/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.sethdumas;

/**
 *
 * @author sethd
 */
public class FlowControl001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
//loop through 0 to 200 using for statement
        
        for(int i = 0; i <= 200; i++){
      
// use if statement and system.out to print if number is % by 10
       
        if(i%10 == 0) {
            System.out.println(i + " is divisible by 10");}
        
// if int is 50 print int divided by 5 is i/5  
        
        if(i == 50){
            System.out.println(i + " divided by 5 is " + i/5);}
// use else if to set i to 100, print tat it is final number

        else if (i == 100){
            System.out.println(i + " is the final number.");

//break the loop    
            break;
        }
        }
    
    
    }
    
}
