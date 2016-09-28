/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.clintlemons;

/**
 *
 * @author clintlemons
 */
public class Team {
    private String Name; 
    private String Sport;
    private String City;
    private String State;
    private int Number_of_players; 

    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSport() {
        return Sport;
    }
    
    public void setSport(String Sport) {
        this.Sport = Sport;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return State;
    }

    /**
     *
     * @param State
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     *
     * @return
     */
    public int getNumber_of_players() {
        return Number_of_players;
    }

    /**
     *
     * @param Number_of_players
     */
    public void setNumber_of_players(int Number_of_players) {
        this.Number_of_players = Number_of_players;
    }    
        
        /*            public String getName() {
        return this.Name;
        }
        }*/

    /**
     *
     * @param args
     */

            
        public static void main(String[] args) {
            Team myTeam = new Team();
            myTeam.setName("Rangers");
            myTeam.setSport("Soccer");
            myTeam.setCity("Little Rock");
            myTeam.setState("AR");
            myTeam.setNumber_of_players(32);
            
            
        System.out.println(myTeam.getName());
        System.out.println(myTeam.getSport());
        System.out.println(myTeam.getCity());
        System.out.println(myTeam.getState());
        System.out.println(myTeam.Number_of_players);
        }
}