/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.ACA1WOODRUFF;

/**
 *
 * @author awood
 */
public class Team {
// define instance variables
    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_of_players;
    
   public void setName(String value) {       
     this.name = value;
    }
     public void setSport(String value) {
        this.sport = value;
    }
  public void setCity (String value) {
        this.city = value;
    }
  public void setState(String value) {
        this.state = value;
    }
  public void setNumber_of_players ( int value) {
        this.number_of_players = value;
    }
  
  public String getName() {
        return this.name;
    }
  
  public String getSport() {
        return this.sport;
    }
  public String getCity() {
        return this.city; 
  }
 public String getState() {
        return this.state; 
 }
  public int getNumber_of_players() {
        return this.number_of_players;
  }
     /**
     * Construct and return the team's profile.
     * @return Team's full profile
     */
  
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team my_team = new Team();
        my_team.setName("Longhorns");
        my_team.setSport("Football");
        my_team.setCity("Austin");
        my_team.setState ("Texas");
        my_team.setNumber_of_players(40);
     
     // print my_team profile   
    System.out.println(my_team.getName());
    System.out.println(my_team.getSport());
    System.out.println(my_team.getCity());    
    System.out.println(my_team.getState()); 
    System.out.println(my_team.getNumber_of_players());
    } 

}
