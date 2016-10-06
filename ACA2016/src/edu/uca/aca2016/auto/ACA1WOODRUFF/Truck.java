/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.ACA1WOODRUFF;

/**
 *
 * @author awood
 */
public class Truck extends Automobile{
    private double payload;
    private double towing_capacity;
    private boolean four_wheel_drive = true;

    public Truck(double payload, double towing_capacity, int number_of_wheels, double height, double weight) {
        super(number_of_wheels, height, weight);
        this.payload = payload;
        this.towing_capacity = towing_capacity;
    }

    public Truck(double payload, double towing_capacity) {
        this.payload = payload;
        this.towing_capacity = towing_capacity;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    public double getTowing_capacity() {
        return towing_capacity;
    }

    public void setTowing_capacity(double towing_capacity) {
        this.towing_capacity = towing_capacity;
    }

    public boolean isFour_wheel_drive() {
        return four_wheel_drive;
    }

    public void setFour_wheel_drive(boolean four_wheel_drive) {
        this.four_wheel_drive = four_wheel_drive;
    }
    
    
    
}
