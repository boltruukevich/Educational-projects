package com.firstTask.exception;

public class PlaneConstructedException extends RuntimeException{
    public PlaneConstructedException() {
    }

    public PlaneConstructedException(String mcg) {
        super(mcg);
    }

    public PlaneConstructedException(ExceptionMessages mcg) {
        super(mcg.getMessage());
    }
}
