/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.auto.calhoun512;

/**
 *
 * @author calhoun512
 */
public class Truck extends AutomobileACS {
    
    private double payload_in_pounds;
    private double towing_in_pounds;
    private boolean four_wheel_drive = false;

    public Truck(double payload_in_pounds, double towing_in_pounds, int number_of_wheels, double height, double weight) {
        super(number_of_wheels, height, weight);
        this.payload_in_pounds = payload_in_pounds;
        this.towing_in_pounds = towing_in_pounds;
    }

    public Truck(double payload_in_pounds, double towing_in_pounds) {
        this.payload_in_pounds = payload_in_pounds;
        this.towing_in_pounds = towing_in_pounds;
    }
    
   
    }
    
    
    
    
}
