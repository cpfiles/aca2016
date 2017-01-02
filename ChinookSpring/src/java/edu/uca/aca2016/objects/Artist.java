package edu.uca.aca2016.objects;

import java.io.Serializable;

public class Artist implements Serializable {
    private int id;
    private String name;
    
    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("Name: " + name);
        return buffer.toString();
    }
}