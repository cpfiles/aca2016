/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author cfiles
 */
public class BasicIO{
    public void copyBytes() throws FileNotFoundException, IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            Path inpath = Paths.get("resources", "io", "xanadu.txt");
            in = new FileInputStream(inpath.toFile());
            
            Path outpath = Paths.get("resources", "io", "outagain.txt");
            out = new FileOutputStream(outpath.toFile());
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } 
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
    
    public void copyChars() throws FileNotFoundException, IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            Path inpath = Paths.get("resources", "io", "xanadu.txt");
            inputStream = new FileReader(inpath.toFile());
            
            Path outpath = Paths.get("resources", "io", "characteroutput.txt");
            outputStream = new FileWriter(outpath.toFile());

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } 
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public void copyLines() throws FileNotFoundException, IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            Path inpath = Paths.get("resources", "io", "xanadu.txt");
            inputStream = new BufferedReader(new FileReader(inpath.toFile()));
            
            Path outpath = Paths.get("resources", "io", "characteroutput.txt");
            outputStream = new PrintWriter(new FileWriter(outpath.toFile()));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } 
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public void scanXan() throws FileNotFoundException {
        Scanner s = null;

        try {
            Path inpath = Paths.get("resources", "io", "xanadu.txt");
            s = new Scanner(new BufferedReader(new FileReader(inpath.toFile())));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } 
        finally {
            if (s != null) {
                s.close();
            }
        }
    }
    
    public void scanNums() throws FileNotFoundException {
        Scanner s = null;
        double sum = 0;

        try {
            Path inpath = Paths.get("resources", "io", "usnumbers.txt");
            s = new Scanner(new BufferedReader(new FileReader(inpath.toFile())));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } 
                else {
                    s.next();
                }   
            }
        } finally {
            s.close();
        }

        System.out.println(sum);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        BasicIO io = new BasicIO();
        io.copyBytes();
        io.copyChars();
        io.copyLines();
        io.scanXan();
        io.scanNums();
    }
}
