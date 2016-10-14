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
public class Automobile {
    /* setting number of wheels, height in inches and weight in pounds
    @param number_of_wheels
    @param height_inches
    @param weight_lbs
    */
    private int number_of_wheels;
    private double  height_inches;
    private double weight_lbs;
 
// Automobile constructor
public Automobile (int number_of_wheels, double height_inches, double weight_lbs){
    this.number_of_wheels = number_of_wheels;
    this.height_inches = height_inches;
    this.weight_lbs = weight_lbs;
}
// empty constructor for Automobile
public Automobile(){       
}

// set the number of wheels
public void setnumber_of_wheels (int number_of_wheels){
    this.number_of_wheels = number_of_wheels;
}

// return the number of wheelss
public int getnumber_of_wheels(){
    return this.number_of_wheels;
}

//set height in inches
public void setheight_inches (double height_inches){
    this.height_inches = height_inches;
}

//return height in inches
public double getheight_inches(){
    return this.height_inches;
}

//set weight in pounds
public void setweight_lbs (double weight_lbs) {
    this.weight_lbs = weight_lbs;
}


// return weight in pounds
public double getweight_lbs(){
    return this.weight_lbs;
}
    

}
