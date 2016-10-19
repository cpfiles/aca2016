package edu.uca.aca2016.generics;

/**
 *
 * @author cfiles
 */
public class GenericBox<T>{
    // T stands for "Type"
    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

    public static void main(String[] args){
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.set(5);
        
        System.out.println(integerBox.get());
        
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello!");
        
        System.out.println(stringBox.get());
    }
}
