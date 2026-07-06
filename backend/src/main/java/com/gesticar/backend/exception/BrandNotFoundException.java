package com.gesticar.backend.exception;

public class BrandNotFoundException extends RuntimeException{

    public BrandNotFoundException(Long id) {
        super("Brand with id " + id + " not found.");
    }

}
