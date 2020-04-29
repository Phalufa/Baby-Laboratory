package com.miko.babylab.services.exceptions;

public class BabyDoesntExistsException extends RuntimeException {

    public BabyDoesntExistsException() {
        super("Baby Does Not Exists");
    }
}
