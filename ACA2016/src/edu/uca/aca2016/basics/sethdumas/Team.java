/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.sethdumas;

/**
 *
 * The new class needs the following fields: name, sport, city, state, and
 * number of players.
 */
public class Team {

    private String Name;
    private String Sport;
    private String City;
    private String State;
    private int NumberOfPlayers;

    /**
     * Set all of the fields using setters
     */
    public void setName(String value) {
        this.Name = value;
    }

    public void setSport(String value) {
        this.Sport = value;
    }

    public void setCity(String value) {
        this.City = value;
    }

    public void setState(String value) {
        this.State = value;
    }

    public int setNumberOfPlayers() {
        return NumberOfPlayers;
    }

    //Set the getters
    public String getName() {
        return this.Name;
    }

    public String getSport() {
        return this.Sport;
    }

    public String getCity() {
        return this.City;
    }

    public String getState() {
        return this.State;
    }

    public short getNumberOfPlayers() {
        return this.NumberOfPlayers;
    }

    //Not sure how to retrieve them
    public static void main(String[] args) {
        Team my_team = new Team();
        my_team.setName(Cats);

    }

    //output the values to the screen using System.out.println()
    System.out.println (

"MyTeam.getName")
    System.out.println("City")
    System.out.println("Name")
    System.out.println("Name")
    System.out.println("Name")
    System.out.println("Name")
}
