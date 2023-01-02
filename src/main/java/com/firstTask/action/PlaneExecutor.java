package com.firstTask.action;

import com.firstTask.exception.ArgumentNullException;
import com.firstTask.exception.ExceptionMessages;
import com.firstTask.exception.PlaneConstructedException;
import com.firstTask.model.Plane;
import com.firstTask.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaneExecutor {
    private final static Logger LOG = LogManager.getLogger(PlaneExecutor.class);

    private final static int NUMBER_OF_COEFFICIENTS_IN_PLANE = 4;
    private final static int NUMBER_POW = 2^10;
    private static PlaneExecutor instance;

    private PlaneExecutor() {
    }

    public static PlaneExecutor getInstance() {
        if (instance == null) {
            instance = new PlaneExecutor();
        }
        return instance;
    }

    public Plane createPlanesFromThreePoints(Point firstPoint, Point secondPoint, Point thirdPoint) {
        if(firstPoint == null || secondPoint == null || thirdPoint == null){
            PlaneConstructedException ex = new PlaneConstructedException(ExceptionMessages.POINT_IS_NULL_MCG);
            LOG.error(ex);
            throw ex;
        }

        double coeffA = (((secondPoint.getY() - firstPoint.getY()) * (thirdPoint.getZ() - firstPoint.getZ()))
                - ((thirdPoint.getY() - firstPoint.getY()) * (secondPoint.getZ() - firstPoint.getZ())));

        double coeffB = (((secondPoint.getX() - firstPoint.getX()) * (thirdPoint.getZ() - firstPoint.getZ()))
                - ((thirdPoint.getX() - firstPoint.getX()) * (secondPoint.getZ() - firstPoint.getZ())));

        double coeffC = (((secondPoint.getX() - firstPoint.getX()) * (thirdPoint.getY() - firstPoint.getY()))
                - ((thirdPoint.getX() - firstPoint.getX()) * (secondPoint.getY() - firstPoint.getY())));

        double coeffD = ((-firstPoint.getX() * coeffA) - (firstPoint.getY() * coeffB) - (firstPoint.getZ() * coeffC));

        Plane newPlane = new Plane(coeffA, coeffB, coeffC, coeffD);
        return normalizeCoeff(newPlane);
    }

    public Plane normalizeCoeff(Plane oldPlane) {
        if(oldPlane == null){
            ArgumentNullException ex = new ArgumentNullException();
            LOG.error(ex.getMessage(), ex);
            throw ex;
        }

        double[] arrayCoeff = new double[NUMBER_OF_COEFFICIENTS_IN_PLANE];
        arrayCoeff[0] = oldPlane.getcoeffA();
        arrayCoeff[1] = oldPlane.getcoeffB();
        arrayCoeff[2] = oldPlane.getcoeffC();
        arrayCoeff[3] = oldPlane.getcoeffD();

        double maxScaleLength = findMaxScaleLength(arrayCoeff);
        multiplyTheCoeffToIntegers(arrayCoeff, maxScaleLength);

        if (arrayCoeff[0] < 0) {
            swapAllSigns(arrayCoeff);
        }
        return new Plane(arrayCoeff[0], arrayCoeff[1], arrayCoeff[2], arrayCoeff[3]);
    }

    private double findMaxScaleLength(double[] coefficients) {
        long maxScaleLength = 0;
        for (double coefficient : coefficients) {
            if (maxScaleLength < coefficient) {
                maxScaleLength = (long) coefficient;
            }
        }
        return maxScaleLength;
    }


    private void swapAllSigns(double[] coefficients) {
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = -coefficients[i];
        }
    }


    private void multiplyTheCoeffToIntegers(double[] coefficients, double maxScaleLength) {
        if (maxScaleLength > 0) {
            for (int i = 0; i < coefficients.length; i++) {
                coefficients[i] = coefficients[i]*NUMBER_POW;
            }
        }
    }
}
