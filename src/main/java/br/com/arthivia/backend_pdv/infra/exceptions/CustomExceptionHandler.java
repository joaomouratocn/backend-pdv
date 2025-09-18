package br.com.arthivia.backend_pdv.infra.exceptions;

import br.com.arthivia.backend_pdv.infra.exceptions.customs.ExistProductIdException;
import br.com.arthivia.backend_pdv.infra.exceptions.customs.NotProductFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {
    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message){
        var errorResponse = new ErrorResponse(status.value(), message);
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining("; "));

        var errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotProductFoundException.class)
    public ResponseEntity<ErrorResponse> notProductFoundException(NotProductFoundException exception){
        return buildErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(ExistProductIdException.class)
    public ResponseEntity<ErrorResponse> existProductIdException(ExistProductIdException exception){
        return buildErrorResponse(HttpStatus.CONFLICT, exception.getMessage());
    }
}
