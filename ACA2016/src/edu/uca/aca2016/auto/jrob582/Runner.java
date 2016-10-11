/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.jrob582;

/**
 * Setting up 
 * @author johna
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Automoblie my_Truck = new Automoblie();
        
        my_Truck.setNum_of_wheels(4);
        my_Truck.setHeight(64);
        my_Truck.setWeight(8000);
        
        System.out.println("Num_of_wheels " +  my_Truck.getNum_of_wheels());
        System.out.println("Height " +  my_Truck.getHeight());
        System.out.println("Weight " +  my_Truck.getWeight());
        
        
        Truck my_Chevy = new Truck();
        
        my_Chevy.setPayload(20000);
        my_Chevy.setTowing_capacity(14000);
        my_Chevy.setFour_wheel_drive(true);
        
        System.out.println("Payload " + my_Chevy.getPayload());
        System.out.println("Towing_Capacity " + my_Chevy.getTowing_capacity());
        System.out.println("Four_wheel_drive " + my_Chevy.isFour_wheel_drive());
        
        
     
        
    }
    
}
