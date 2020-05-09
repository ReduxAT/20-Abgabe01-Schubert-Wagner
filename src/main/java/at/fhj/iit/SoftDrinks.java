package main.java.at.fhj.iit;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoftDrinks extends at.fhj.iit.SimpleDrink {
    private String color;
    private Set container;
    private Map nutritionalValue;


    /**
     * A constructor for the class SoftDrinks.
     * @param color
     * @param container
     * @param nutritionalValue
     */
    public SoftDrinks(String color, Set container, Map nutritionalValue) {
        super(); //not public!!!!!
        this.color = color;
        this.container = container;
        this.nutritionalValue = nutritionalValue;
    }

    /**
     * Getter for the attribute color.
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the attribute color.
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for the attribute container.
     * @return
     */
    public Set getContainer() {
        return container;
    }

    /**
     * Setter for the attribute container.
     * @param container
     */
    public void setContainer(Set container) {
        this.container = container;
    }

    /**
     * Getter for the attribute nutritionalValue.
     * @return
     */
    public Map getNutritionalValue() {
        return nutritionalValue;
    }

    /**
     * Setter for the attribute nutritionalValue.
     * @param nutritionalValue
     */
    public void setNutritionalValue(Map nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public map nutritionValueTotal(int volume) {

    }

}
