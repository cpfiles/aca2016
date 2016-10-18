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
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args, Automobile Automobile) {
      Automobile = new Automobile();
       
       Automobile.setNumber_of_wheels(4);
       Automobile.setheight_in(175);
       Automobile.setweight_inUSlbs(2800);
       
       Truck Subaru = new Truck();
       
       Subaru.setPayload(250);
       Subaru.setTowingCapacity(3000);
       Subaru.setFourWheelDrive(true);
       
       System.out.println("Number of wheels");
       System.out.println("height_in");
       System.out.println("weight_inUSlbs");
       System.out.println("Payload"+Subaru.getPayload());
       System.out.println("TowingCapacity"+Subaru.getTowingCapacity());
       System.out.println("FourWheelDrive"+Subaru.isFourWheelDrive());
       
       
       
  
       
       
       
                
   }  
}
