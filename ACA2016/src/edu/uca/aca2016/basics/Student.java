/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics;

/**
 *
 * @author cfiles
 */
public class Student extends Person {
    
    public Student(String first_name, String last_name) {
        this.setFirstName(first_name);
        this.setLastName(last_name);
    }
    
    public Student() {
        
    }
    
    public static void gpa(double p) {
        p = 3.5;
    }
    
    public void firstTeacher(Person teacher) {
        teacher.setFirstName("Janet");
    }
}
