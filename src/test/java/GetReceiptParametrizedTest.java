import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class GetReceiptParametrizedTest {

    private Bun bun;
    private List<Ingredient> ingredients;
    private String expectedReceipt;

    public GetReceiptParametrizedTest(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn("Мягкая булочка");
        when(bun.getPrice()).thenReturn(1.5f);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getName()).thenReturn("Сырный");
        when(ingredient1.getPrice()).thenReturn(0.5f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getName()).thenReturn("Салатик");
        when(ingredient2.getPrice()).thenReturn(0.7f);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        return Arrays.asList(new Object[][] {
                { bun, Arrays.asList(ingredient1),
                        "(==== Мягкая булочка ====)\r\n= filling Сырный =\r\n(==== Мягкая булочка ====)\r\n\r\nPrice: 3,500000\r\n" },
                { bun, Arrays.asList(ingredient1, ingredient2),
                        "(==== Мягкая булочка ====)\r\n= filling Сырный =\r\n= filling Салатик =\r\n(==== Мягкая булочка ====)\r\n\r\nPrice: 4,200000\r\n" }
        });
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }
}
