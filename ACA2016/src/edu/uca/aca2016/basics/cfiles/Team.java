/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.cfiles;

/**
 *
 * @author cfiles
 */
public class Team{
    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_of_players;
    
    /**
     *
     * @param value
     */
    public void setName(String value) {
        this.name = value;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String getSport(){
        return sport;
    }

    /**
     *
     * @param sport
     */
    public void setSport(String sport){
        this.sport = sport;
    }

    /**
     *
     * @return
     */
    public String getCity(){
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState(){
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getNumber_of_players(){
        return number_of_players;
    }

    /**
     *
     * @param number_of_players
     */
    public void setNumber_of_players(int number_of_players){
        this.number_of_players = number_of_players;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Team my_team = new Team();
        my_team.setName("Cardinals");
        my_team.setCity("St. Louis");
        my_team.setState("MO");
        my_team.setNumber_of_players(40);
        my_team.setSport("Baseball");
        
        System.out.println(my_team.getName());
        System.out.println(my_team.getCity());
        System.out.println(my_team.getState());
        System.out.println(my_team.getNumber_of_players());
        System.out.println(my_team.getSport());
    }
    
}
