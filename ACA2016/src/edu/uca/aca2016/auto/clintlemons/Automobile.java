/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.clintlemons;

/**
 *
 * @author Username
 */
public class Automobile {
    public static int Number_of_wheels = 4;

    static void setheight_in(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void setweight_inUSlbs(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private double height_in;
    private float weight_inUSlbs;
    //initialize objects
    public Automobile(int Number_of_wheels, double height_in, float weight_inUSlbs) {
        this.Number_of_wheels = Number_of_wheels;
        this.height_in = height_in;
        this.weight_inUSlbs = weight_inUSlbs;
    }
    //insert getters and setters
    public static int getNumber_of_wheels() {
        return Number_of_wheels;
    }

    public static void setNumber_of_wheels(int Number_of_wheels) {
        Automobile.Number_of_wheels = Number_of_wheels;
    }

    Automobile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getHeight_in() {
        return height_in;
    }

    public void setHeight_in(double height_in) {
        this.height_in = height_in;
    }

    public float getWeight_inUSlbs() {
        return weight_inUSlbs;
    }

    public void setWeight_inUSlbs(float weight_inUSlbs) {
        this.weight_inUSlbs = weight_inUSlbs;
    }

    @Override
    public String toString() {
        System.out.print("Automobile");
        return "Automobile{" + "height_in=" + height_in + ", weight_inUSlbs=" + weight_inUSlbs + '}';
    }
    

    
}
