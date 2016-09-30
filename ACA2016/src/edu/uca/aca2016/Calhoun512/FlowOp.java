/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.Calhoun512;

/**
 *
 * @author calho
 */
public class FlowOp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        for (int i = 0; i <= 200; i++){ {
            System.out.println("count is:" + i);
            
        }

            if (i % 10 == 0) {
                System.out.print(i + " is divisible by 10. ");

            }

            if (i == 50) {
                int divide = i / 5;
                System.out.println("50 divided by 5 is - " + divide + ".");

            }

            if (i == 100) {
                System.out.println(i + " is the final increment value.");
                break;
                
            }
        }
    }

}

