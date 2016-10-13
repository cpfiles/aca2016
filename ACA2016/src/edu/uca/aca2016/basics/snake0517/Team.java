/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.snake0517;

/**
 *
 * @author brela
 */
public class Team {

    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_of_players;
    
    public void setName (String value) {
        this.name = value;
    }
    public void setSport (String value) {
        this.sport = value;
    }
    public void setCity (String value) {
        this.city = value;
    }
    public void setState (String value) {
        this.state = value;
    }
    public void setNumber_of_players (int value) {
        this.number_of_players = value;
    }
    public String getName () {
        return this.name;
    }
    public String getSport () {
        return this.sport;
    }
    public String getCity () {
        return this.city;
    }
    public String getState () {
        return this.state;
    }
    public int getNumber_of_players () {
        return number_of_players;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team myTeam = new Team();
        myTeam.setName("Cavaliers");
        myTeam.setSport("Basketball");
        myTeam.setCity("Cleveland");
        myTeam.setState("Ohio");
        myTeam.setNumber_of_players(13);
        
        System.out.println("Name" + ":" + " " + myTeam.getName());
        System.out.println("Sport" + ":" + " " + myTeam.getSport());
        System.out.println("City" + ":" + " " + myTeam.getCity());
        System.out.println("State" + ":" + " " + myTeam.getState());
        System.out.println("Number of Players" + ":" + " " +  myTeam.getNumber_of_players());
    }
    
}
