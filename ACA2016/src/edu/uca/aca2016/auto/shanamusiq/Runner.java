/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.shanamusiq;

/**
 *
 * @author Shana
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Automobile Mercedes = new Automobile(4, 50, 500);
        System.out.println("The Mercedes has " + Mercedes.getNumberOfWheels() + " wheels.");
        System.out.println("The Mercedes is " + Mercedes.getHeight() + " inches tall.");
        System.out.println("The Mercedes weighs " + Mercedes.getWeight() + " pounds.");

        Truck F_150 = new Truck(4, 100, 1200, 5000, 10000, true);
        System.out.println("The F150 is " + F_150.getHeight() + " inches tall.");
        System.out.println("The F150 has " + F_150.getNumberOfWheels() + " wheels.");
        System.out.println("The F150 weighs " + F_150.getWeight() + " pounds.");
        System.out.println("The F150 can carry " + F_150.getPayload() + " pounds of cargo.");
        System.out.println("The F150 has a towing capacity of " + F_150.getTowCapacity() + " pounds.");
        System.out.println("Does the F150 have four wheel drive? " + F_150.isFourWheelDrive());
    }
}

