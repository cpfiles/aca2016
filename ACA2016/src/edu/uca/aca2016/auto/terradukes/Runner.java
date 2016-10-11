/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.terradukes;

/**
 * * @author DueTe
 */

public class Runner {

	public static void main(String[] args) {
		Automobile volvoS90 = new Automobile();
		volvoS90.setNumberOfWheels(4);
		volvoS90.setHeight(56);
		volvoS90.setWeight(4222);

		System.out.println("VolvoS90 has "+ volvoS90.getNumberOfWheels()+" number of wheels" );
		System.out.println("VolvoS90 is "+volvoS90.getHeight()+" inches in height" );
		System.out.println("VolvoS90 weighs "+volvoS90.getWeight()+" pounds");

		Truck volvoXC90 = new Truck();
		volvoXC90.setPayload(6100);
		volvoXC90.setTowingCapacity(4000);
		volvoXC90.setFourWheelDrive(false);

		System.out.println("VolvoXC90 has a payload of " + volvoXC90.getPayload());
		System.out.println("VolvoXC90 has a TowingCapacity of " + volvoXC90.getTowingCapacity());
		if (volvoXC90.hasFourWheelDrive()) {
			System.out.println("VolvoXC90 has four wheel drive support");
		}else{
			System.out.println("VolvoXC90 does NOT have four wheel drive support");
		}
		

	}

}
