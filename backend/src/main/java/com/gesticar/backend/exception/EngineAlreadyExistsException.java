package com.gesticar.backend.exception;

/**
 * Exception thrown when trying to create an engine that already exists for the same model.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
public class EngineAlreadyExistsException extends RuntimeException {

    public EngineAlreadyExistsException(String name) {
        super("Engine '" + name + "' already exists for this model.");
    }

}