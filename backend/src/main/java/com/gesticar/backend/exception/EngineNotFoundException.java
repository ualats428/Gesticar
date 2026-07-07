package com.gesticar.backend.exception;

/**
 * Exception thrown when an engine cannot be found.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
public class EngineNotFoundException extends RuntimeException {

    public EngineNotFoundException(Long id) {
        super("Engine with id " + id + " not found.");
    }

}