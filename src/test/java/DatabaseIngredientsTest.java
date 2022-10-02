import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class DatabaseIngredientsTest {

    public Database database;

    private final int index;
    private final IngredientType expectedIngredientType;
    private final String expectedName;
    private final float expectedPrice;

    public DatabaseIngredientsTest(int index, IngredientType ingredientType, String name, float price) {
        this.index = index;
        this.expectedIngredientType = ingredientType;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {0, IngredientType.SAUCE, "hot sauce", 100.0F},
                {1, IngredientType.SAUCE, "sour cream", 200.0F},
                {2, IngredientType.SAUCE, "chili sauce", 300.0F},
                {3, IngredientType.FILLING, "cutlet", 100.0F},
                {4, IngredientType.FILLING, "dinosaur", 200.0F},
                {5, IngredientType.FILLING, "sausage", 300.0F}
        };
    }

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableIngredientsReturnPresetIngredients() {
        MatcherAssert.assertThat(database.availableIngredients().get(index).getName(), equalTo(expectedName));
        MatcherAssert.assertThat(database.availableIngredients().get(index).getPrice(), equalTo(expectedPrice));
        MatcherAssert.assertThat(database.availableIngredients().get(index).getType(), equalTo(expectedIngredientType));

    }
}