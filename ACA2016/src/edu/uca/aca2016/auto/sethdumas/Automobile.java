/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.sethdumas;


 
 //Create a class and give it the following fields: 
//number of wheels, height (inches), weight (pounds).
public class Automobile {
    private int NumberOfWheels;
    private int HeightInInches;
    private int WeightInPounds;
    

/* There need to be two class constructors. One that allows all fields to be
 * set when an object of this type is created. The second needs to simply 
 * initialize the object with no parameters. 
 */
public Automobile (int NumberOfWheels, int HeightInInches, int 
        WeightInPounds){
    this.NumberOfWheels = NumberOfWheels;
    this.HeightInInches = HeightInInches;
    this.WeightInPounds = WeightInPounds;
}            
public Automobile (){
}       

    public int getHeightInInches() {
        return HeightInInches;
    }

    public void setHeightInInches(int HeightInInches) {
        this.HeightInInches = HeightInInches;
    }

    public int getNumberOfWheels() {
        return NumberOfWheels;
    }

    public void setNumberOfWheels(int NumberOfWheels) {
        this.NumberOfWheels = NumberOfWheels;
    }

    public int getWeightInPounds() {
        return WeightInPounds;
    }

    public void setWeightInPounds(int WeightInPounds) {
        this.WeightInPounds = WeightInPounds;
    }
}
