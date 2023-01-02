package com.firstTask.action;

import com.firstTask.exception.PlaneConstructedException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class PlaneValidatorTest {

    private final PlaneValidator planeValidator = PlaneValidator.getInstance();

    @DataProvider
    public Object[][] constructedExceptionData() {
        return new Object[][]{
                {null, null, null, null}
        };
    }

    @Test(expectedExceptions = PlaneConstructedException.class, dataProvider = "constructedExceptionData")
    public void testCheckCoefficients(Double cA, Double cB, Double cC, Double freeTerm) {
        planeValidator.checkCoefficients(cA, cB, cC, freeTerm);
    }

}