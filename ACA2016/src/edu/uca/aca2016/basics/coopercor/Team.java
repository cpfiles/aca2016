/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.coopercor;

/**
 *
 * @author Cory's HP Pavilion
 */
public class Team {
    //add the following fields to this class: name, sport, city, state, number of players
    //Creating the fields in the Team class
    private String team_name;           // creating the name of the team
    private String sport;               // creating the sport for the team
    private String city;                // creating the city for the team
    private String state;               // creating the state for the team
    private int number_of_players;    // creating the number of players field
    
//Setting the value of the team
//public static String team = "Football";

//Creating the team name
public void setTeamName (String value) {
    this.team_name = value;

}
public String getTeamName (){
    return team_name;
}

//Creating the sport value
public void setSportType (String value) {
    this.sport = value;
}

public String getSportType (){
    return sport;
}

//Creating the city value
public void setCity (String value){
    this.city = value;
}

public String getCity (){
    return city;
}

//Creating the state value
public void setState (String value){
    this.state = value;
}

public String getState () {
    return state;
}

public void setNumberOfPlayers (int value) {
    this.number_of_players = value;
}

public int getNumberOfPlayers () {
    return number_of_players;
}




   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team chargers = new Team ();
        
        chargers.setSportType("Football");
        chargers.setCity("San Diego");
        chargers.setState("CA");
        chargers.setNumberOfPlayers(75);
        
        System.out.println("My Favorite Sport is" + chargers.getSportType());
        System.out.println("The number of players:" + chargers.getNumberOfPlayers());
        System.out.println (chargers.getCity());
        System.out.println (chargers.getState());
    }
    
}

//set and get function for all five of the fields
//initialize the team class and set all of those values in the main method
//print all those value to the screen