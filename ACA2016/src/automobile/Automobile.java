/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobile;

/**
 *
 * @author Chris
 */
public class Automobile {

    /**
     * @param args the command line arguments
     */
    private String numberofwheels;
    private String height;
    private String weight;

    public Automobile() {
        this("Four", "60 inches", "2605 pounds");

    }

    public Automobile(String numberofwheels, String height, String weight) {
        this.numberofwheels = numberofwheels;
        this.weight = weight;
        this.height = height;
    }

    public void setNumberofwheels(String numberofwheels) {
        this.numberofwheels = numberofwheels;
    }

    /**
     * @return the numberofwheels
     */
    public String getNumberofwheels() {
        return numberofwheels;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

}

