/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.calhoun512;

/**
 *
 * @author calho
 */
public class AutoRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AutomobileACS truck = new AutomobileACS ();
        
        truck.setNumber_of_wheels(4);
        truck.setHeight(68);
        truck.setWeight(3500);
        
        Truck F150 = new Truck ();
        
        F150.setPayload_in_Pounds (2000);
        F150.setTowing_in_Pounds(6500);
        F150.setfour_wheel_drive(true);

        System.out.println("Number of Wheels:" + truck.getNumberOfWheels());
        System.out.println("Height(inches):" + truck.getHeight());
        System.out.println("Weight(lbs):" + truck.getWeight());
        System.out.println("Payload(lbs):" + F150.getPayload_in_Pounds());
        System.out.println("Towing Capacity(lbs):" + F150.getTowing_in_Pounds());
        System.out.println("Four Wheel Drive:" + F150.getFour_wheel_drive);
      
        
    
    }
    }
    

