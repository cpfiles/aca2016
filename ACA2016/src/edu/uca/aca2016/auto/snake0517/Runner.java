/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.snake0517;

/**
 *
 * @author brela
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automobile myAutomobile = new Automobile();
        
        myAutomobile.setNumber_of_wheels(4);
        myAutomobile.setHeight_in_inches(77.64);
        myAutomobile.setWeight_in_pounds(4510);
        
        System.out.println("Number of wheels:" + " " + myAutomobile.getNumber_of_wheels());
        System.out.println("Height in inches:" + " " + myAutomobile.getHeight_in_inches());
        System.out.println("Weight in pounds:" + " " + myAutomobile.getWeight_in_pounds());
        
        Truck myTruck = new Truck();
        
        myTruck.setPayload(2020);
        myTruck.setTowing_capacity(9400);
        myTruck.setFour_wheel_drive(true);
        
        System.out.println("Payload:" + " " + myTruck.getPayload());
        System.out.println("Towing capasity" + " " + myTruck.getTowing_capacity());
        System.out.println("Four wheel drive" + " " + myTruck.isFour_wheel_drive());
    }
    
}
