package com.firstTask.action.calculating;

import com.firstTask.exception.ArgumentNullException;
import com.firstTask.model.Plane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorPerpendicularityPlanesOfXYZTest {

    private final CalculatorPerpendicularityPlanesOfXYZ perpendicularityCalculator =
            CalculatorPerpendicularityPlanesOfXYZ.getInstance();

    @DataProvider
    public Object[][] perpendicularOxyData() {
        return new Object[][]{
                {Plane.of(0, 0, 1, 0), false},
                {Plane.of(1, 0, 0, 1), true},
                {Plane.of(0, 1, 0, 1), true},
                {Plane.of(1, 2, 3, 1), false}
        };
    }

    @Test(dataProvider = "perpendicularOxyData")
    public void testIsPlanePerpendicularOxy(Plane plane, boolean answer) {
        Assert.assertEquals(perpendicularityCalculator.isPerpendicularityX(plane), answer);
    }

    @Test(expectedExceptions = ArgumentNullException.class)
    public void testNullArgumentOxy() {
        perpendicularityCalculator.isPerpendicularityX(null);
    }


    @DataProvider
    public Object[][] perpendicularOxzData() {
        return new Object[][]{
                {Plane.of(0, 0, 1, 0), true},
                {Plane.of(1, 0, 0, 1), true},
                {Plane.of(0, 1, 0, 1), false},
                {Plane.of(1, 2, 3, 1), false}
        };
    }

    @Test(dataProvider = "perpendicularOxzData")
    public void testIsPlanePerpendicularOxz(Plane plane, boolean answer) {
        Assert.assertEquals(perpendicularityCalculator.isPerpendicularityY(plane), answer);
    }

    @Test(expectedExceptions = ArgumentNullException.class)
    public void testNullArgumentOxz() {
        perpendicularityCalculator.isPerpendicularityY(null);
    }


    @DataProvider
    public Object[][] perpendicularOyzData() {
        return new Object[][]{
                {Plane.of(0, 0, 1, 0), true},
                {Plane.of(1, 0, 0, 1), false},
                {Plane.of(0, 1, 0, 1), true},
                {Plane.of(1, 2, 3, 1), false}
        };
    }

    @Test(dataProvider = "perpendicularOyzData")
    public void testIsPlanePerpendicularOyz(Plane plane, boolean answer) {
        Assert.assertEquals(perpendicularityCalculator.isPerpendicularityZ(plane), answer);
    }

    @Test(expectedExceptions = ArgumentNullException.class)
    public void testNullArgumentOyz() {
        perpendicularityCalculator.isPerpendicularityZ(null);
    }
}