/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.jrob582;

/**
 *
 * @author johna
 */
class Automoblie {
    
    private int num_of_wheels;
    private double height;
    private double weight;

    public Automoblie(int num_of_wheels, double height, double weight) {
        this.num_of_wheels = num_of_wheels;
        this.height = height;
        this.weight = weight;
    }
    
        public Automoblie() {

       
       


    }

    public int getNum_of_wheels() {
        return num_of_wheels;
    }

    public void setNum_of_wheels(int num_of_wheels) {
        this.num_of_wheels = num_of_wheels;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
}

    

