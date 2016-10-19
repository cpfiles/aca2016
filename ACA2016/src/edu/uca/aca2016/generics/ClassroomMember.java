package edu.uca.aca2016.generics;

import edu.uca.aca2016.basics.Person;
import edu.uca.aca2016.basics.Student;
import edu.uca.aca2016.basics.Teacher;

/**
 *
 * @author cfiles
 */
public class ClassroomMember<T extends Person>{
    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }
    
    public int age(){
        return t.getAgeInYears();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ClassroomMember<Person> sh = new ClassroomMember<Person>();
        
        Student s = new Student("John", "Smith");
        s.setAgeInDays(7300);
        sh.set(s);
        System.out.println(sh.get().getFullName());
        System.out.println(sh.age());
        
        Teacher t = new Teacher("Jane", "Doe");
        t.setAgeInDays(16200);
        sh.set(t);
        System.out.println(sh.get().getFullName());
        System.out.println(sh.age());
    }
}
