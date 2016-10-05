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
    protected int Payload;
    protected int TowCap;
    protected boolean FourWheel;
    
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

    public void setPayload(int Payload) {
        this.Payload = Payload;
    }

    public void setTowCap(int TowCap) {
        this.TowCap = TowCap;
    }

    public void setFourWheel(boolean FourWheel) {
        this.FourWheel = FourWheel;
    }
    
    //initializes Truck w/ parameters
    public Truck (int Payload, int TowCap, boolean FourWheel) {
        this.setWheelNum(WheelNum);
        this.setHeight(Height);
        this.setWeight(Weight);
        this.setPayload(Payload);
        this.setTowCap(TowCap);
        this.isFourWheel();
        
    }
    
    //initializes Truck w/o parameters
    public Truck () {
        
    }
    
}
