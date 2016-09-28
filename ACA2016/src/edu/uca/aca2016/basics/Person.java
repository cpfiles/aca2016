package edu.uca.aca2016.basics;

/**
 * Person Object Model
 * 
 * This is a simple class that defines the attributes of a person.
 * 
 * @author cfiles
 */
public class Person{
    // define instance variables    
    private String first_name;
    private String last_name;
    private char middle_initial;
    private long age_in_seconds;
    private int age_in_days;
    private short age_in_years;
    private float weight;
    private double income;
    private boolean is_living = true;
    private Person[] parents = new Person[2];
    
    /**
     * Value - {@value}, the species of the person 
     */
    public static String species = "Homo sapien";
    
    /**
     * Set the age of the Person. Also calculate other ways to display age.
     * @param value Person's age 
     */
    public void setAgeInDays(int value) {
        this.age_in_days = value;
        
        // multiply age in days by seconds in a day to get age in seconds
        this.age_in_seconds = value * 86400;
        
        // divide age in days by days in a year to get rounded age in years
        this.age_in_years = (short) (value/365);
    }

    /**
     * Return age in seconds
     * @return age in seconds
     */
    public long getAgeInSeconds(){
        return age_in_seconds;
    }

    /**
     * Return age in years
     * @return age in years
     */
    public short getAgeInYears(){
        return age_in_years;
    }
    
    /**
     * Return age in days
     * @return age in days
     */
    public int getAgeInDays(){
        return age_in_days;
    }

    /**
     * Set the first name of the Person
     * @param value Person's first name
     */
    public void setFirstName(String value) {
        this.first_name = value;
    }
    
    /**
     * Return person's middle initial
     * @return middle initial
     */
    public char getMiddleInitial(){
        return middle_initial;
    }

    /**
     * Set person's middle initial
     * @param middle_initial middle initial
     */
    public void setMiddleInitial(char middle_initial){
        this.middle_initial = middle_initial;
    }
    
    /**
     * Set the last name of the Person
     * @param value Person's last name
     */
    public void setLastName(String value) {
        this.last_name = value;
    }

    /**
     * Return the first name of the Person
     * @return Person's first name
     */
    public String getFirstName () {
        return this.first_name;
    }
    
    /**
     * Return the last name of the Person
     * @return Person's last name
     */
    public String getLastName() {
        return this.last_name;
    }
    
    /**
     * Construct and return the person's full name.
     * @return Person's full name
     */
    public String getFullName() {
        // make the full name in a local variable
        String ret = this.first_name;
        
        if (this.middle_initial != '\u0000') {
            ret += " " + this.middle_initial;
        }
        
        ret += " " + this.last_name;
        
        return ret;
    }
    
    /**
     * Return income
     * @return income
     */
    public double getIncome(){
        return income;
    }

    /**
     * Set income
     * @param income income value in U.S. dollars
     */
    public void setIncome(double income){
        this.income = income;
    }

    /**
     * Is this person living?
     * @return true if living, false if dead.
     */
    public boolean isLiving(){
        return is_living;
    }

    /**
     * Set if this person is living
     * @param is_living true if living, false if dead
     */
    public void isLiving(boolean is_living){
        this.is_living = is_living;
    }
    
    /**
     * Return person's weight
     * @return person's weight in pounds
     */
    public float getWeight(){
        return weight;
    }

    /**
     * Set person's weight
     * @param weight weight in pounds
     */
    public void setWeight(float weight){
        this.weight = weight;
    }
    
    public void setParents(Person mother, Person father) {
        this.parents[0] = mother;
        this.parents[1] = father;
    }
    
    public Person getMother() {
        return this.parents[0];
    }
    
    public Person getFather() {
        return this.parents[1];
    }
}
