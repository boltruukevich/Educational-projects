package com.firstTask.action.calculating;

import com.firstTask.exception.ArgumentNullException;
import com.firstTask.model.Plane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AngleOfPlaneCalculatorTest {

    private final AngleOfPlanesCalculator angleOfPlanesCalculator = AngleOfPlanesCalculator.getInstance();

    @DataProvider
    public Object[][] calculateAngleBetweenPlanesData() {
        return new Object[][]{
                {Plane.of(1, 1, 1, 0),
                        Plane.of(2, 2, 2, 0)},
                {Plane.of(0, 2, 1, 2),
                        Plane.of(22, 21, -8, 0)},
        };
    }

    @Test(dataProvider = "calculateAngleBetweenPlanesData")
    public void testCalculateAngleBetweenPlanes(Plane plane1, Plane plane2, Double angle) {
        Assert.assertEquals(angleOfPlanesCalculator.calculateAngleBetweenPlanes(plane1, plane2), angle);
    }

    @Test(expectedExceptions = ArgumentNullException.class)
    public void testNullArguments() {
        angleOfPlanesCalculator.calculateAngleBetweenPlanes(null, null);
    }
}