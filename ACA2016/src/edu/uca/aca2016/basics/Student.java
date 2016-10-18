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
public class Student extends Person  implements Comparable<Student> {
    
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
    
    public String getFullName() {
        String n = super.getFullName();
        n += " (Student)";
        return n;
    }

    @Override
    public int compareTo(Student s){
        int lastCmp = this.getLastName().compareTo(s.getLastName());
        
        return (lastCmp != 0 ? lastCmp : this.getFirstName().compareTo(s.getFirstName()));
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student))
            return false;
        
        Student s = (Student) o;
        return s.getFirstName().equals(this.getFirstName()) && s.getLastName().equals(this.getLastName());
    }

    @Override
    public int hashCode() {
        return 31*this.getFirstName().hashCode() + this.getLastName().hashCode();
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
