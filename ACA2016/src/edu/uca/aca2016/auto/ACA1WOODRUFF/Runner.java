/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.ACA1WOODRUFF;

//import edu.uca.aca2016.basics.Person;

/**
 *
 * @author awood
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automobile corvette = new Automobile();
        // TODO code application logic here
        corvette.setNumber_of_wheels(4);
        corvette.setHeight(48);
        corvette.setWeight(2800);

     System.out.println("The profile of 2002 Corvette Coup has" + corvette.getNumber_of_wheels());
     System.out.println("at a height of" + corvette.getHeight ());
     System.out.println("coming in at a weight of" + corvette.getWeight() + "lbs.");

     Truck silverado = new Truck();
        // TODO code application logic here
        silverado.setNumber_of_wheels(4);
        silverado.setHeight(48);
        silverado.setWeight(2800);

     System.out.println("The profile of 2002 Corvette Coup has" + corvette.getNumber_of_wheels());
     System.out.println("at a height of" + corvette.getHeight ());
     System.out.println("coming in at a weight of" + corvette.getWeight() + "lbs.");
        
    }
    
}
