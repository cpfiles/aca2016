/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.CarterFliss;

/**
 *
 * @author Carter
 */
public class Automobile  {
    //defines fields for Automobile class
    private int WheelNum;
    private int Height;
    private int Weight;
    
    //gets the fields we need for Automobile
    public int getWheelNum() {
        return WheelNum;
    }

    public int getHeight() {
        return Height;
    }

    public int getWeight() {
        return Weight;
    }
    
    //sets Automobile fields
    public void setWheelNum(int value) {
        this.WheelNum = value;
    }

    public void setHeight(int value) {
        this.Height = value;
    }

    public void setWeight(int value) {
        this.Weight = value;
    }
    
    //initializes Automobile w/ parameters
    public Automobile (int valWheel, int valHeight, int valWeight) {
        this.setHeight(valHeight);
        this.setWheelNum(valWheel);
        this.setWeight(valWeight);
    }
    
    //initializes Automobile w/o parameters
    public Automobile () {
    
    }
    
}
