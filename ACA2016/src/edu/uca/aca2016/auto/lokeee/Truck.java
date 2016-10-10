/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.lokeee;

/**
 *
 * @author Bill Morgan
 */
public class Truck extends Automobile {
    // truck payload, towing capacity and if it is four wheel drive.
    private int payload;
    private int towing;
    private boolean fourwd = false;

    public Truck(int number_of_wheels, double height_inches, double weight_lbs, int payload, int towing) {
        super(number_of_wheels, height_inches, weight_lbs);
        this.payload = payload;
        this.towing = towing;
    }

    
    public void setpayload (int payload){
        this.payload=payload;  
    }
    
      public int getpayload(){
        return this.payload;
    }
    
    public void settowing (int towing){
        this.towing=towing;
    }
    
       public int gettowing(){
        return this.towing;
    }
    
    public void setfourwd (boolean fourwd){
        this.fourwd=fourwd;
    }
    
    public boolean getfourwd(){
        return this.fourwd;
    }
  
 
}   
