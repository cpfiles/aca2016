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
public class Automobile {
    // setting number of wheels, height in inches and weight in pounds
    private int number_of_wheels;
    private float height_inches;
    private float weight_lbs;
    
// sutomobile constructor
public Automobile (int wheels, float inches, float weight){
    this.number_of_wheels = wheels;
    this.height_inches = inches;
    this.weight_lbs = weight;
}
 
public void setAutomobile (int number_of_wheels, float height_inches, float weight_lbs, int wheels, float inches, float weight){
    this.number_of_wheels = wheels;
    this.height_inches = inches;
    this.weight_lbs = weight;
}



    

}
