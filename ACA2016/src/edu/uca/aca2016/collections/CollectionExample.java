/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.collections;

import edu.uca.aca2016.basics.Person;
import edu.uca.aca2016.basics.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author cfiles
 */
public class CollectionExample{
    
    public void simpleCollection() {
        List<String> list = new ArrayList<String>();
        
        list.add("One");
        list.add("Two");
        list.add("Three");
        
        System.out.println("All elements:");
        
        for (String o : list) {
            System.out.println(o);
        }
        
        list.remove("Two");
        
        System.out.println("After removal:");
        
        for (String o : list) {
            System.out.println(o);
        }
    }
    
    public void simpleSet() {
        Collection<String> set = new HashSet<String>();
        
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Two");
        
        for (String o : set) {
            System.out.println(o);
        }
    }
    
    public void countdownQueue() throws InterruptedException {
        int time = 10;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = time; i >= 0; i--) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }
    }
    
    public void simpleMap() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("AR", "Arkansas");
        m.put("AZ", "Arizona");
        m.put("AK", "Alaska");
        
        for (String key : m.keySet()) {
            System.out.println(key + ": " + m.get(key));
        }
    }
    
    public void studentList() {
        List<Student> pl = new ArrayList<Student>();
        
        pl.add(new Student("Frank", "Smith"));
        pl.add(new Student("John", "Doe"));
        pl.add(new Student("Jane", "Doe"));

        for (Student s : pl) {
            System.out.println(s.getFullName());
        }
        
        Collections.sort(pl);
        
        for (Student s : pl) {
            System.out.println(s.getFullName());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        CollectionExample ce = new CollectionExample();
  //      ce.simpleCollection();
//      ce.simpleSet();
 //       ce.countdownQueue();
//       ce.simpleMap();
        ce.studentList();
    }
}
