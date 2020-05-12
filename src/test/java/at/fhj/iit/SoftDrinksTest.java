package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLEngineResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@DisplayName("Testing SoftDrink implementation")
public class SoftDrinksTest {
    private SoftDrinks sdN, sdZV, sdZN, sdEC;
    private Set<String> container;
    private Map<String, Double> nutritionalValue;
    private Map<String, Double> emptyNutritionalValue;
    private Set<String> emptyContainer;

    /**
     * inits...
     *   1) normal Soft Drink
     *   2) one with no volume
     *   3) one with empty nutritional Values
     *   4) one with no container
     *   ...for EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        Liquid lN = new Liquid("Wasser", 0.125, 0);
        Liquid lZ = new Liquid("Wasser", 0, 0);

        container = new HashSet<>();
        container.add("Dose");
        container.add("Glas Flasche");
        container.add("Plastik Flasche");

        nutritionalValue = new HashMap<>();
        nutritionalValue.put("Fett", 0.);
        nutritionalValue.put("Eiweiß", 0.);
        nutritionalValue.put("Broteinheiten", 0.8);
        nutritionalValue.put("Zucker", 9.);

        sdN = new SoftDrinks(lN, "Fanta", "Orange", container, nutritionalValue);
        sdZV = new SoftDrinks(lZ, "Cola", "Black", container, nutritionalValue);

        emptyNutritionalValue = new HashMap<>();
        sdZN = new SoftDrinks(lN, "Test1", "Brown", container, emptyNutritionalValue);

        emptyContainer = new HashSet<>();
        sdEC = new SoftDrinks(lN, "Test2", "", emptyContainer, nutritionalValue);
    }

    @Test
    @DisplayName("Testing constructor Normal")
    public void testConstructorNormal(){
        assertEquals(sdN.getColor(), "Orange");
        assertEquals(sdN.getContainer(), container);
        assertEquals(sdN.getNutritionalValue(), nutritionalValue);
    }

    @Test
    @DisplayName("Testing constructor no Volume")
    public void testConstructorNoVolume(){
        assertEquals(sdZV.getColor(), "Black");
        assertEquals(sdZV.getContainer(), container);
        assertEquals(sdZV.getNutritionalValue(), nutritionalValue);
    }

    @Test
    @DisplayName("Testing constructor empty nutritional Values")
    public void testConstructorEmptyNutritionalValue(){
        assertEquals(sdZN.getColor(), "Brown");
        assertEquals(sdZN.getContainer(), container);
        assertEquals(sdZN.getNutritionalValue(), emptyNutritionalValue);
    }

    @Test
    @DisplayName("Testing constructor empty Container")
    public void testConstructorEmptyContainer(){
        assertEquals(sdEC.getColor(), "");
        assertEquals(sdEC.getContainer(), emptyContainer);
        assertEquals(sdEC.getNutritionalValue(), nutritionalValue);
    }

    @Test
    @DisplayName("Testing inheritance Normal")
    public void testInheritanceNormal(){
        assertEquals(sdN.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdN.getVolume(), 0.125, 0.001);
    }

    @Test
    @DisplayName("Testing inheritance no Volume")
    public void testInheritanceNoVolume(){
        assertEquals(sdZV.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdZV.getVolume(), 0, 0.001);
    }

    @Test
    @DisplayName("Testing inheritance empty nutritionValue")
    public void testInheritanceEmptyNutritionalValue(){
        assertEquals(sdZN.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdZN.getVolume(), 0.125, 0.001);
    }

    @Test
    @DisplayName("Testing inheritance empty Container")
    public void testInheritanceEmptyContainer(){
        assertEquals(sdEC.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdEC.getVolume(), 0.125, 0.001);
    }

    @Test
    @DisplayName("Testing setter Color")
    public void testSetterColor(){
        sdN.setColor("Blau");
        assertEquals(sdN.getColor(), "Blau");
    }

    @Test
    @DisplayName("Testing setter Container")
    public void testSetterContainer(){
        Set<String> test = new HashSet<>();
        test.add("Dose");
        sdN.setContainer(test);
        assertEquals(sdN.getContainer(), test);
    }

    @Test
    @DisplayName("Testing setter nutritionalValue")
    public void testSetterNutritionalValue(){
        Map<String, Double> testNutritionalValue = new HashMap<>();
        testNutritionalValue.put("Fett", 0.5);
        sdN.setNutritionalValue(testNutritionalValue);
        assertEquals(sdN.getNutritionalValue(), testNutritionalValue);
    }

    @Test
    @DisplayName("Testing nutritionValueTotal")
    public void testNutritionValueTotal(){
        Map<String, Double> expectedValues = new HashMap<>();
        expectedValues.put("Fett", 0.);
        expectedValues.put("Eiweiß", 0.);
        expectedValues.put("Broteinheiten", 1.);
        expectedValues.put("Zucker", 11.25);
        assertEquals(sdN.nutritionValueTotal(), expectedValues);
    }

    @Test
    @DisplayName("Testing nutritionValueTotal with no volume")
    public void testNutritionValueTotalNoVolume(){
        Map<String, Double> expectedValues = new HashMap<>();
        assertEquals(sdZV.nutritionValueTotal(), expectedValues);
    }
}
