package com.firstTask.action;

import com.firstTask.exception.ExceptionMessages;
import com.firstTask.exception.PlaneConstructedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaneValidator {
    private final static Logger LOG = LogManager.getLogger(PlaneValidator.class);
    private static PlaneValidator instance;

    private PlaneValidator(){

    }

    public static PlaneValidator getInstance(){
        if(instance == null){
            instance = new PlaneValidator();
        }
        return instance;
    }
    public void checkCoefficients(Double coeffA, Double coeffB, Double coeffC, Double coeffD ) {
        if (coeffA == null || coeffB == null || coeffC == null || coeffD == null) {
            LOG.error(ExceptionMessages.ARGUMENT_IS_NULL_MCG.getMessage());
            throw  new PlaneConstructedException(ExceptionMessages.ARGUMENT_IS_NULL_MCG);
        }
        if (coeffA.compareTo(coeffB) == 0 && coeffA.compareTo(coeffC) == 0) {
            LOG.error(ExceptionMessages.ALL_COEFFICIENTS_ARE_ZERO_MCG.getMessage());
            throw new PlaneConstructedException(ExceptionMessages.ALL_COEFFICIENTS_ARE_ZERO_MCG);
        }
    }
}
