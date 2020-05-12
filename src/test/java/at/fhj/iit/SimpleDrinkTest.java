package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing SimpleDrink implementation")
public class SimpleDrinkTest {
    private SimpleDrink lN, lA;

    /**
     * inits a simple drink based on water and a simple drink based on beer.
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        lN = new SimpleDrink("Römerquelle", new Liquid("Wasser", 0.7, 0));
        lA = new SimpleDrink("Puntigamer", new Liquid("Bier", 0.5, 5));
    }

    @Test
    @DisplayName("Testing constructor non alcoholic (water based)")
    public void testConstructorNonAlcoholic(){
        assertEquals(lN.getVolume(), 0.7, 0.001);
        assertEquals(lN.getAlcoholPercent(), 0, 0.001);
        assertEquals(lN.isAlcoholic(), false);
    }
    @Test
    @DisplayName("Testing constructor alcoholic (beer based)")
    public void testConstructorAlcoholic(){
        assertEquals(lA.getVolume(), 0.5, 0.001);
        assertEquals(lA.getAlcoholPercent(), 5, 0.001);
        assertEquals(lA.isAlcoholic(), true);
    }


}
