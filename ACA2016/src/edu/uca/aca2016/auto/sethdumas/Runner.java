package edu.uca.aca2016.auto.sethdumas;

/**
 *
 * @author sethd
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create an Automobile object and assign values for each field 
        Automobile Subaru = new Automobile();
        Subaru.setHeightInInches(66);
        Subaru.setNumberOfWheels(4);
        Subaru.setWeightInPounds(3296);
        // create a Truck object and assign values for each field
        Truck Ford = new Truck();
        Ford.setHeightInInches(78);
        Ford.setNumberOfWheels(6);
        Ford.setWeightInPounds(7260);
        Ford.setPayload(9900);
        Ford.setTowingCapacity(15000);
        Ford.setFourWheelDrive(true);
        
        //print all fields of each class to console
        System.out.println("2017 Subaru Forester Specifications");
        System.out.println("\tHeight: " + Subaru.getHeightInInches()
                + " inches");
        System.out.println("\tNumber of wheels: " + Subaru.getNumberOfWheels());
        System.out.println("\tWeight: " + Subaru.getWeightInPounds()
                + " pounds");
        System.out.println();
        System.out.println("2017 Ford F250 Super Duty Specifications");
        System.out.println("\tHeight: " + Ford.getHeightInInches()
                + " inches");
        System.out.println("\tNumber of wheels: " + Ford.getNumberOfWheels());
        System.out.println("\tWeight: " + Ford.getWeightInPounds()
                + " pounds");
        System.out.println("\tPayload: " + Ford.getPayload()
                + " pounds");
        System.out.println("\tTowing capacity: " + Ford.getTowingCapacity()
                + " pounds");
        if (Ford.isFourWheelDrive() == (false)) {
            System.out.println("\t4WD: No");
        } 
        if (Ford.isFourWheelDrive() == (true)) {
            System.out.println("\t4WD: Yes");
        }
    }
}