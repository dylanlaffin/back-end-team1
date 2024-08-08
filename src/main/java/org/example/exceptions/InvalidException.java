package org.example.exceptions;

public class InvalidException extends Exception {
    public InvalidException(final String message) {
        System.out.println(message);
    }
}
