/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.jeffbanksz4l;

/**
 * This is the runner for the Automobile class.
 * @author jeffb
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automobile myFord = new Automobile();

        myFord.setNumber_of_wheels(4);
        myFord.setHeight_in_inches(77.3);
        myFord.setWeight_in_pounds(4937);

        System.out.println("Number of wheels: " + myFord.getNumber_of_wheels());
        System.out.println("Height in inches: " + myFord.getHeight_in_inches());
        System.out.println("Weight in pounds: " + myFord.getWeight_in_pounds());

        Truck myF150 = new Truck();

        myF150.setPayload(3270);
        myF150.setTowing_capacity(12200);
        myF150.setFour_wheel_drive(true);

        System.out.println("Payload: " + myF150.getPayload());
        System.out.println("Towing Capacity: " + myF150.getTowing_capacity());
        System.out.println("Four wheel drive: " + myF150.isFour_wheel_drive());
    }
}
