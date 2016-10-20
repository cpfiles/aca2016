package edu.uca.aca2016.generics;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfiles
 */
public class Wildcards{

    // Upper Bounded Wildcards
    public static double sumOfList(List<? extends Number> list){
        double s = 0.0;
        for(Number n : list){
            s += n.doubleValue();
        }
        return s;
    }

    /**
     * If you are writing a method that can be implemented using functionality
     * provided in the Object class. When the code is using methods in the
     * generic class that don't depend on the type parameter. For example,
     * List.size or List.clear. In fact, Class<?> is so often used because most
     * of the methods in Class<T> do not depend on T.
     *
     * @param list
     */
    public static void printList(List<?> list){
        for(Object elem : list){
            System.out.print(elem + " ");
        }

        System.out.println();
    }

    // Lower Bounded Wildcards
    public static void addNumbers(List<? super Integer> list){
        for(int i = 1; i <= 10; i++){
            list.add(i);
        }
    }

    public static void main(String[] args){
        // Upper Bounded Wildcards
        List<Integer> li = Arrays.asList(1,2,3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2,2.3,3.5);
        System.out.println("sum = " + sumOfList(ld));

        // Unbounded Wildcards
        printList(li);

        List<String> ls = Arrays.asList("one","two","three");
        printList(ls);
        
        // Lower Bounded Wildcards
        List<Integer> l = new ArrayList<>();
        addNumbers(l);
        printList(l);
    }

}
