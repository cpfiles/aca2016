/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.lokeee;

/**
 *
 * @author Bill Morgan
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Automobile Ford = new Automobile();
        Ford.setnumber_of_wheels(4);
        Ford.setheight_inches(45);
        Ford.setweight_lbs(3505);
        
      System.out.println(Ford.getnumber_of_wheels());
       System.out.println(Ford.getheight_inches());
        System.out.println(Ford.getweight_lbs());
        
       Truck monster = new Truck();
        monster.setpayload(2000);
        monster.settowing(10000);
	monster.setfourwd();
		System.out.println("The monster truck has a payload of: " +getpayload());
		System.out.println("The monster truck has a towing capacity of: " +gettowing());
		System.out.println("is the monster truck four wheel drive? " +monster.setfourwd));
}
}