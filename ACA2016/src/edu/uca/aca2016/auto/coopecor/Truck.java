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

//payload (pounds of cargo the truck can carry), 
//towing capacity (pounds)
// four wheel drive (boolean).
public class Truck extends Automobile {
    private int payLoad;
    private int towingCapacity;
    private boolean fourWheel;
    
    //initializing my variables and adding parent class automobile
    public Truck (int numberOfWheels, int _height, int _weight, 
                  int payLoad, int towingCapacity, boolean fourWheel){
        super(numberOfWheels, _height, _weight);
        this.payLoad = payLoad;
        this.towingCapacity = towingCapacity;
        this.fourWheel = fourWheel;
    }

    //initializing my default method construct for Truck class
    public Truck (){
        super();        
        payLoad = 0;
        towingCapacity = 0;
        fourWheel = false;
    }
    
    //creating getters for variables
    public int getPayLoad (){
            return payLoad;
        }
    public int getTowingCapacity (){
            return towingCapacity;
    }
    public boolean getFourWheel(){
            return fourWheel;
    }
    
    //creating setters for variables
    public void setPayLoad(int payLoad){
        this.payLoad = payLoad;
    }
    //creating setters for variables
    public void setTowing(int towingCapacity){
        this.towingCapacity = towingCapacity;
    }
    
    public void setFourWheel( boolean fourWheel){
        this.fourWheel = fourWheel;
    }
    
    
    //override string to printout
    @Override
    public String toString(){
        System.out.println("\n\nThis is a TRUCK");
        return "Number of Wheels: " + super.getNwheels()
                + "\nHeight: " + super.getHeight()
                + "\nWeight: " + super.getWeight()
                + "\nPay Load: " + payLoad
                + "\nTowing Capacity: " +towingCapacity;
    }
}