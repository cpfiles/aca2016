package edu.uca.aca2016.auto.sethdumas; 

//The Truck class must extend the Automobile class.
public class Truck extends Automobile{
    
    /* Create the following fields: Payload, Towing Capacity, and Whether or 
    *not it is four wheel drive
    */
    private int Payload;
    private int TowingCapacity;
    private boolean FourWheelDrive = true;

    //needs the same constructors as Automobile class. It should 
    //use the parent class’ constructors during initialization.

    public Truck(int NumberOfWheels, int HeightInInches, int WeightInPounds) {
        super(NumberOfWheels, HeightInInches, WeightInPounds);
    }
    //get and set methods for each class
    
    public Truck (int Payload, int TowingCapacity, boolean FourWheelDrive){
    this.Payload = Payload;
    this.TowingCapacity = TowingCapacity;
    this.FourWheelDrive = FourWheelDrive;
    }

    public Truck() {
        
    }
  
    public int getPayload() {
        return Payload;
    }

    public void setPayload(int Payload) {
        this.Payload = Payload;
    }

    public int getTowingCapacity() {
        return TowingCapacity;
    }

    public void setTowingCapacity(int TowingCapacity) {
        this.TowingCapacity = TowingCapacity;
    }

    public boolean isFourWheelDrive() {
        return FourWheelDrive;
    }

    public void setFourWheelDrive(boolean FourWheelDrive) {
        this.FourWheelDrive = FourWheelDrive;
    }
}
