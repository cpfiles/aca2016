/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.shanamusiq;

/**
 *
 * @author Shana
 */
public class FlowControlOperators {
   public static void main(String[] args) {
       for(int i=0; i< 201; i++){
           //i is divisble by 10
           if(i%10 ==0)
           {System.out.println(i +" divisble by 10");
           }
          //i is 50;divide by 5
          {
           if(i==50)
           {
               int j;
               j = i/5;
           System.out.println("50 divided by 5 is " + j);
           }
       }
           // loop ends at 100
           if(i ==100){
              System.out.println(i + " is the final increment value");
           break;
           }
       }
   }
}
       
           
    


