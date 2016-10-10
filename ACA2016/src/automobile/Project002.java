/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobile;

/**
 *
 * @author Chris
 */
public class Project002 {

    /**
     * @param args the command line 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Automobile car = new Automobile ("4", "60 inches", "2605"); 
        
        System.out.println (car.getHeight());
        System.out.println (car.getNumberofwheels());
        System.out.println (car.getWeight());
        
        Truck truck = new Truck (1740, 5500, true);
        
        System.out.println (truck.getPayload()); 
        System.out.println (truck.getTowingcapacity());
        System.out.println (truck.isFourwheeldrive()); 
        
        
        
                



    }
    
}
