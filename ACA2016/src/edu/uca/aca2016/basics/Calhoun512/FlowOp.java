/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.Calhoun512;

/**
 *
 * @author calhoun512
 */
public class FlowOp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        /**
         * The following line initiates the count, sets the parameters and 
            increments, and prints the values. 
            **/
        
        for (int i = 1; i <= 200; i++){ {
            System.out.println("count is:" + i);
            
        }
        
        // This line divides 10 from its multiples then prints the results.

            if (i % 10 == 0) {
                System.out.println(i +" is divisible by 10. ");

            }

        // This line further divides 50 by 5, then prints the reust
        
            if (i == 50) {
                int divide = i / 5;
                System.out.println("50 divided by 5 is " + divide + ".");

            }
        
        // This line breaks the loop at '100' in the count 
      

            if (i == 100) {
                System.out.println(i + " is the final increment value.");
                break;
                
            
        }
    }

    
    
}

}

