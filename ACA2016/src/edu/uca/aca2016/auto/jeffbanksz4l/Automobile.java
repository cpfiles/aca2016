/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.jeffbanksz4l;

/**
 * Setting up the Automobile class.
 * @author jeffb
 */
public class Automobile {

    private int number_of_wheels;
    private double height_in_inches;
    private double weight_in_pounds;

    /**
     * Initializing the Automobile class.
     * @param number_of_wheels
     * @param height_in_inches
     * @param weight_in_pounds
     */
    public Automobile(int number_of_wheels, double height_in_inches, double weight_in_pounds) {
        this.number_of_wheels = number_of_wheels;
        this.height_in_inches = height_in_inches;
        this.weight_in_pounds = weight_in_pounds;
    }

    /**
     * Initializing the Automobile class.
     */
    public Automobile() {
    }

    /**
     * Returning the value for the Number of Wheels.
     * @return
     */
    public int getNumber_of_wheels() {
        return number_of_wheels;
    }

    /**
     * Setting the value for the Number of Wheels.
     * @param number_of_wheels
     */
    public void setNumber_of_wheels(int number_of_wheels) {
        this.number_of_wheels = number_of_wheels;
    }

    /**
     * Returning the value for the Height in inches.
     * @return
     */
    public double getHeight_in_inches() {
        return height_in_inches;
    }

    /**
     * Setting the value for the Height in inches.
     * @param height_in_inches
     */
    public void setHeight_in_inches(double height_in_inches) {
        this.height_in_inches = height_in_inches;
    }

    /**
     * Returning the value for the Weight in pounds.
     * @return
     */
    public double getWeight_in_pounds() {
        return weight_in_pounds;
    }

    /**
     * Setting the value for the Weight in pounds.
     * @param weight_in_pounds
     */
    public void setWeight_in_pounds(double weight_in_pounds) {
        this.weight_in_pounds = weight_in_pounds;
    }
}
