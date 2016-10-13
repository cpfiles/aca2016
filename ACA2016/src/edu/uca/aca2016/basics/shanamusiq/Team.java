/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.basics.shanamusiq;

/**
 *
 * @author Shana
 */
public class Team {
//instance variables

    private String Name;
    private String Sport;
    private String State;
    private String City;
    private int NumberofPlayers;

    /**
     *
     * @param TeamName
     */
    public void SetTeamName(String TeamName) {
        this.Name = TeamName;
    }

    /**
     *
     * @param SportName
     */
    public void SetSportName(String SportName) {
        this.Sport = SportName;
    }

    /**
     *
     * @param CityName
     */
    public void SetCityName(String CityName) {
        this.City = CityName;
    }

    /**
     *
     * @param NumofPlayers
     */
    public void SetNumberofPlayers(int NumofPlayers) {
        this.NumberofPlayers = NumofPlayers;
    }

    /**
     *
     * @param StateName
     */
    public void SetStateName(String StateName) {
        this.State = StateName;
    }

    /**
     *
     * @return
     */
    public String GetTeamName() {
        return this.Name;
    }

    /**
     *
     * @return
     */
    public String GetSportName() {
        return this.Sport;
    }

    /**
     *
     * @return
     */
    public String GetCityName() {
        return this.City;
    }

    /**
     *
     * @return
     */
    public String GetStateName() {
        return this.State;
    }

    /**
     *
     * @return
     */
    public int GetNumberofPlayers() {
        return this.NumberofPlayers;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Team MyTeam = new Team();
        MyTeam.SetTeamName("Sugar Bears");
        MyTeam.SetCityName("Conway");
        MyTeam.SetStateName("Arkansas");
        MyTeam.SetSportName("Basketball");
        MyTeam.SetNumberofPlayers(15);

        System.out.println(MyTeam.GetTeamName());
        System.out.println(MyTeam.GetCityName());
        System.out.println(MyTeam.GetStateName());
        System.out.println(MyTeam.GetSportName());
        System.out.println(MyTeam.GetNumberofPlayers());

    }

}
