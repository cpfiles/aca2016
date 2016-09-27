package edu.uca.aca2016.basics;

/*Person Class and the Team Assignment
Author: Terra D Dukes, duetea@gmail.com
Week 1- Thursday, September 22, 2016
*/
public class Team {
    private String Name;
    private String Sport;
    private String City;
    private String State;
    private int Number_Of_Players;
    
  
    public void setName(String value) {
        this.Name = value;
    }
    
    public String getName() {
        return this.Name;
    }

    public String getSport(){
        return Sport;
    }
    public void setSport(String Sport){
        this.Sport = Sport;
    }

    public String getCity(){
        return City;
    }
    
    public void setCity(String City){
        this.City = City;
    }

    public String getState(){
        return State;
    }

    public void setState(String State){
        this.State = State;
    }
    
    public int getNumber_Of_Players(){
        return Number_Of_Players;
    }

    public void setNumber_Of_Players(int Number_Of_Players){
        this.Number_Of_Players = Number_Of_Players;
    }

    public static void main(String[] args){
        Team my_team = new Team();
        my_team.setName("Lakers");
        my_team.setCity("Los Angeles");
        my_team.setState("California");
        my_team.setNumber_Of_Players(20);
        my_team.setSport("Basketball");
        
        System.out.println(my_team.getName());
        System.out.println(my_team.getCity());
        System.out.println(my_team.getState());
        System.out.println(my_team.getNumber_Of_Players());
        System.out.println(my_team.getSport());}
}






