package com.example.robotcleaner.domain.exception;

public class InvalidInstructionException extends RuntimeException {
    public InvalidInstructionException(String message) {
        super(message);
    }
}
