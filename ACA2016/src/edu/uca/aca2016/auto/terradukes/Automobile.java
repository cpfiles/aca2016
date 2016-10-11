/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.terradukes;

/**Inheritance
Author: Terra D Dukes, duetea@gmail.com
Week 3 - Tuesday, October 4, 2016
 * @author DueTe
 */
//Build two classes and a runner class.
// The first is a parent class named Automibole
//Two class constructors
public class Automobile {

    public Automobile(int numberOfWheels, int height, int weight) {
        this.numberOfWheels = numberOfWheels;
        this.height = height;
        this.weight = weight;
    }
       public Automobile() {
    }
    
           
    private int numberOfWheels;
   
    //in inches
    
    private int height;
    
    //US weight in pounds
    
    private int weight; 

    //Get methods
    
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
        
    }
    //Set methods

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
    
    
    
    

    