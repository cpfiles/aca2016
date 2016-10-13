/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.terradukes;

/**
 *
 * @author DueTe
 */

public class Truck extends Automobile {

    //super (height, weight)
	public Truck(int height, int weight, int NumberOfWheels) {
		
        }

	public Truck() {
	
	}
        //pounds of cargo the truck can carry
        
	private int payload;
        
        //tow capacity
        
	private int towingCapacity;

	// boolean
	private boolean fourWheelDrive;
        
	public void setPayload(int payload) {
		this.payload = payload;
	}

	public void setTowingCapacity(int towingCapacity) {
		this.towingCapacity = towingCapacity;
	}

	public void setFourWheelDrive(boolean fourWheelDrive) {
		this.fourWheelDrive = fourWheelDrive;

	}

	public int getPayload() {
		return payload;
	}

	public int getTowingCapacity() {
		return towingCapacity;
	}

	public boolean hasFourWheelDrive() {
		return fourWheelDrive;
	}

}




