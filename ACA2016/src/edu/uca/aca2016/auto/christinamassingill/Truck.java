/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.christinamassingill;

/**
 *
 * @author Chris
 */
public class Truck extends Automobile {
 
private int payload; 
private int towingcapacity;
private boolean fourwheeldrive;

public Truck (int payload, int towingcapacity, boolean fourwheeldrive)
{
this.fourwheeldrive = fourwheeldrive;
this.payload = payload; 
this.towingcapacity  = towingcapacity; 


}

public Truck ()
{
this (1740, 5500, true);




}

    /**
     * @return the payload
     */
    public int getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(int payload) {
        this.payload = payload;
    }

    /**
     * @return the towingcapacity
     */
    public int getTowingcapacity() {
        return towingcapacity;
    }

    /**
     * @param towingcapacity the towingcapacity to set
     */
    public void setTowingcapacity(int towingcapacity) {
        this.towingcapacity = towingcapacity;
    }

    /**
     * @return the fourwheeldrive
     */
    public boolean isFourwheeldrive() {
        return fourwheeldrive;
    }

    /**
     * @param fourwheeldrive the fourwheeldrive to set
     */
    public void setFourwheeldrive(boolean fourwheeldrive) {
        this.fourwheeldrive = fourwheeldrive;
    }
}
