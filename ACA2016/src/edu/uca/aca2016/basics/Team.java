/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics;

/**
 * assignment: add "name", "sport", "city", "state", and "# of players" fields
 * inside main method, initiate those classes and "set" fields and print them.
 *
 * @author Carter
 */
public class Team {

    /**
     * @param args the command line arguments
     */
    private String team_name;
    private String team_sport;
    private String team_city;
    private String team_state;
    private int team_players;

    public void setTeamName(String teamName) {
        this.team_name = teamName;
    }

    public String getTeamName() {
        String ret = "Team Name: " + this.team_name;
        return ret;
    }

    public void setTeamSport(String teamSport) {
        this.team_sport = teamSport;
    }

    public String getTeamSport() {
        String ret = "Sport: " + this.team_sport;
        return ret;
    }

    public void setTeamCity(String teamCity) {
        this.team_city = teamCity;
    }

    public String getTeamCity() {
        String ret = "Hometown: " + this.team_city;
        return ret;
    }

    public void setTeamState(String teamState) {
        this.team_state = teamState;
    }

    public String getTeamState() {
        String ret = "State: " + this.team_state;
        return ret;
    }

    public void setTeamPlayers(int teamPlayers) {
        this.team_players = teamPlayers;
    }

    public String getTeamPlayers() {
        String ret = "Team Size: " + Integer.toUnsignedString(team_players);
        return ret;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Team daHawgz = new Team();
        daHawgz.setTeamName("The Razorbacks");
        daHawgz.setTeamSport("Football");
        daHawgz.setTeamCity("Fayetteville");
        daHawgz.setTeamState("AR");
        daHawgz.setTeamPlayers(18);
        
        System.out.println(daHawgz.getTeamName());
        System.out.println(daHawgz.getTeamSport());
        System.out.println(daHawgz.getTeamCity());
        System.out.println(daHawgz.getTeamState());
        System.out.println(daHawgz.getTeamPlayers());
    }

}
