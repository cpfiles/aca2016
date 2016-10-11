/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.jeffbanksz4l;

/**
 *
 * @author jeffb
 */
public class Team {
    //define instance variables
    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_of_players;
    
    /**
     * Set the Name
     * @param value Name
     */
    public void setName(String value) {
        this.name = value;
    }
    
    /**
     * Set the Sport
     * @param value Sport
     */
    public void setSport(String value) {
        this.sport = value;
    }
    
    /**
     * Set the City
     * @param value City
     */
    public void setCity(String value) {
        this.city = value;
    }
    
    /**
     * Set the State
     * @param value State
     */
    public void setState(String value) {
        this.state = value;
    }    
    
    /**
     * Set the Number of Players
     * @param value Number of Players
     */
    public void setNumberOfPlayers(int value) {
        this.number_of_players = value;
    }
    
    /**
     * Return the Name
     * @return the Name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Return the Sport
     * @return the Sport
     */
    public String getSport() {
        return this.sport;
    }
    
    /**
     * Return the City
     * @return the City
     */
    public String getCity() {
        return this.city;
    }
    
    /**
     * Return the State
     * @return the State
     */
    public String getState() {
        return this.state;
    }
    
    /**
     * Return number of players
     * @return number of players
     */
    public int getNumberOfPlayers() {
        return number_of_players;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team myTeam = new Team();
        
        // set the Name
        myTeam.setName("Cardinals");
        
        // set the Sport
        myTeam.setSport("Baseball");
        
        // set the City
        myTeam.setCity("St. Louis");
        
        // set the State
        myTeam.setState("Missouri");
        
        // set the Number Of Players
        myTeam.setNumberOfPlayers(9);
        
        // print myTeam
        System.out.println("Name" + ": " + myTeam.getName() );
        System.out.println("Sport" + ": " + myTeam.getSport() );
        System.out.println("City" + ": " + myTeam.getCity() );
        System.out.println("State" + ": " + myTeam.getState() );
        System.out.println("Number of Players" + ": " + myTeam.getNumberOfPlayers() );
    }
    
}