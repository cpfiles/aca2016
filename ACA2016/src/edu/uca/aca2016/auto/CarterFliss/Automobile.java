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
    protected int WheelNum;
    protected int Height;
    protected int Weight;
    
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
    public void setWheelNum(int WheelNum) {
        this.WheelNum = WheelNum;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }
    
    //initializes Automobile w/ parameters
    public Automobile (int WheelNum, int Height, int Weight) {
        this.setHeight(Height);
        this.setWheelNum(WheelNum);
        this.setWeight(Weight);
    }
    
    //initializes Automobile w/o parameters
    public Automobile () {
    
    }
    
}
