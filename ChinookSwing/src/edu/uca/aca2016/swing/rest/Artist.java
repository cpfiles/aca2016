package edu.uca.aca2016.swing.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;

    public Artist(){
    }

    public Artist(long id,String name){
        super();
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public Artist withId(long id){
        this.id = id;
        return this;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Artist withName(String name){
        this.name = name;
        return this;
    }
}
