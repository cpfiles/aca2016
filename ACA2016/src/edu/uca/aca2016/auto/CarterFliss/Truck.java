/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.CarterFliss;

/**
 *
 * @author Carter
 */
public class Truck extends Automobile {
    //define fields for Truck class
    private int Payload;
    private int TowCap;
    private boolean FourWheel;
    
    //gets fields for Truck

    public int getPayload() {
        return Payload;
    }

    public int getTowCap() {
        return TowCap;
    }

    public boolean isFourWheel(boolean value) {
        return FourWheel;
    }
    
    public boolean isFourWheel() {
        return FourWheel;
    }
    
    //sets fields for Truck

    public void setPayload(int value) {
        this.Payload = value;
    }

    public void setTowCap(int value) {
        this.TowCap = value;
    }

    public void setFourWheel(boolean value) {
        this.FourWheel = value;
    }
    
    //initializes Truck w/ parameters
    public Truck (int valWheel, int valHeight, int valWeight, 
                  int valPayload, int valTowCap, boolean boolFourWheel) {
        this.setHeight(valHeight);
        this.setWheelNum(valWheel);
        this.setWeight(valWeight);
        this.setPayload(valPayload);
        this.setTowCap(valTowCap);
        this.setFourWheel(boolFourWheel);
        
    }
    
    //initializes Truck w/o parameters
    public Truck () {
        
    }
    
}
