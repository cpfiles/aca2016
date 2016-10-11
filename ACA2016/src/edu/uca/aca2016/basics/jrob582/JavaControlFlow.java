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
public class JavaControlFlow {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public static void main(String[] args) {
//for loop checks int iand increments by 1.
       for(int i=0; i<200; i++) 
        System.out.println (  +i);
        int i = 0;
       
// check to see if i is divisible by ten.
    if( i % 10 == 0){
     System.out.println (i + "is divisible by 10");
    }
     
//check i = 50 and do math when true
    if( i == 50){
       int divide = i / 5;
     System.out.println ("50 divided by 5 is" + divide + ".");
     
     }    
    if(i == 100){
     System.out.println (i + "is the final increment number");
   
    
    
     }
    }
}
    

