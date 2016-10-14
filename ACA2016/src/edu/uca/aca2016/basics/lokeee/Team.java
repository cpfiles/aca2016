/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.lokeee;

/**
 *
 * @author lokeee
 */
public class Team {
    
    private String name;
    private String sport;
    private String city;
    private String state;
    private int number_of_players;
    
     /**
     * Set the  name of the Person
     * @param value Person's first name
     */
    public void setname(String value) {
        this.name = value;
    }
    
    /**
     * Return person's name
     * @return name
     */
    public String getname(){
        return name;
    }
    
       /**
     * Set the sport
     * @param value of the sport
     */
    public void setsport(String value) {
        this.sport = value;
    }
    
    /**
     * Return  sport
     * @return sport
     */
    public String getsport(){
        return sport;
    }  
  
     
       /**
     * Set the city
     * @param value of the city
     */
    public void setcity(String value) {
        this.city = value;
    }
    
    /**
     * Return city
     * @return city
     */
    public String getcity(){
        return city;
    }
    
          /**
     * Set the state
     * @param value of the state
     */
    public void setstate(String value) {
        this.state = value;
    }
    
    /**
     * Return state
     * @return state
     */
    public String getstate(){
        return state;
    }
    
     /**
    * Set the number of players
     * @param number_of_players of the number of players
     */
    public void setnumber_of_players (int number_of_players){
        this.number_of_players = number_of_players;
    }

    /**
     * return number_of_players
     * @return number_of_players
     */
    public int getnumber_of_players() {
        return number_of_players;
    }
    
      /**
     * @param args the command line arguments
     */
   public static void main(String[] args){
    Team one = new Team();
        // set the teams name
        one.setname("Oilers");
        // set the sport
        one.setsport ("Kickball");
        //set the city
        one.setcity ("Benton");
        //set the state
        one.setstate ("AR");
        //set the number of players
        one.setnumber_of_players (20);
                
        // print team profile
        
        System.out.println("Team Name " + one.getname());
        System.out.println("Sport " + one.getsport());
        System.out.println("City " + one.getcity());
        System.out.println("State" + one.getstate());
        System.out.println("number of players " + one.getnumber_of_players());
       
        
   }
    
}



