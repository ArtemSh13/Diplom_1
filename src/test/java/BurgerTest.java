import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public final static int INGREDIENTS_NUMBER = 10;
    public Burger burger;
    public String name;
    public float price;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        Random random = new Random();
        name = "name" + random.nextInt();
        price = random.nextFloat();
        burger = new Burger();
    }

    ArrayList<Ingredient> createRandomIngredients() {
        Random random = new Random();
        // there will always be at least two ingredients on the ingredient list
        int ingredientsNumber = random.nextInt(INGREDIENTS_NUMBER - 1) + 2;
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsNumber; i++) {
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    @Test
    public void setBunsSameObjects() {
        burger.setBuns(bun);
        Assert.assertEquals("In-class \"Bun\" object isn't equal the input object", bun, burger.bun);
    }

    @Test
    public void addIngredientAddedObject() {
        burger.addIngredient(ingredient);
        Assert.assertEquals("The last burger ingredient isn't equal the added ingredient",
                ingredient, burger.ingredients.get(burger.ingredients.size() - 1));
    }

    @Test
    public void removeIngredientMissingObject() {
        burger.ingredients.add(ingredient);

        burger.removeIngredient(burger.ingredients.size() - 1);
        Assert.assertFalse("Burger ingredients still contain removed object",
                burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient() {
        Random random = new Random();
        ArrayList<Ingredient> expectedIngredients = createRandomIngredients();
        int oldIndex = 0;
        int newIndex = random.nextInt(expectedIngredients.size());

        burger.ingredients = new ArrayList<>(expectedIngredients);

        expectedIngredients.add(newIndex, expectedIngredients.remove(oldIndex));
        burger.moveIngredient(oldIndex, newIndex);

        Assert.assertEquals("The changed ingredients list isn't as expected",
                expectedIngredients, burger.ingredients);
    }

    @Test
    public void getPriceReturnPrecalculated() {
        float totalPrice = 0;
        Mockito.when(bun.getPrice()).thenReturn(price);
        // A burger needs 2 buns
        totalPrice += price * 2;

        ArrayList<Ingredient> ingredients = createRandomIngredients();
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        for (Ingredient ingredient : ingredients) {
            totalPrice += ingredient.getPrice();
        }

        burger.bun = bun;
        burger.ingredients = ingredients;
        Assert.assertEquals("Returned price isn't correct", totalPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptReturnString() {
        Mockito.when(bun.getName()).thenReturn(name);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getName()).thenReturn(name);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Random random = new Random();
        IngredientType[] ingredientTypes = new IngredientType[] {IngredientType.FILLING, IngredientType.SAUCE};
        Mockito.when(ingredient.getType()).thenReturn(ingredientTypes[random.nextInt(ingredientTypes.length)]);
        burger.bun = bun;
        ArrayList<Ingredient> ingredients = createRandomIngredients();
        burger.ingredients = ingredients;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals("Burger generated receipt isn't as expected",
                receipt.toString(), burger.getReceipt());
    }

}