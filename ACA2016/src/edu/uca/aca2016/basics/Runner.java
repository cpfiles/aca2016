package edu.uca.aca2016.basics;

/**
 * A runner class for the basic lessons in the ACA project
 * @author cfiles
 */
public class Runner{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Person steve = new Person();
        
        // set the person's name
            steve.setFirstName("Steve");
        steve.setMiddleInitial('R');
        steve.setLastName("Smith");

        // set the person's age, weight and income
        steve.setAgeInDays(28754);
        steve.setWeight(165.5f);
        steve.setIncome(45000.65);
        
        // create and set steve's parents
        Person betty = new Person();
        betty.setFirstName("Betty");
        betty.setLastName("Smith");
        
        Person john = new Person();
        john.setFirstName("John");
        john.setLastName("Smith");
        
        steve.setParents(betty, john);
        
        // print steve's profile
        System.out.println("Profile of " + steve.getFullName() + ":");
        System.out.println("\tAge: " + steve.getAgeInYears());
        System.out.println("\tWeight: " + steve.getWeight() + " lbs.");
        System.out.println("\tIncome: $" + steve.getIncome());
        System.out.println("\tMother: " + steve.getMother().getFullName());
        System.out.println("\tFather: " + steve.getFather().getFullName());
    }
    
}
