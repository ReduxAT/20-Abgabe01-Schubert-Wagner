package at.fhj.iit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLEngineResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

    /**
     * @author Dario Wagner
     * Method tests the constructor in normal Case with valid input
     */
    @Test
    @DisplayName("Testing constructor Normal")
    public void testConstructorNormal(){
        assertEquals(sdN.getColor(), "Orange");
        assertEquals(sdN.getContainer(), container);
        assertEquals(sdN.getNutritionalValue(), nutritionalValue);
    }

    /**
     * @author Dario Wagner
     * Method tests the constructor when Liquid Volume is 0
     */
    @Test
    @DisplayName("Testing constructor no Volume")
    public void testConstructorNoVolume(){
        assertEquals(sdZV.getColor(), "Black");
        assertEquals(sdZV.getContainer(), container);
        assertEquals(sdZV.getNutritionalValue(), nutritionalValue);
    }

    /**
     * @author Dario Wagner
     * Method tests the constructor when the nutrition Map is empty
     */
    @Test
    @DisplayName("Testing constructor empty nutritional Values")
    public void testConstructorEmptyNutritionalValue(){
        assertEquals(sdZN.getColor(), "Brown");
        assertEquals(sdZN.getContainer(), container);
        assertEquals(sdZN.getNutritionalValue(), emptyNutritionalValue);
    }

    /**
     * @author Dario Wagner
     * Method tests the contructor with an empty Container Set
     */
    @Test
    @DisplayName("Testing constructor empty Container")
    public void testConstructorEmptyContainer(){
        assertEquals(sdEC.getColor(), "");
        assertEquals(sdEC.getContainer(), emptyContainer);
        assertEquals(sdEC.getNutritionalValue(), nutritionalValue);
    }

    /**
     * @author Dario Wagner
     * Method tests the inheritance, with normal input
     */
    @Test
    @DisplayName("Testing inheritance Normal")
    public void testInheritanceNormal(){
        assertEquals(sdN.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdN.getVolume(), 0.125, 0.001);
    }

    /**
     * @author Dario Wagner
     * Method tests the inheritance, with Liquid Volume 0
     */
    @Test
    @DisplayName("Testing inheritance no Volume")
    public void testInheritanceNoVolume(){
        assertEquals(sdZV.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdZV.getVolume(), 0, 0.001);
    }

    /**
     * @author Dario Wagner
     * Method tests the inheritance, with an empty nutritionValue Map
     */
    @Test
    @DisplayName("Testing inheritance empty nutritionValue")
    public void testInheritanceEmptyNutritionalValue(){
        assertEquals(sdZN.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdZN.getVolume(), 0.125, 0.001);
    }

    /**
     * @author Dario Wagner
     * Method tests the inheritance, with an empty container set
     */
    @Test
    @DisplayName("Testing inheritance empty Container")
    public void testInheritanceEmptyContainer(){
        assertEquals(sdEC.getAlcoholPercent(), 0, 0.001);
        assertEquals(sdEC.getVolume(), 0.125, 0.001);
    }

    /**
     * @author Dario Wagner
     * Method tests the Color-Setter
     */
    @Test
    @DisplayName("Testing setter Color")
    public void testSetterColor(){
        sdN.setColor("Blau");
        assertEquals(sdN.getColor(), "Blau");
    }

    /**
     * @author Dario Wagner
     * Method tests the Container Setter
     */
    @Test
    @DisplayName("Testing setter Container")
    public void testSetterContainer(){
        Set<String> test = new HashSet<>();
        test.add("Dose");
        sdN.setContainer(test);
        assertEquals(sdN.getContainer(), test);
    }

    /**
     * @author Dario Wagner
     * Method tests the nutritionValue Setter
     */
    @Test
    @DisplayName("Testing setter nutritionalValue")
    public void testSetterNutritionalValue(){
        Map<String, Double> testNutritionalValue = new HashMap<>();
        testNutritionalValue.put("Fett", 0.5);
        sdN.setNutritionalValue(testNutritionalValue);
        assertEquals(sdN.getNutritionalValue(), testNutritionalValue);
    }

    /**
     * @author Dario Wagner
     * Method tests the nutritionValue Calculation
     */
    @Test
    @DisplayName("Testing nutritionValueTotal")
    public void testNutritionValueTotal() throws EmptyDrinkException {
        Map<String, Double> expectedValues = new HashMap<>();
        expectedValues.put("Fett", 0.);
        expectedValues.put("Eiweiß", 0.);
        expectedValues.put("Broteinheiten", 1.);
        expectedValues.put("Zucker", 11.25);
        assertEquals(sdN.nutritionValueTotal(), expectedValues);
    }

    /**
     * @author Dario Wagner
     * Method tests the nutritionValue Calculation with no volume
     * EmptyDrinkException is expected
     */
    @Test
    @DisplayName("Testing nutritionValueTotal with no volume")
    public void testNutritionValueTotalNoVolume(){
        Exception e = assertThrows(EmptyDrinkException.class, () -> {sdZV.nutritionValueTotal();});
        String actualMessage = e.getMessage();
        String expectedMessage = "It seems like your Drink is empty.";

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
