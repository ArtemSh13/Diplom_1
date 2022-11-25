import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private static final String ONE_CHAR_STR = "x";
    private static final String USUAL_STR = "myFavoriteBun";
    private static final String MAX_STR = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String ALPHA_NUM_SPECIALS_STR = "qWeRtY0987654321+_)(*&^%$#@!";
    private static final String SPACE_STR = "My Favorite Bun";

    private static final int POSITIVE_NUM = 12345;
    private static final int NEGATIVE_NUM = -54321;
    private static final int MIN_NEGATIVE_NUM = -999999999;
    private static final int MAX_POSITIVE_NUM = 999999999;
    private static final float POSITIVE_DOUBLE_NUM = 123.456f;
    private static final float NEGATIVE_DOUBLE_NUM = -654.321f;

    private final String expectedName;
    private final float expectedPrice;
    Bun bun;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        System.out.println("expectedName = " + expectedName);
        this.expectedPrice = expectedPrice;
        System.out.println("expectedPrice = " + expectedPrice);
    }

    @Parameterized.Parameters
    public static Object[][] getTestNameAndPrice() {
        return new Object[][] {
                {null, POSITIVE_NUM},
                {null, NEGATIVE_NUM},
                {null, MIN_NEGATIVE_NUM},
                {null, MAX_POSITIVE_NUM},
                {null, POSITIVE_DOUBLE_NUM},
                {null, NEGATIVE_DOUBLE_NUM},
                {null, 0},
                {null, 1},
                {"", NEGATIVE_NUM},
                {"", MIN_NEGATIVE_NUM},
                {"", MAX_POSITIVE_NUM},
                {"", POSITIVE_DOUBLE_NUM},
                {"", NEGATIVE_DOUBLE_NUM},
                {"", 0},
                {"", 1},
                {"", POSITIVE_NUM},
                {ONE_CHAR_STR, MIN_NEGATIVE_NUM},
                {ONE_CHAR_STR, MAX_POSITIVE_NUM},
                {ONE_CHAR_STR, POSITIVE_DOUBLE_NUM},
                {ONE_CHAR_STR, NEGATIVE_DOUBLE_NUM},
                {ONE_CHAR_STR, 0},
                {ONE_CHAR_STR, 1},
                {ONE_CHAR_STR, POSITIVE_NUM},
                {ONE_CHAR_STR, NEGATIVE_NUM},
                {USUAL_STR, MAX_POSITIVE_NUM},
                {USUAL_STR, POSITIVE_DOUBLE_NUM},
                {USUAL_STR, NEGATIVE_DOUBLE_NUM},
                {USUAL_STR, 0},
                {USUAL_STR, 1},
                {USUAL_STR, POSITIVE_NUM},
                {USUAL_STR, NEGATIVE_NUM},
                {USUAL_STR, MIN_NEGATIVE_NUM},
                {MAX_STR, POSITIVE_DOUBLE_NUM},
                {MAX_STR, NEGATIVE_DOUBLE_NUM},
                {MAX_STR, 0},
                {MAX_STR, 1},
                {MAX_STR, POSITIVE_NUM},
                {MAX_STR, NEGATIVE_NUM},
                {MAX_STR, MIN_NEGATIVE_NUM},
                {MAX_STR, MAX_POSITIVE_NUM},
                {ALPHA_NUM_SPECIALS_STR, NEGATIVE_DOUBLE_NUM},
                {ALPHA_NUM_SPECIALS_STR, 0},
                {ALPHA_NUM_SPECIALS_STR, 1},
                {ALPHA_NUM_SPECIALS_STR, POSITIVE_NUM},
                {ALPHA_NUM_SPECIALS_STR, NEGATIVE_NUM},
                {ALPHA_NUM_SPECIALS_STR, MIN_NEGATIVE_NUM},
                {ALPHA_NUM_SPECIALS_STR, MAX_POSITIVE_NUM},
                {ALPHA_NUM_SPECIALS_STR, POSITIVE_DOUBLE_NUM},
                {SPACE_STR, 0},
                {SPACE_STR, 1},
                {SPACE_STR, POSITIVE_NUM},
                {SPACE_STR, NEGATIVE_NUM},
                {SPACE_STR, MIN_NEGATIVE_NUM},
                {SPACE_STR, MAX_POSITIVE_NUM},
                {SPACE_STR, POSITIVE_DOUBLE_NUM},
                {SPACE_STR, NEGATIVE_DOUBLE_NUM}
        };
    }

    @Before
    public void createBun() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void getNameReturnString() {
        Assert.assertEquals("Actual bun name doesn't match the expected name", expectedName, bun.getName());
        System.out.println("Expected result: " + expectedName + "\nActual result: " + bun.getName());
    }

    @Test
    public void getPriceReturnFloat() {
        Assert.assertEquals("Actual bun price doesn't match the expected price", expectedPrice, bun.getPrice(),
                0.001);
        System.out.println("Expected result: " + expectedPrice + "\nActual result: " + bun.getPrice());
    }
}
