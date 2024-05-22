import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        IngredientType[] expectedValues = {IngredientType.SAUCE, IngredientType.FILLING};
        IngredientType[] actualValues = IngredientType.values();
        assertEquals(expectedValues.length, actualValues.length);
        for (IngredientType value : expectedValues) {
            assertTrue(containsValue(actualValues, value));
        }
    }

    @Test
    public void testEnumValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    private boolean containsValue(IngredientType[] values, IngredientType value) {
        for (IngredientType v : values) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }
}
