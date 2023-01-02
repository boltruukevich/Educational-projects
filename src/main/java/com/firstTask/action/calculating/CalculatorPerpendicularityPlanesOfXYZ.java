package com.firstTask.action.calculating;

import com.firstTask.exception.ArgumentNullException;
import com.firstTask.model.Plane;
import org.firstTask.logging.log4j.LogManager;
import org.firstTask.logging.log4j.Logger;

public class CalculatorPerpendicularityPlanesOfXYZ {
    private final static Logger LOG = LogManager.getLogger(CalculatorPerpendicularityPlanesOfXYZ.class);
    private static CalculatorPerpendicularityPlanesOfXYZ instance;

    private CalculatorPerpendicularityPlanesOfXYZ() {
    }

    public static CalculatorPerpendicularityPlanesOfXYZ getInstance() {
        if (instance == null) {
            instance = new CalculatorPerpendicularityPlanesOfXYZ();
        }
        return instance;
    }

    public boolean isPerpendicularityX(Plane plane){
        checkPlaneNotNull(plane);
        return ParrallelnYZ(plane);
    }
    public boolean isPerpendicularityY(Plane plane){
        checkPlaneNotNull(plane);
        return ParrallelnXZ(plane);
    }
    public boolean isPerpendicularityZ(Plane plane){
        checkPlaneNotNull(plane);
        return ParrallelnXY(plane);
    }

    private void checkPlaneNotNull(Plane plane){
        if(plane == null){
            ArgumentNullException ex = new ArgumentNullException();
            LOG.error(ex.getMessage(),ex);
            throw ex;
        }
    }
    private boolean ParrallelnYZ(Plane plane){
        return plane.getcoeffA() == 0;
    }

    private boolean ParrallelnXZ(Plane plane){
        return plane.getcoeffB() == 0;
    }

    private boolean ParrallelnXY(Plane plane){
        return plane.getcoeffC() == 0;
    }
}
