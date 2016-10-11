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
        Automobile Firebird = new Automobile(4, 51, 3541);
        //prints Firebird stats to console
        System.out.println("The 2002 Pontiac Firebird has " + Firebird.getWheelNum() + " wheels.");
        System.out.println("It is " + Firebird.getHeight() + " inches tall.");
        System.out.println("It weighs " + Firebird.getWeight() + " pounds.");

        //creating new Truck, setting fields w/in main method, w/o initial parameters
        Truck Silverado = new Truck();
        Silverado.setHeight(76);
        Silverado.setWeight(5636);
        Silverado.setWheelNum(6);
        Silverado.setPayload(5764);
        Silverado.setTowCap(9900);
        //setFourWheel method actually does require parameters
        Silverado.setFourWheel(true);

        //Prints initial stats for Chevy Silverado
        System.out.println("The 2004 Chevy Silverado 3500 has " + Silverado.getWheelNum() + " wheels.");
        System.out.println("It is " + Silverado.getHeight() + " inches tall.");
        System.out.println("It weighs " + Silverado.getWeight() + " pounds.");
        System.out.println("It has a max payload of " + Silverado.getPayload() + " pounds.");
        System.out.println("And a max towing capacity of " + Silverado.getTowCap() + " pounds.");

        //checks isFourWheel to print whether Silverado does or doesn't have 4-wheel drive
        if (Silverado.isFourWheel() == true) {
            System.out.println("It has 4-wheel drive.");
        } else {
            System.out.println("It does not have 4-wheel drive.");
        }

        //testing Truck class w/ initial parameters    
        Truck Ranger = new Truck(4, 51, 3541, 3500, 7000, false);

        System.out.println("The Toyota Ranger has " + Ranger.getWheelNum() + " wheels.");
        System.out.println("It is " + Ranger.getHeight() + " inches tall.");
        System.out.println("It weighs " + Ranger.getWeight() + " pounds.");
        System.out.println("It has a max payload of " + Ranger.getPayload() + " pounds.");
        System.out.println("And a max towing capacity of " + Ranger.getTowCap() + " pounds.");

        //checks isFourWheel to print whether Silverado does or doesn't have 4-wheel drive
        if (Ranger.isFourWheel() == true) {
            System.out.println("It has 4-wheel drive.");
        } else {
            System.out.println("It does not have 4-wheel drive.");

        }
    }
}
