package com.miko.babylab.services.exceptions;

public class BabyAlreadyExistsException extends RuntimeException {

    public BabyAlreadyExistsException() {
        super("Baby Already Exists");
    }


}
