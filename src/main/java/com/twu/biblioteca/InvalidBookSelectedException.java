package com.twu.biblioteca;

public class InvalidBookSelectedException extends Exception {
    public InvalidBookSelectedException() {
        super("Invalid Book");
    }
}
