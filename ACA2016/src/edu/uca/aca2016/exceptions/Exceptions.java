/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.exceptions;

import java.io.FileWriter;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author cfiles
 */
public class Exceptions{

    private List<Integer> list;
    private static final int SIZE = 10;

    public Exceptions(){
        list = new ArrayList<Integer>(SIZE);

        for(int i = 0; i < SIZE; i++){
            list.add(new Integer(i));
        }
    }

    public void writeList(){
        PrintWriter out = null;

        try{
            System.out.println("Entering try statement");

            File output_path = new File(System.getProperty("user.home"),"out.txt");
            //File output_path = new File("/", "out.txt");

            System.out.println("Attempting to write: " + output_path.getAbsolutePath());

            out = new PrintWriter(new FileWriter(output_path));

            for(int i = 0; i < SIZE; i++){
                out.println("Value at: " + i + " = " + list.get(i));
            }
        }
        catch(IndexOutOfBoundsException e){
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }
        catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
        finally{
            if(out != null){
                System.out.println("Closing PrintWriter");
                out.close();
            }
            else{
                System.out.println("PrintWriter not open");
            }
        }
    }

    public void writeListSpecify() throws IOException,IndexOutOfBoundsException{
        PrintWriter out = null;

        System.out.println("Entering try statement");

        File output_path = new File(System.getProperty("user.home"),"out.txt");

        System.out.println("Attempting to write: " + output_path.getAbsolutePath());

        out = new PrintWriter(new FileWriter(output_path));

        for(int i = 0; i < SIZE; i++){
            out.println("Value at: " + i + " = " + list.get(i));
        }

        out.close();
    }

    public void writeListChained() throws Exception{
        PrintWriter out = null;

        try{
            System.out.println("Entering try statement");

            File output_path = new File(System.getProperty("user.home"),"out.txt");

            System.out.println("Attempting to write: " + output_path.getAbsolutePath());

            out = new PrintWriter(new FileWriter(output_path));

            for(int i = 0; i < SIZE; i++){
                out.println("Value at: " + i + " = " + list.get(i));
            }
        }
        catch(IndexOutOfBoundsException e){
            throw new Exception("IOError: " + e.getMessage());
        }
        catch(IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
        finally{
            if(out != null){
                System.out.println("Closing PrintWriter");
                out.close();
            }
            else{
                System.out.println("PrintWriter not open");
            }
        }
    }

    public double divideNumbers(int dividend,int divisor){
        // division by zero, throw an exception
        if(divisor == 0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }

        return dividend / divisor;
    }

    public void throwException() throws ACAException{
        throw new ACAException("Throwing ACA Exception");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Exceptions e = new Exceptions();
        e.writeList();

        try{
            e.writeListSpecify();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Divide Numbers: " + e.divideNumbers(5,0));

        try{
            e.writeListChained();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            e.throwException();
        }
        catch(ACAException ex){
            ex.printStackTrace();
        }
    }
}
