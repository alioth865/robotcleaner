package com.example.robotcleaner.domain.exception;

public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(int invalidX, int invalidY, String reason) {
        super(createErrorMessage(invalidX, invalidY, reason));
    }

    private static String createErrorMessage(int invalidX, int invalidY, String reason) {
        return String.format("Current position is invalid [%d] [%d]: [%s]", invalidX, invalidY, reason);
    }
}
