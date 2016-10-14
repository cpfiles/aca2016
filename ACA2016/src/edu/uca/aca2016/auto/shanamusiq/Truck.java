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
public class Truck extends Automobile {

    private int Payload;
    private int TowCapacity;
    private boolean FourWheelDrive;
//Truck attributes and dimensions

    public Truck(int NumberOfWheels, int Height, int Weight, int Payload, int TowCapacity, boolean FourWheelDrive) {
        this.NumberOfWheels = NumberOfWheels;
        this.Height = Height;
        this.Weight = Weight;
        this.Payload = Payload;
        this.TowCapacity = TowCapacity;
        this.FourWheelDrive = FourWheelDrive;

    }

    public Truck() {
    }
//Getters and setters for Truck

    public int getPayload() {
        return Payload;
    }

    public void setPayload(int Payload) {
        this.Payload = Payload;
    }

    public int getTowCapacity() {
        return TowCapacity;
    }

    public void setTowCapacity(int TowCapacity) {
        this.TowCapacity = TowCapacity;
    }

    public boolean isFourWheelDrive() {
        return FourWheelDrive;
    }

    public void setFourWheelDrive(boolean FourWheelDrive) {
        this.FourWheelDrive = FourWheelDrive;
    }

}
