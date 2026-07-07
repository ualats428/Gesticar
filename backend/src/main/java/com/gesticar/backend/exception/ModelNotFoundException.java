package com.gesticar.backend.exception;

/**
 * Exception thrown when a model cannot be found.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(Long id) {
        super("Model with id " + id + " not found.");
    }

}