/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.uca.aca2016.Calhoun512;

/**
 * The code in this class was taken from the Oracle Documentation on Java:
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html
 */
public class FlowStatements{

    public void ifThen(){
        if(true){
            System.out.println("Statement is true");
        }
    }

    public void ifThenElse(){
        if(true){
            System.out.println("Statement is true");
        }
        else{
            System.out.println("Statement is false");
        }
    }

    public void ifThenElseMore(){
        int testscore = 76;
        char grade;

        if(testscore >= 90){
            grade = 'A';
        }
        else if(testscore >= 80){
            grade = 'B';
        }
        else if(testscore >= 70){
            grade = 'C';
        }
        else if(testscore >= 60){
            grade = 'D';
        }
        else{
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    }

    public void switchBreak(){
        int month = 8;
        String monthString;
        switch(month){
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
                break;
        }
        System.out.println(monthString);
    }

    public void switchFallThrough(){
        java.util.ArrayList<String> futureMonths = new java.util.ArrayList<String>();

        int month = 8;

        switch(month){
            case 1:
                futureMonths.add("January");
            case 2:
                futureMonths.add("February");
            case 3:
                futureMonths.add("March");
            case 4:
                futureMonths.add("April");
            case 5:
                futureMonths.add("May");
            case 6:
                futureMonths.add("June");
            case 7:
                futureMonths.add("July");
            case 8:
                futureMonths.add("August");
            case 9:
                futureMonths.add("September");
            case 10:
                futureMonths.add("October");
            case 11:
                futureMonths.add("November");
            case 12:
                futureMonths.add("December");
                break;
            default:
                break;
        }

        if(futureMonths.isEmpty()){
            System.out.println("Invalid month number");
        }
        else{
            for(String monthName : futureMonths){
                System.out.println(monthName);
            }
        }
    }

    public static int switchWithStrings(String month){
        int monthNumber = 0;

        if(month == null){
            return monthNumber;
        }

        switch(month.toLowerCase()){
            case "january":
                monthNumber = 1;
                break;
            case "february":
                monthNumber = 2;
                break;
            case "march":
                monthNumber = 3;
                break;
            case "april":
                monthNumber = 4;
                break;
            case "may":
                monthNumber = 5;
                break;
            case "june":
                monthNumber = 6;
                break;
            case "july":
                monthNumber = 7;
                break;
            case "august":
                monthNumber = 8;
                break;
            case "september":
                monthNumber = 9;
                break;
            case "october":
                monthNumber = 10;
                break;
            case "november":
                monthNumber = 11;
                break;
            case "december":
                monthNumber = 12;
                break;
            default:
                monthNumber = 0;
                break;
        }

        return monthNumber;
    }

    public void whileExample(){
        int count = 1;
        while(count < 11){
            System.out.println("Count is: " + count);
            count++;
        }
    }

    public void doWhileExample(){
        int count = 1;
        do{
            System.out.println("Count is: " + count);
            count++;
        }
        while(count < 11);
    }

    public void forExample(){
        for(int i = 1; i < 11; i++){
            System.out.println("Count is: " + i);
        }
    }

    public void forEnhancedExample(){
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        for(int item : numbers){
            System.out.println("Count is: " + item);
        }
    }

    public void breakExample(){
        int[] arrayOfInts = {32,87,3,589,12,1076,2000,8,622,127};
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        for(i = 0; i < arrayOfInts.length; i++){
            if(arrayOfInts[i] == searchfor){
                foundIt = true;
                break;
            }
        }

        if(foundIt){
            System.out.println("Found " + searchfor + " at index " + i);
        }
        else{
            System.out.println(searchfor + " not in the array");
        }
    }

    public void continueExample(){
        String searchMe = "peter piper picked a peck of pickled peppers";
        int max = searchMe.length();
        int numPs = 0;

        for(int i = 0; i < max; i++){
            // interested only in p's
            if(searchMe.charAt(i) != 'p'){
                continue;
            }

            // process p's
            numPs++;
        }
        System.out.println("Found " + numPs + " p's in the string.");
    }

    public void breakWithLabel(){
        int[][] arrayOfInts = {
            {32,87,3,589},
            {12,1076,2000,8},
            {622,127,77,955}
        };
        
        int searchfor = 12;

        int i;
        int j = 0;
        boolean foundIt = false;

        search:
        for(i = 0; i < arrayOfInts.length; i++){
            for(j = 0; j < arrayOfInts[i].length;
                j++){
                if(arrayOfInts[i][j] == searchfor){
                    foundIt = true;
                    break search;
                }
            }
        }

        if(foundIt){
            System.out.println("Found " + searchfor + " at " + i + ", " + j);
        }
        else{
            System.out.println(searchfor + " not in the array");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        FlowStatements flow = new FlowStatements();
        flow.ifThen();
        flow.ifThenElse();
        flow.ifThenElseMore();
        flow.switchBreak();
        flow.switchFallThrough();

        int returnedMonthNumber = flow.switchWithStrings("August");
        if(returnedMonthNumber == 0){
            System.out.println("Invalid month");
        }
        else{
            System.out.println(returnedMonthNumber);
        }

        flow.whileExample();
        flow.doWhileExample();
        flow.forExample();
        flow.forEnhancedExample();
        flow.breakExample();
        flow.continueExample();
        flow.breakWithLabel();
    }
}
