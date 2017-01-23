package edu.uca.aca2016.objects;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Album implements Serializable {
    private int id;
    private String title;
    private int artistid;
    
    private Artist artist;
    private Map<Integer, String> artists;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setArtistid(int i) {
        artistid = i;
    }

    public int getArtistid() {
        return artistid;
    }
    
    public Map<Integer,String> getArtists() {
        return this.artists;
    }
    
    public void setArtists(Map<Integer,String> artists) {
        this.artists = artists;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("Title: " + title);
        return buffer.toString();
    }
}