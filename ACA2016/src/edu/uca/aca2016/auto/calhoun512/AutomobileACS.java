package edu.uca.aca2016.auto.calhoun512;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author calhoun512
 */
public class AutomobileACS {
    
    private int number_of_wheels;
    private double height;
    private double weight;
    
    public AutomobileACS (int number_of_wheels, double height, double weight){
        
        this.number_of_wheels = number_of_wheels;
        this.height = height;
        this.weight = weight;
        
    }
    
    public AutomobileACS (){
            
    }

        
    public void setNumber_of_wheels (int value){
        this.number_of_wheels = value;       
    }
    
    public int getNumberOfWheels (){
        return number_of_wheels;
    }
    
    public void setHeight (double height){
        this.height = height;
    }
    
    public double getHeight (){
        return height;
    }
    
    public void setWeight (double weight){
        this.weight = weight;
    }
            
    public double getWeight (){
        return height;
    }
}
