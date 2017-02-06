import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by DenisShklyannik on 25.01.2017.
 */
public class ParametrizedTest {

    @Test(priority = 1, groups = { "fast" })
    @Parameters({"x", "y", "expected"})
    public void ParametrizedMultiplyTestChecker(int x, int y, int expected) {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.multiply(x,y);
        Assert.assertEquals(expected, mathematics.getResult());
    }

}


