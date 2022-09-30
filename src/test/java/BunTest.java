import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import java.util.Random;

public class BunTest {

    String expectedName;
    float expectedPrice;
    Bun bun;

    @Before
    public void createBun() {
        Random random = new Random();
        expectedName = "bun name" + random.nextInt();
        expectedPrice = random.nextFloat();
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void getNameReturnString() {
        Assert.assertEquals("Actual bun name doesn't match the expected name", expectedName, bun.getName());
    }

    @Test
    public void getPriceReturnFloat() {
        Assert.assertEquals("Actual bun price doesn't match the expected price", expectedPrice, bun.getPrice());
    }
}
