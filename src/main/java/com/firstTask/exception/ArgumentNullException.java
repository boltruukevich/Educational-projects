package com.firstTask.exception;

public class ArgumentNullException extends RuntimeException {
    public ArgumentNullException() {
        super(ExceptionMessages.ARGUMENT_IS_NULL_MCG.getMessage());
    }

    public ArgumentNullException(String mcg) {
        super(mcg + "; " + ExceptionMessages.ARGUMENT_IS_NULL_MCG.getMessage());
    }
}
