package com.firstTask.application;

import com.firstTask.action.calculating.AngleOfPlanesCalculator;
import com.firstTask.action.calculating.CalculatorPerpendicularityPlanesOfXYZ;
import com.firstTask.action.fileworking.FileExecutorsFactory;
import com.firstTask.action.fileworking.PlaneReader;
import com.firstTask.exception.ArgumentNullException;
import com.firstTask.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Application {
    private final static String COMMON_PERPENDICULAR_INFO_MCG = "\tPlane perpendicular with Y: {}";
    private final static Plane COMMON_PLANE_FOR_ANGLE_CALCULATE = AngleOfPlanesCalculator.OXY_PLANE;
    private final static String COMMON_ANGLE_INFO_MCG = "\tPlane angle with OXY: {}";

    private final static String PLANE_WAS_NOT_CREATED_MCG = "The plane was not created";
    private final static Logger LOG = LogManager.getLogger(Application.class);

    public static void findPlanesInFile(String filePath) throws IOException {
        LOG.trace("Program start");
        if (filePath == null) {
            ArgumentNullException ex = new ArgumentNullException();
            LOG.error(ex.getMessage(), ex);
            throw ex;
        }
        FileExecutorsFactory executorsFactory = FileExecutorsFactory.create();
        PlaneReader planeReader = executorsFactory.makeReader(filePath);
        Plane plane;
        AngleOfPlanesCalculator calculatorAngleOfPlanes = AngleOfPlanesCalculator.getInstance();
        CalculatorPerpendicularityPlanesOfXYZ
                calculatorPerpendicularityPlanesOfXYZ = CalculatorPerpendicularityPlanesOfXYZ.getInstance();
        while (planeReader.hasNextPlane()) {
            try {
                plane = planeReader.nextPlane();
                LOG.info(plane);
                LOG.info(COMMON_PERPENDICULAR_INFO_MCG,
                        calculatorPerpendicularityPlanesOfXYZ.isPerpendicularityY(plane));
                LOG.info(COMMON_ANGLE_INFO_MCG,
                        calculatorAngleOfPlanes.calculateAngleBetweenPlanes(plane, COMMON_PLANE_FOR_ANGLE_CALCULATE));

            } catch (Exception ex) {
                LOG.error(ex.getMessage(), ex);
                LOG.warn(PLANE_WAS_NOT_CREATED_MCG);
            }
        }
        LOG.trace("Program end");
    }
}

