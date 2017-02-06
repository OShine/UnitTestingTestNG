import org.testng.Assert;
import org.testng.annotations.Test;

public class DataFromFile {

    @Test(dataProvider = "DataFromFileDeductTest" )
    public void ParametrizedDeductTestChecker(int x, int y, int expected) {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(1);
        mathematics.deduct(x,y);
        Assert.assertEquals(expected, mathematics.getResult());
    }


}

