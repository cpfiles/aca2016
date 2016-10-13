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
public class Automobile {
    //define variables number of wheels, height (inches), weight (pounds)
    private int number_of_wheels;
    private int _height; //(inches)
    private int _weight; //(pounds)

    //initialize the objects
    public Automobile (int Nwheels, int height, int weight){
    this.number_of_wheels = Nwheels;
    this._height = height;
    this._weight = weight;
    
    }
    //initialize with no parameters
    public Automobile (){
    number_of_wheels = 0;
    _height = 0;
    _weight = 0;
    }

    //creating getters for objects
    public int getNwheels(){
        return number_of_wheels;
    }
    //creating getters for ojects
    public int getHeight(){
            return _height;
    }
    //creating getters for objects
    public int getWeight(){
                return _weight;
            }
    
    //creating setters for objects
    public void setNwheels (int Nwheels){
        number_of_wheels = Nwheels;
    }
    //creating setters for objects    
    public void setHeight (int height){
        _height = height;
    }
    //creating setters for objects
    public void setWeight (int weight){
       _weight = weight;
    }
    
    //ovverid string to printout Automobile class
        @Override
    public String toString(){
        System.out.println("This is a AUTOMOBILE");
        return "Number of Wheels: " + getNwheels()
                + "\nHeight: " + getHeight()
                + "\nWeight: " + getWeight();
    }
} 