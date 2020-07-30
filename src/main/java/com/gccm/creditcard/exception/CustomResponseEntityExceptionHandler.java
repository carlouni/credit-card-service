package com.gccm.creditcard.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        // Generate list of validation errors
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        // Obtain request path
        Matcher matcher = Pattern
                .compile(";?uri=([a-zA-Z0-9/]*);?")
                .matcher(request.getDescription(false));

        String path = "";
        if ( matcher.find() ) {
            path = matcher.group(1);
        }

        ErrorDetails errorDetails = new ErrorDetails(new Date(), 400,"Bad Request", errors, path);
        return new ResponseEntity<>(errorDetails, headers, HttpStatus.BAD_REQUEST);
    }
}
