package com.firstTask.action.calculating;

import com.firstTask.exception.ArgumentNullException;
import com.firstTask.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AngleOfPlanesCalculator {

    public final static Plane OXY_PLANE = Plane.of(0, 0, 1, 0);
    public final static Plane OXZ_PLANE = Plane.of(0, 1, 0, 0);
    public final static Plane OYZ_PLANE = Plane.of(1, 0, 0, 0);

    private final static Logger LOG = LogManager.getLogger(AngleOfPlanesCalculator.class);

    private static AngleOfPlanesCalculator instance;

    private AngleOfPlanesCalculator() {
    }

    public static AngleOfPlanesCalculator getInstance() {
        if (instance == null) {
            instance = new AngleOfPlanesCalculator();
        }
        return instance;
    }

    public Double calculateAngleBetweenPlanes(Plane planeA, Plane planeB) {
        if (planeA == null || planeB == null) {
            ArgumentNullException ex = new ArgumentNullException();
            LOG.error(ex.getMessage(), ex);
            throw ex;
        }
        //Formula(A, B, C - coefficients): cos α = (|A1·A2 + B1·B2 + C1·C2|)/(√(A1^2 + B1^2 + C1^2)*(A2^2 + B2^2 + C2^2))
        Double dividend = planeA.getcoeffA()*planeB.getcoeffB()+planeA.getcoeffB()*planeB.getcoeffB()+
                planeA.getcoeffC()*planeB.getcoeffC();
        Double divider = Math.sqrt(planeA.getcoeffA()+planeA.getcoeffB()+planeA.getcoeffC())*
                Math.sqrt(planeB.getcoeffA()+planeB.getcoeffB()+planeB.getcoeffC());
        double angle = Math.cos(dividend/divider);
        return angle;
    }
}