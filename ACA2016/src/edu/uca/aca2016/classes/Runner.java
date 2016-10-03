package edu.uca.aca2016.classes;

public class Runner{

    public static void main(String[] args){
        MoreClasses obj = new MoreClasses();
        obj.setPoint(4,5);
        obj.setPoint2(7,8);

        //obj.addValues();
        int x = obj.subtractValues();
        System.out.println("Values after subtraction: " + x);

        // static method calling
        String r = MoreClasses.getFoo();
        System.out.println("Return from static method: " + r);
        System.out.println("The value of PI is: " + MoreClasses.PI);

        obj.tellItLikeItIs(MoreClasses.Day.MONDAY);
        obj.tellItLikeItIs(MoreClasses.Day.WEDNESDAY);
        obj.tellItLikeItIs(MoreClasses.Day.FRIDAY);
        obj.tellItLikeItIs(MoreClasses.Day.SATURDAY);
    }

}
