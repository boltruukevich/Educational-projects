package com.firstTask.exception;

public class RunOutOfPlanesException extends RuntimeException{ public RunOutOfPlanesException() {
}

    public RunOutOfPlanesException(ExceptionMessages mcg) {
        super(mcg.getMessage());
    }
}
