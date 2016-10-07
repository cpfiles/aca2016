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
public class automobile {
    private int  number_of_wheels;
    private int height_in_inches;
    private int weight_in_pounds;
    private String wheels;
    
    
    public void setNumberOfWheels (int value) {
        this.number_of_wheels = value;
}
    public void setHeightInInches (int value) {
        this.height_in_inches = value;
    }
    public void setWeightInPounds (int value) {
        this.weight_in_pounds = value;
    
    }
    
    public int getNumberOfWheels() {
        return number_of_wheels;
    }
    
    public int getHeightInInches() {
        return height_in_inches;
    }

    public int getWeightInPounds() {
        return weight_in_pounds;
    }
    
    public automobile(int number_of_wheels, int height_in_inches, int weight_in_pounds) {
        
    
}
    automobile mytruck = new automobile( 4, 76, 2000);{}
    public automobile() {
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
