import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @InjectMocks
    private Burger burger;

    @Before
    public void setUp() {
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockBun.getPrice()).thenReturn(1.5f);

        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.5f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getName()).thenReturn("Tomato");
        when(mockIngredient2.getPrice()).thenReturn(0.7f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        // Act
        burger.setBuns(mockBun);

        // Assert
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        // Act
        burger.addIngredient(mockIngredient1);

        // Assert
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        // Arrange
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        burger.removeIngredient(0);

        // Assert
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        // Arrange
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        burger.moveIngredient(0, 1);

        // Assert
        assertEquals(2, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        // Arrange
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        float price = burger.getPrice();

        // Assert
        assertEquals(4.2f, price, 0.0001);
    }

    @Test
    public void testGetReceipt() {
        // Arrange
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        String receipt = burger.getReceipt();

        // Assert
        String expectedReceipt = "(==== Sesame Bun ====)\r\n" +
                "= filling Lettuce =\r\n" +
                "= filling Tomato =\r\n" +
                "(==== Sesame Bun ====)\r\n\r" +
                "\nPrice: 4,200000\r\n";
        assertEquals(expectedReceipt, receipt);
    }
}
