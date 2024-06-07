import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private String expectedName;
    private float expectedPrice;
    private Ingredient ingredient;


    @Before
    public void setUp() {
        expectedName = "Бальзамик";
        expectedPrice = 7.7f;
        ingredient = new Ingredient(IngredientType.FILLING, expectedName, expectedPrice);
    }
    @Test
    public void testConstructor() {
        String constructorExpectedName = "Бальзамик";
        float constructorExpectedPrice = 7.7f;
        Ingredient constructorIngredient = new Ingredient(IngredientType.FILLING, expectedName, expectedPrice);
        assertEquals(constructorExpectedName, constructorIngredient.getName());
        assertEquals(constructorExpectedPrice, constructorIngredient.getPrice(), 0.0001);
    }
    @Test
    public void testGetName() {
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    public void testGetPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0001);
    }
    @Test
    public void testGetType() {
        IngredientType expectedType = IngredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }
}
