import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class DatabaseBunsTest {

    public Database database;

    private final int index;
    private final String expectedName;
    private final float expectedPrice;

    public DatabaseBunsTest(int index, String name, float price) {
        this.index = index;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {0, "black bun", 100.0F},
                {1, "white bun", 200.0F},
                {2, "red bun", 300.0F}
        };
    }

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsReturnPresetBuns() {
        MatcherAssert.assertThat(database.availableBuns().get(index).getName(), equalTo(expectedName));
        MatcherAssert.assertThat(database.availableBuns().get(index).getPrice(), equalTo(expectedPrice));
    }
}