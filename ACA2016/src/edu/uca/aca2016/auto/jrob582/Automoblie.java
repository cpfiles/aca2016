/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.jrob582;

/**
 * Setting up Automobile class.
 * @author johna
 */
public class Automoblie {
    
    private int num_of_wheels;
    private double height;
    private double weight;

    /**
     * Initializing the Automobile class.
     * @param num_of_wheels
     * @param height
     * @param weight
     */
    public Automoblie(int num_of_wheels, double height, double weight) {
        this.num_of_wheels = num_of_wheels;
        this.height = height;
        this.weight = weight;
    }
    
    /**
     * Initializing the Automobile class.
     */
    public Automoblie() {

       
       


    }

    /**
     * Returning the Num_of_wheels
     * @return
     */
    public int getNum_of_wheels() {
        return num_of_wheels;
    }

    /**
     * Setting the values Num_of_wheels
     * @param num_of_wheels
     */
    public void setNum_of_wheels(int num_of_wheels) {
        this.num_of_wheels = num_of_wheels;
    }

    /**
     * Returning the Height values.
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setting the Height values.
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Getting the Weight values.
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setting the Weight values.
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    
}

    

