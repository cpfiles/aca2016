/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.curiologic;

/**
 *
 * @author xulix
 */
public class Team {

    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_players;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team myteam = new Team();
        // TODO code application logic here
        // set team information
        myteam.SetName ("moon");
        myteam.SetCity ("jax");
        myteam.SetState("AR");
        myteam.SetSport ("football");
        myteam.SetNumber_players (12);
        System.out.println("\tname: " + myteam.GetName());
        System.out.println("\tCity: " + myteam.GetCity());
        System.out.println("\tState: " + myteam.GetState());
        System.out.println("\tSport: " + myteam.GetSport());
        System.out.println("\tNumber_players: " + myteam.GetNumber_players());

    }

// sets team name  and gets //
    public void SetName(String value) {
        this.name = value;
    }

    public String GetName() {
        return name;

    }

    public void SetCity(String value) {
        this.city = value;
    }

    public String GetCity() {
        return city;
    }

    public void SetSport(String value) {
        this.sport = value;
    }

    public String GetSport() {
        return sport;

    }

    public void SetState(String value) {
        this.state = value;
    }

    public String GetState() {
        return state;
    }

    public void SetNumber_players(int value) {
        this.number_players = value;
    }

    public int GetNumber_players() {
        return number_players;
    }

}