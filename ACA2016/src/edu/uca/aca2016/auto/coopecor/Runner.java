/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.coopecor;

/**
 *
 * @author Cory's HP Pavilion
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // creating my main class for automobile
        //setting the values for Automobile objects, number of wheels, height, weight
        Automobile myTruck = new Automobile(4, 164, 19500);
        
        //printout for objects using the override string to function
        System.out.println(myTruck);
        

        //set payload, towing capacity, height, weight, number of wheels
        Truck ford = new Truck();
        ford.setHeight(164);
        ford.setNwheels(4);
        ford.setPayLoad(150);
        ford.setTowing(3500);
        ford.setWeight(19500);
        
        //priontout for oject values for ford truck using string to function
        System.out.println(ford);
    }
    
}