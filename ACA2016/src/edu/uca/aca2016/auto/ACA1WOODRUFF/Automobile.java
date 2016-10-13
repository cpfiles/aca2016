/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.ACA1WOODRUFF;

/**
 *
 * @author awood
 */
public class Automobile {
 
    private int number_of_wheels;
    private double height;
    private double weight;

    /**
     *
     * @param number_of_wheels
     * @param height
     * @param weight
     */
    public Automobile(int number_of_wheels, double height, double weight) {
        this.number_of_wheels = number_of_wheels;
        this.height = height;
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public int getNumber_of_wheels() {
        return number_of_wheels;
    }

    /**
     *
     * @param number_of_wheels
     */
    public void setNumber_of_wheels(int number_of_wheels) {
        this.number_of_wheels = number_of_wheels;
    }

    /**
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }   
    public Automobile(){
    }

  }
