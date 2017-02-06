import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by DenisShklyannik on 05.01.2017.
 */
public class SlowTests {

    @BeforeClass
    public static void beforeClass() {
        System.out.print("\nExecution was started for the Class #1");
    }

    @BeforeMethod
    public void BeforeTest() {
        System.out.print("\nTest was started");
    }

    @Test(priority = 1, groups = { "smoke", "fast" })
    public void testAdd() throws Exception {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.add(4,5);
        Assert.assertEquals(9, mathematics.getResult());

    }

    @Test(priority=1, timeOut = 1000, groups = {"fast"})
    public void testDeduct() throws Exception {
        Thread.sleep(500);
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(1);
        mathematics.deduct(7,5);
        Assert.assertEquals(2, mathematics.getResult());

    }

    @Test(priority=1, groups = {"fast"})
    public void testMultiply() throws Exception {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.multiply(4,5);
        Assert.assertEquals(20, mathematics.getResult());

    }

    @Test(priority=1, groups = {"fast"})
    public void testDivide() throws Exception {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.divide(10,2);
        Assert.assertEquals(5, mathematics.getResult());

    }

    @Test (priority=2, expectedExceptions = ArithmeticException.class, groups = {"fast"})
    public void divideExceptionTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.divide(10,0);

    }

    @DataProvider(name = "ParametrizedAddTest")
    public Object[][] provideDataAddTest() {
        return new Object[][] {
                { 10, 2 ,12 },
                { -4, 7, 3 },
                { 21, 7, 28 },
                { 30, 10 , 40},
                { 16, 4, 20 }
        };
    }

    @Test(dataProvider = "ParametrizedAddTest", dependsOnMethods = "testAdd" )
    public void ParametrizedAddTestChecker(int x, int y, int expected) {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.add(x,y);
        Assert.assertEquals(expected, mathematics.getResult());
    }

    @DataProvider(name = "ParametrizedDeductTest")
    public Object[][] provideDataDeductTest() {
        return new Object[][] {
                { 10, 2 , 8 },
                { 0, 7, -7 },
                { 21, 7, 14 },
                { 30, 10 , 20},
                { 16, 4, 12 }
        };
    }

    @Test(dataProvider = "ParametrizedDeductTest", dependsOnMethods = "testDeduct" )
    public void ParametrizedDeductTestChecker(int x, int y, int expected) {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(1);
        mathematics.deduct(x,y);
        Assert.assertEquals(expected, mathematics.getResult());
    }

    @DataProvider(name = "ParametrizedDivideTest")
    public Object[][] provideDataDivideTest() {
        return new Object[][] {
                { 10, 2 ,5 },
                { 2, 1, 2 },
                { 3, 3, 1 },
                { 15, 5 , 3},
                { 18, 2, 9 }
        };
    }

    @Test(dataProvider = "ParametrizedDivideTest", dependsOnMethods = "testDivide" )
    public void ParametrizedDivideTestChecker(int x, int y, int expected) {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.divide(x,y);
        Assert.assertEquals(expected, mathematics.getResult());
    }

    @DataProvider(name = "ParametrizedMultiplyTest")
    public Object[][] provideDataMultiplyTest() {
        return new Object[][] {
                { 10, 0 , 0 },
                { -4, 7, -28 },
                { 6, 7, 42 },
                { 30, 10 , 300},
                { 12, 5, 60 }
        };
    }

    @Test(dataProvider = "ParametrizedMultiplyTest", dependsOnMethods = "testMultiply" )
    public void ParametrizedMultiplyTestChecker(int x, int y, int expected) {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(0);
        mathematics.multiply(x,y);
        Assert.assertEquals(expected, mathematics.getResult());
    }


    @AfterMethod
    public void afterTest() {
        System.out.print("\nTest was finished");
    }

    @AfterClass
    public static void afterClass() {
        System.out.print("\nExecution was finished for the Class #1");
    }

}