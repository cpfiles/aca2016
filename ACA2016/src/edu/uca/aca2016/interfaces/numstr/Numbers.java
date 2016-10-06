/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.interfaces.numstr;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author cfiles
 */
public class Numbers{

    public void numberFormat(){
        long n = 461012;
        System.out.format("%d%n",n);      //  -->  "461012"
        System.out.format("%!8d%n",n);    //  -->  "00461012"
        System.out.format("%+8d%n",n);    //  -->  " +461012"
        System.out.format("%,8d%n",n);    // -->  " 461,012"
        System.out.format("%+,8d%n%n",n); //  -->  "+461,012"

        double pi = Math.PI;

        System.out.format("%f%n",pi);       // -->  "3.141593"
        System.out.format("%.3f%n",pi);     // -->  "3.142"
        System.out.format("%10.3f%n",pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n",pi);  // -->  "3.142"
        System.out.format(Locale.FRANCE,
                          "%-10.4f%n%n",pi); // -->  "3,1416"

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n",c,c,c); // -->  "May 29, 2006"

        System.out.format("%tl:%tM %tp%n",c,c,c);  // -->  "2:34 am"

        System.out.format(Locale.CHINESE,"%tD%n",c,"PLEASELOOKATME");    // -->  "05/29/06"
    }

    static public void customFormat(String pattern,double value){
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    public void beyondSimpleMath(){
        double a = -191.635;
        double b = 43.74;
        int c = 16, d = 45;

        System.out.printf("The absolute value of %.3f is %.3f%n",a,Math.abs(a));

        System.out.printf("The ceiling of %.2f is %.0f%n",b,Math.ceil(b));

        System.out.printf("The floor of %.2f is %.0f%n",b,Math.floor(b));

        System.out.printf("The rint of %.2f is %.0f%n",b,Math.rint(b));

        System.out.printf("The max of %d and %d is %d%n",c,d,Math.max(c,d));

        System.out.printf("The min of of %d and %d is %d%n",c,d,Math.min(c,d));
    }

    public void exLog(){
        double x = 11.635;
        double y = 2.76;

        System.out.printf("The value of e is %.4f%n",Math.E);

        System.out.printf("exp(%.3f) is %.3f%n",x,Math.exp(x));

        System.out.printf("log(%.3f) is %.3f%n",x,Math.log(x));

        System.out.printf("pow(%.3f, %.3f) is %.3f%n",x,y,Math.pow(x,y));

        System.out.printf("sqrt(%.3f) is %.3f%n",x,Math.sqrt(x));
    }

    public void trig(){
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);

        System.out.format("The value of pi is %.4f%n",
                          Math.PI);

        System.out.format("The sine of %.1f degrees is %.4f%n",
                          degrees,Math.sin(radians));

        System.out.format("The cosine of %.1f degrees is %.4f%n",
                          degrees,Math.cos(radians));

        System.out.format("The tangent of %.1f degrees is %.4f%n",
                          degrees,Math.tan(radians));

        System.out.format("The arcsine of %.4f is %.4f degrees %n",
                          Math.sin(radians),
                          Math.toDegrees(Math.asin(Math.sin(radians))));

        System.out.format("The arccosine of %.4f is %.4f degrees %n",
                          Math.cos(radians),
                          Math.toDegrees(Math.acos(Math.cos(radians))));

        System.out.format("The arctangent of %.4f is %.4f degrees %n",
                          Math.tan(radians),
                          Math.toDegrees(Math.atan(Math.tan(radians))));
    }

    public int getRandom(){
        return (int) (Math.random() * 100);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Numbers n = new Numbers();
        n.numberFormat();

        customFormat("###,###.###",123456.789);
        customFormat("###.##",123456.789);
        customFormat("000000.000",123.78);
        customFormat("$###,###.###",12345.67);

        n.beyondSimpleMath();

        n.exLog();

        n.trig();

        System.out.println("Random number between 0 and 100: " + n.getRandom());
    }
}
