/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.lokeee;

/**
 *
 * @author lokeee
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // setting Ford as the Automobile and declaring the values 
        
        Automobile Ford = new Automobile();
        Ford.setnumber_of_wheels(4);
        Ford.setheight_inches(45);
        Ford.setweight_lbs(3505);
       // printout to screen  
      System.out.println("The Ford has " +Ford.getnumber_of_wheels()+" wheels.");
       System.out.println("The Ford is " +Ford.getheight_inches() +" inches high.");
        System.out.println("The Ford weighs " +Ford.getweight_lbs() +" pounds.");
        // Setting truck to monster, declaring the values
       Truck monster = new Truck();
        monster.setpayload(2000);
        monster.settowing(10000);
	monster.setfourwd(true);
       // printout to the screen
		System.out.println("The monster truck has a payload of: " +monster.getpayload());
		System.out.println("The monster truck has a towing capacity of: " +monster.gettowing());
		System.out.println("Is the monster truck four wheel drive? " +monster.getfourwd());
}
}