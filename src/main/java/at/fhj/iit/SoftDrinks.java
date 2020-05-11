package at.fhj.iit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoftDrinks extends at.fhj.iit.SimpleDrink {
    private String color;
    private Set<String> container = new HashSet();
    private Map<String, Double> nutritionalValue;


    /**
     * A constructor for the class SoftDrinks.
     * @param liquid
     * @param name
     * @param color
     * @param container
     * @param nutritionalValue
     */
    public SoftDrinks(Liquid liquid, String name, String color, Set<String> container, Map nutritionalValue) {
        super(name, liquid);
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

    /**
     * Returns a map with nutrition values based on the volume of the drink.
     * @return nutritionValueTotal
     */
    public Map nutritionValueTotal()  {
        Map<String, Double> nutritionsToVolume = new HashMap<>();
        try{
            // If drink is empty throw an exception
            if(this.getVolume() == 0){
                throw new EmptyDrinkException();
            }

            // Iterate nutrionalValue based on Keys
            for (String key: nutritionalValue.keySet()) {
                // Add nutritionValue/volume to returned map
                nutritionsToVolume.put(key,
                        nutritionalValue.get(key).doubleValue()*(((double)this.getVolume())/0.1));
            }
        }catch(EmptyDrinkException e){
            System.out.println(e.getMessage());
        }
        return nutritionsToVolume;
    }

}
