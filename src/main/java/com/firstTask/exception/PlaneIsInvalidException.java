package com.firstTask.exception;

public class PlaneIsInvalidException extends RuntimeException {
    public PlaneIsInvalidException() {
    }

    public PlaneIsInvalidException(String mcg) {
        super(mcg);
    }

    public PlaneIsInvalidException(ExceptionMessages mcg) {
        super(mcg.getMessage());
    }
}
