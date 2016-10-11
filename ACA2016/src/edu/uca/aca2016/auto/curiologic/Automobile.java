/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.curiologic;

/**
 *
 * @author xulix
 */
public class Automobile {

    // fields for wheels, height, and weight for Automobile
    private int number_of_wheels;
    private double height_in_inches;
    private double weight_in_pounds;

    public Automobile(int number_of_wheels, double height_in_inches, double weight_in_pounds) {

    }

    public Automobile() {

    }

    // getters and setters for the defined fields for the Autombile
    public void setNumberOfWheels(int value) {
        this.number_of_wheels = value;
    }

    public void setHeightInInches(double value) {
        this.height_in_inches = value;
    }

    public void setWeightInPounds(double value) {
        this.weight_in_pounds = value;

    }

    public int getNumberOfWheels() {
        return number_of_wheels;
    }

    public double getHeightInInches() {
        return height_in_inches;
    }

    public double getWeightInPounds() {
        return weight_in_pounds;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
