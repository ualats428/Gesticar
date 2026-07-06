package com.gesticar.backend.exception;

public class BrandAlreadyExistsException extends RuntimeException {

    public BrandAlreadyExistsException(String name) {
        super("Brand '" + name + "' already exists.");
    }

}
