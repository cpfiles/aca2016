/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.shanamusiq;

/**
 *
 * @author Shana Super Class
 */
public class Automobile {

    public int NumberOfWheels;
    public int Height;
    public int Weight;
//Automobile attributes and dimensions

    public Automobile(int NumberOfWheels, int Height, int Weight) {
        this.NumberOfWheels = NumberOfWheels;
        this.Height = Height;
        this.Weight = Weight;
    }

    public Automobile() {

    }
//Getters and Setters for Automobile

    public int getNumberOfWheels() {
        return NumberOfWheels;
    }

    public void setNumberOfWheels(int NumberOfWheels) {
        this.NumberOfWheels = NumberOfWheels;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }
}

