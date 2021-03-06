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
public class Truck extends Automobile {
     private double payload;
     private double towing_capacity;
     private boolean four_wheel_drive = true;

    /**
     *  Constructor for truck class
     * @param payload
     * @param towing_capacity
     * @param number_of_wheels
     * @param height_in_inches
     * @param weight_in_pounds
     */
    public Truck(double payload, double towing_capacity, int number_of_wheels, double height_in_inches, double weight_in_pounds) {
        super(number_of_wheels, height_in_inches, weight_in_pounds);
        this.payload = payload;
        this.towing_capacity = towing_capacity;
    }

    /**
     * empty constructor
     */
    public Truck() {
        
    }

    /**
     * Lets you access payload
     * @return
     */
    public double getPayload() {
        return payload;
    }

    /**
     * Sets payload value
     * @param payload
     */
    public void setPayload(double payload) {
        this.payload = payload;
    }

    /**
     * Lets you access towing capacity 
     * @return
     */
    public double getTowing_capacity() {
        return towing_capacity;
    }

    /**
     * Sets towing capacity
     * @param towing_capacity
     */
    public void setTowing_capacity(double towing_capacity) {
        this.towing_capacity = towing_capacity;
    }

    /**
     *
     * @return
     */
    public boolean isFour_wheel_drive() {
        return four_wheel_drive;
    }

    /**
     *
     * @param four_wheel_drive
     */
    public void setFour_wheel_drive(boolean four_wheel_drive) {
        this.four_wheel_drive = four_wheel_drive;
    }
     
    
     
     
    
}
