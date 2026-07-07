package com.gesticar.backend.exception;

public class ModelAlreadyExistsException extends RuntimeException {
    public ModelAlreadyExistsException(String modelName, String brandName) {
        super("Model '" + modelName + "' already exists for brand '" + brandName + "'.");
    }
}
