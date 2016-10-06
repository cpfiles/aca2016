/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.CarterFliss;

/**
 *
 * @author Carter
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creating a new, non-truck Automobile, setting fields initially
        Automobile Firebird = new Automobile (4, 51, 3541);
        //prints Firebird stats to console
        System.out.println("The 2002 Pontiac Firebird has " + Firebird.WheelNum + " wheels.");
        System.out.println("It is " + Firebird.Height + " inches tall.");
        System.out.println("It weighs " + Firebird.Weight + " pounds.");
        
        //creating new Truck, setting fields w/in main method, w/o parameters
        Truck Silverado = new Truck ();
        Silverado.setHeight(76);
        Silverado.setWeight(5636);
        Silverado.setWheelNum(6);
        Silverado.setPayload(5764);
        Silverado.setTowCap(9900);
        //isFourWheel method doesn't require parameters, but defaults to "true"
        Silverado.isFourWheel(false);
        
        //Prints initial stats for Chevy Silverado
        System.out.println("The 2004 Chevy Silverado 3500 has " + Silverado.WheelNum + " wheels.");
        System.out.println("It is " + Silverado.Height + " inches tall.");
        System.out.println("It weighs " + Silverado.Weight + " pounds.");
        System.out.println("It has a max payload of " + Silverado.Payload + " pounds.");
        System.out.println("And a max towing capacity of " + Silverado.TowCap + " pounds.");
        
        //checks isFourWheel to print whether Silverado does or doesn't have 4-wheel drive
        if (Silverado.FourWheel == true) {
            System.out.println("It has 4-wheel drive.");
        }
        else {
            System.out.println("It does not have 4-wheel drive.");
        }
    }
    
}
