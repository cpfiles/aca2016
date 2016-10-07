/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.jrob582;

/**
 * Setting up a Truck class
 * @author johna
 */

public class Truck extends Automoblie{ 
    
      private double payload;
      private double towing_capacity;
      private boolean four_wheel_drive = true;

    /**
     * Initializing the Truck class.
     * @param payload
     * @param towing_capacity
     * @param num_of_wheels
     * @param height
     * @param weight
     */
    public Truck(double payload, double towing_capacity, int num_of_wheels, double height, double weight) {
        super(num_of_wheels, height, weight);
        this.payload = payload;
        this.towing_capacity = towing_capacity;
    }

    /**
     *Initializing the Truck class.
     */
    public Truck() {

    }
    
    /**
     * Returning Payload values.
     * @return
     */
    public double getPayload() {
        return payload;
    }

    /**
     * Setting the Payload values.
     * @param payload
     */
    public void setPayload(double payload) {
        this.payload = payload;
    }

    /**
     * Returning Towing Capacity.
     * @return
     */
    public double getTowing_capacity() {
        return towing_capacity;
    }

    /**
     * Setting the Towing capacity values.
     * @param towing_capacity
     */
    public void setTowing_capacity(double towing_capacity) {
        this.towing_capacity = towing_capacity;
    }

    /**
     * Returning the Four wheel drive value.
     * @return
     */
    public boolean isFour_wheel_drive() {
        return four_wheel_drive;
    }

    /**
     * Setting the Four wheel drive values.
     * @param four_wheel_drive
     */
    public void setFour_wheel_drive(boolean four_wheel_drive) {
        this.four_wheel_drive = four_wheel_drive;
    }
      
      
      
      
      
      
      
      
    }
    





    

