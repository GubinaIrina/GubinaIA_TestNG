package ru.lanit.framework.steps;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.Math;

public class MathTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Подготовка перед тестами");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Подчищаем после тестов");
    }

    @DataProvider
    public Object[][] testEqualsSum() {
        return new Object[][]{
                {4, 2, 2},
                {0, -1, 1},
                {8, 4, 4},
                {-1, 0, -1},
                {5, 2, 3}
        };
    }

    @Test(dataProvider = "testEqualsSum")
    public void testSum(int one, int two, int tree) {
        Assert.assertEquals(one, new  Math().sumTest(two, tree));
    }

    @DataProvider
    public Object[][] testEqualsSubtraction() {
        return new Object[][]{
                {2, 4, 2},
                {0, 1, 1},
                {4, 8, 4},
                {1, 0, -1},
                {9, 10, 1}
        };
    }

    @Test(dataProvider = "testEqualsSubtraction")
    public void testSubtraction(int one, int two, int tree) {
        Assert.assertEquals(one, new  Math().subtractionTest(two, tree));
    }

    @DataProvider
    public Object[][] testEqualsMultiplication() {
        return new Object[][]{
                {4, 2, 2},
                {0, 0, 1},
                {16, 4, 4},
                {6, 2, 3}
        };
    }

    @Test(dataProvider = "testEqualsMultiplication")
    public void testMultiplication(int one, int two, int tree) {
        Assert.assertEquals(one, new  Math().multiplicationTest(two, tree));
    }

    @DataProvider
    public Object[][] testEqualsDivision() {
        return new Object[][]{
                {2, 4, 2},
                {1, 1, 1},
                {0, 0, 4},
                {5, 10, 2},
                {-1, 1, -1}
        };
    }

    @Test(dataProvider = "testEqualsDivision")
    public void testDivision(int one, int two, int tree) {
        Assert.assertEquals(one, new  Math().divisionTest(two, tree));
    }

    @DataProvider(parallel = true)
    public Object[][] testEqualsNegative() {
        return new Object[][]{
                {5, 2, 2},
                {1, -1, 1},
                {100, 4, 4},
                {7, 0, -1},
                {3, 2, 3}
        };
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsNegativeSum(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().sumTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsNegativeSubtraction(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().subtractionTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsNegativeMultiplication(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().multiplicationTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsNegativeDivision(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().divisionTest(two, tree), "Значения не равны!");
    }

    @DataProvider
    public Object[][] testObject() {
        return new Object[][]{
                {"five", 2, 2},
                {1, -1, "one"},
                {100, "four", 4},
                {"seven", "0", -1},
                {3, null, 3}
        };
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class,
            AssertionError.class})
    public void testNegativeObjectSum(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().sumTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class,
            AssertionError.class})
    public void testNegativeObjectSubtraction(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().subtractionTest(two, tree));
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class,
            AssertionError.class})
    public void testNegativeObjectDivision(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().divisionTest(two, tree));
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class,
            AssertionError.class})
    public void testNegativeObjectMultiplication(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().multiplicationTest(two, tree));
    }
}
