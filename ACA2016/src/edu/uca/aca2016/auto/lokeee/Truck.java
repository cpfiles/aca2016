/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.lokeee;

/**
 *
 * @author lokeee
 */
public class Truck extends Automobile {
    /* truck payload, towing capacity and if it is four wheel drive.
	@param payload
	@param towing
	@param fourwd
	@param number_of_wheels
	@param height_inches
	@param weight_lbs
*/
    private int payload;
    private int towing;
    private boolean fourwd = false;
// Truck constructor
    public Truck(int number_of_wheels, double height_inches, double weight_lbs, int payload, int towing) {
        super(number_of_wheels, height_inches, weight_lbs);
        this.payload = payload;
        this.towing = towing;
    }

    //empty Truck constructor
 public Truck (){
}

	// set the payload
    public void setpayload (int payload){
        this.payload=payload;  
    }
    
	//return payload
      public int getpayload(){
        return this.payload;
    }
    
	// set towing capacity
    public void settowing (int towing){
        this.towing=towing;
    }
    
	// return towing capacity
       public int gettowing(){
        return this.towing;
    }
    
	// set if it is four wheel drive
    public void setfourwd (boolean fourwd){
        this.fourwd=fourwd;
    }
    
// return four wheel drive
    public boolean getfourwd(){
        return this.fourwd;
    }
  
 
}   
