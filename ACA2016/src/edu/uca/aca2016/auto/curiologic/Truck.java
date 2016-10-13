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
public class Truck extends Automobile {
    // fields for the payload, towing capacity for the truck
    private int payload;
    private int towing_capacity;
    // boolean for the if the truck has four wheel drive
    private boolean four_wheel_drive = false;

    // constructor for Truck class
    public Truck() {
    }

    // reaches into constructor from autombile class to use in this class
    public Truck(int number_of_wheels, double height_in_inches, double weight_in_pounds) {
        super(number_of_wheels, height_in_inches, weight_in_pounds);
    }

// getters and setters for Truck class
    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public int getTowing_capacity() {
        return towing_capacity;
    }

    public void setTowing_capacity(int towing_capacity) {
        this.towing_capacity = towing_capacity;
    }

    public boolean isFour_wheel_drive() {
        return four_wheel_drive;
    }

    public void setFour_wheel_drive(boolean four_wheel_drive) {
        this.four_wheel_drive = four_wheel_drive;
    }

}
