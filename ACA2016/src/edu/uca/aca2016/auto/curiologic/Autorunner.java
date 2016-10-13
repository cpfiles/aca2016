/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.curiologic;

/**
 *
 * @author xulix
 */
// runner for the Automobile class
public class Autorunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // method for Automobile specs.
        // creates object using Automobile fields

        Automobile mytruck = new Automobile();
        {
            mytruck.setNumberOfWheels(4);
            mytruck.setHeightInInches(76.2);
            mytruck.setWeightInPounds(8500);

            System.out.println("number of wheels " + mytruck.getNumberOfWheels());
            System.out.println("Height " + mytruck.getHeightInInches() + " In.");
            System.out.println("Weight " + mytruck.getWeightInPounds() + " lbs.");

        }
        // creates object using Truck fields
        Truck ram = new Truck();
        {
            ram.setPayload(2000);
            ram.setTowing_capacity(2200);
            ram.setFour_wheel_drive(true);

            System.out.println("payload " + ram.getPayload() + " lbs");
            System.out.println("Towing Capacity " + ram.getTowing_capacity() + " lbs.");
            System.out.println("Four Wheel Drive " + ram.isFour_wheel_drive());
        }
    }
}
