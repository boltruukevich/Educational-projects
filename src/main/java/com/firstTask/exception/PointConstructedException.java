package com.firstTask.exception;

public class PointConstructedException extends RuntimeException{
    public PointConstructedException() {
    }

    public PointConstructedException(String mcg) {
        super(mcg);
    }

    public PointConstructedException(ExceptionMessages mcg) {
        super(mcg.getMessage());
    }
}
