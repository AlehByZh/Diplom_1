import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private String expectedName;
    private float expectedPrice;
    private Bun bun;

    @Before
    public void setUp() {
        expectedName = "Шашлык";
        expectedPrice = 9.99f;
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testBunConstructorAndGetters() {
        String constructorExpectedName = "Пирожочек";
        float constructorExpectedPrice = 7.99f;
        Bun constructorBun = new Bun(constructorExpectedName, constructorExpectedPrice);
        assertEquals(constructorExpectedName, constructorBun.getName());
        assertEquals(constructorExpectedPrice, constructorBun.getPrice(), 0.0001);
    }

    @Test
    public void testGetName() {
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0001);
    }
}