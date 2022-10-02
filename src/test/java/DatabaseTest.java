import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {

    public Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsReturnPresetBuns() {
        List<Bun> expectedBuns = new ArrayList<>();
        expectedBuns.add(new Bun("black bun", 100));
        expectedBuns.add(new Bun("white bun", 200));
        expectedBuns.add(new Bun("red bun", 300));

        Assert.assertEquals("The bun list of the database isn't as expected",
                expectedBuns, database.availableBuns());
    }

    @Test
    public void availableIngredientsReturnPresetIngredients() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        Assert.assertEquals("The ingredients list of the database isn't as expected",
                expectedIngredients, database.availableIngredients());
    }
}