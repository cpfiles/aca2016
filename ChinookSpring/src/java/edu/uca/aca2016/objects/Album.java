package edu.uca.aca2016.objects;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {
    private int id;
    private String title;
    private Artist artist;
    private List<Artist> artists;

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
    
    public List<Artist> getArtists() {
        return this.artists;
    }
    
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("Title: " + title);
        return buffer.toString();
    }
}