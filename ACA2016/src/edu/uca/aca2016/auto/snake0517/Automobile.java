/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.snake0517;

/**
 *
 * @author brela
 */
public class Automobile {
    
    private int number_of_wheels;
    private double height_in_inches;
    private double weight_in_pounds;

    public int getNumber_of_wheels() {
        return number_of_wheels;
    }

    public void setNumber_of_wheels(int number_of_wheels) {
        this.number_of_wheels = number_of_wheels;
    }

    public double getHeight_in_inches() {
        return height_in_inches;
    }

    public void setHeight_in_inches(double height_in_inches) {
        this.height_in_inches = height_in_inches;
    }

    public double getWeight_in_pounds() {
        return weight_in_pounds;
    }

    public void setWeight_in_pounds(double weight_in_pounds) {
        this.weight_in_pounds = weight_in_pounds;
    }

    public Automobile(int number_of_wheels, double height_in_inches, double weight_in_pounds) {
        this.number_of_wheels = number_of_wheels;
        this.height_in_inches = height_in_inches;
        this.weight_in_pounds = weight_in_pounds;
    }
    
    public Automobile(){
       
    }
    
}
