/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.auto.calhoun512;

/**
 *
 * @author calho
 */
public class MoreClasses {
    
    private int x = 0;
    private int y = 0;

    static final double PI = 3.141592653589793;

    private static final String FOO = "bar";

    public enum Day{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    // set the x and y fields at the class level
    public void setPoint(int a,int b){
        x = a;
        y = b;

        System.out.println("x = " + this.x + " y = " + this.y);
    }

    public void setPoint2(int x,int y){
        // these are the local x and y
        System.out.println("x = " + x + " y = " + y);

        // these are the class x and y
        System.out.println("x = " + this.x + " y = " + this.y);

        // set the class level x and y
        this.x = x;
        this.y = y;

        // print the class level x and y
        System.out.println("x = " + this.x + " y = " + this.y);
    }

    private int addValues(){
        return this.x + this.y;
    }

    protected int subtractValues(){
        return this.x - this.y;
    }

    public static String getFoo(){
        return MoreClasses.FOO;
    }
    
    public static int multiply(int v1, int v2) {
        return v1 * v2;
    }

    public void tellItLikeItIs(Day day){
        switch(day){
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

}

