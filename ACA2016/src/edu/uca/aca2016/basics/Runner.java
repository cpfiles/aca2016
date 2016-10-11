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
        
        System.out.println("Profile of " + steve.getFullName() + ":");
        
        Student martha = new Student();
        martha.setFirstName("Martha");
        martha.setLastName("Smith");
        System.out.println("Profile of " + martha.getFullName() + ":");
        
        // print steve's profile
        /*
        System.out.println("Profile of " + steve.getFullName() + ":");
        System.out.println("\tAge: " + steve.getAgeInYears());
        System.out.println("\tWeight: " + steve.getWeight() + " lbs.");
        System.out.println("\tIncome: $" + steve.getIncome());
        System.out.println("\tMother: " + steve.getMother().getFullName());
        System.out.println("\tFather: " + steve.getFather().getFullName());
        
        Student bob = new Student("Bob", "Smith");
        System.out.println("Profile of " + bob.getFullName() + ":");
        
        // Primitave data types are passed by value. Any changes to the values of the parameters 
        // exist only within the scope of the method
        double gpa = 4.0;
        bob.gpa(gpa);
        System.out.println("\tGPA: " + gpa);
        
        // Objects, are also passed into methods by value. This means that when the method returns, the 
        // passed-in reference still references the same object as before. However, the values of the 
        // object's fields can be changed in the method, if they have the proper access level.
        bob.firstTeacher(betty);
        System.out.println("\tFirst Teacher: " + betty.getFullName());
        */
    }
    
}
