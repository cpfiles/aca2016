package edu.uca.aca2016.interfaces;

abstract class AnimalAbstract{
    private boolean drinking = false;

    abstract void eat();

    abstract void travel();

    public boolean isAsleep(){
        return false;
    }
    
    public static double travelSpeedInMPH(double miles, double time) {
        if (time <= 0) {
            return 0;
        }
        
        double r = miles / time;
        
        return r;
    }
}
