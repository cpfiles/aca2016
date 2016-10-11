/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.jrob582;



/**
 * Team Object Model
 * 
 * This is a simple class that defines a team,sport,city,state,and number_of_players
 * 
 * 
 * @author johna
 */
public class Team{
    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_0f_Players_;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getSport() {
        return sport;
    }

    /**
     *
     * @param sport
     */
    public void setSport(String sport) {
        this.sport = sport;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getNumber_0f_Players_() {
        return number_0f_Players_;
    }

    /**
     *
     * @param number_0f_Players_
     */
    public void setNumber_0f_Players_(int number_0f_Players_) {
        this.number_0f_Players_ = number_0f_Players_;
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Team my_team = new Team();
        my_team.setName("Razorbacks");
        my_team.setSport("Football");
        my_team.setCity("Fayetteville");
        my_team.setState("Arkansas");
        my_team.setNumber_0f_Players_(11);
        
        System.out.println (my_team.getName());
        System.out.println (my_team.getSport() );
        System.out.println (my_team.getCity());
        System.out.println (my_team.getState());
        System.out.println (my_team.getNumber_0f_Players_());
    }   

  
} 
    
    
     
         
     
            
     
    
    
 




