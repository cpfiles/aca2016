package edu.uca.aca2016.interfaces;

public interface AnimalInterface{
    public void eat();

    public void travel();

    default boolean isAsleep(){
        return false;
    }

    public static double travelSpeedInMPH(double miles,double time){
        if(time <= 0){
            return 0;
        }

        double r = miles / time;

        return r;
    }
}
