package com.gesticar.backend.exception;

import com.gesticar.backend.dto.error.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Global exception handler for REST controllers.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleBrandNotFound(
            BrandNotFoundException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleBrandAlreadyExists(
            BrandAlreadyExistsException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleModelNotFound(
            ModelNotFoundException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleModelAlreadyExists(
            ModelAlreadyExistsException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EngineNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleEngineNotFound(
            EngineNotFoundException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EngineAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleEngineAlreadyExists(
            EngineAlreadyExistsException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
    }

    /**
     * Builds a standardized error response.
     */
    private ResponseEntity<ErrorResponseDTO> buildErrorResponse(
            RuntimeException ex,
            HttpServletRequest request,
            HttpStatus status) {

        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

}