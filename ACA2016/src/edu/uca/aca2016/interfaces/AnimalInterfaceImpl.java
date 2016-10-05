/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.interfaces;

/**
 *
 * @author cfiles
 */
public class AnimalInterfaceImpl implements AnimalInterface {
    private String type = "Elephant";
    
    @Override
    public void eat(){
        System.out.println("The " + this.type + " is eating.");
    }

    @Override
    public void travel(){
        System.out.println("The " + this.type + " is traveling.");
    }
    
    public boolean isAsleep() {
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        AnimalInterfaceImpl aii = new AnimalInterfaceImpl();
        aii.eat();
        aii.travel();
        System.out.println("Is the animal asleep? " + aii.isAsleep());
        System.out.println("Travel speed in MPH: " + AnimalInterface.travelSpeedInMPH(10, 1));
    }
    
}
