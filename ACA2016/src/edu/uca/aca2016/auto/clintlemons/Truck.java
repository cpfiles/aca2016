/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.clintlemons;

/**
 *<<see animalabstract for concept>>
 * @author Username
 */
public class Truck extends Automobile {
     private int Payload;
        private int TowingCapacity;
        private boolean FourWheelDrive;
    //Constructor added using parent class
    public Truck(int Number_of_wheels, double height_in, float weight_inUSlbs) {
        super(Number_of_wheels, height_in, weight_inUSlbs);
        this.Payload = Payload;
        this.TowingCapacity = TowingCapacity;
        this.FourWheelDrive = FourWheelDrive;
    }

    Truck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //inserted getters and setters
    public int getPayload() {
        return Payload;
    }

    public void setPayload(int Payload) {
        this.Payload = Payload;
    }

    public int getTowingCapacity() {
        return TowingCapacity;
    }

    public void setTowingCapacity(int TowingCapacity) {
        this.TowingCapacity = TowingCapacity;
    }

    public boolean isFourWheelDrive() {
        return FourWheelDrive;
    }

    public void setFourWheelDrive(boolean FourWheelDrive) {
        this.FourWheelDrive = FourWheelDrive;
    }

    @Override
    public String toString(){
        System.out.println("Truck");
        return "Truck{" + "Payload=" + Payload + ", TowingCapacity=" + TowingCapacity + ", FourWheelDrive=" + FourWheelDrive + '}';
    }

}