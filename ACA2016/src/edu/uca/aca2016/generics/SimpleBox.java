package edu.uca.aca2016.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfiles
 */
public class SimpleBox{
    private Object object;

    public void castVsGeneric(){
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);

        List<String> listg = new ArrayList<String>();
        listg.add("hello");
        String q = listg.get(0);
    }

    public void set(Object object){
        this.object = object;
    }

    public Object get(){
        return object;
    }

    public static void main(String[] args){
        SimpleBox integerBox = new SimpleBox();
        integerBox.set(5);
        
        System.out.println(integerBox.get());
        
        SimpleBox stringBox = new SimpleBox();
        stringBox.set("Hello!");
        
        System.out.println(stringBox.get());
    }
}
