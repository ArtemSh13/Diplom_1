import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

public class IngredientTest {

    IngredientType expectedIngredientType;
    String expectedName;
    float expectedPrice;
    Ingredient ingredient;

    @Before
    public void createIngredient() {
        Random random = new Random();
        IngredientType[] ingredientTypes = new IngredientType[]{IngredientType.FILLING, IngredientType.SAUCE};
        expectedIngredientType = ingredientTypes[random.nextInt(ingredientTypes.length)];
        expectedName = "name" + random.nextInt();
        expectedPrice = random.nextFloat();
        ingredient = new Ingredient(expectedIngredientType, expectedName, expectedPrice);
    }

    @Test
    public void getPriceReturnFloat() {
        Assert.assertEquals("Actual ingredient price doesn't match the expected price", expectedPrice,
                ingredient.getPrice(), 0.001);
    }

    @Test
    public void getNameReturnString() {
        Assert.assertEquals("Actual ingredient name doesn't match the expected name", expectedName,
                ingredient.getName());
    }

    @Test
    public void getIngredientTypeReturnType() {
        Assert.assertEquals("Actual IngredientType doesn't match the expected IngredientType",
                expectedIngredientType, ingredient.getType());
    }
}
