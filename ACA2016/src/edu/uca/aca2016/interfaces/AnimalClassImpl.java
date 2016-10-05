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
public class AnimalClassImpl extends AnimalAbstract {
    private String type = "Giraffe";

    @Override
    void eat(){
        System.out.println("The " + this.type + " is eating.");
    }

    @Override
    void travel(){
        System.out.println("The " + this.type + " is traveling.");
    }
    
    public boolean isAsleep(){
        System.out.println("The animal is a " + this.type);
        return super.isAsleep();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        AnimalClassImpl aii = new AnimalClassImpl();
        aii.eat();
        aii.travel();
        System.out.println("Is the animal asleep? " + aii.isAsleep());
        System.out.println("Travel speed in MPH: " + AnimalAbstract.travelSpeedInMPH(12, 2));
    }
    
}
