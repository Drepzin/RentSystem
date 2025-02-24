package com.carRentApi.carRentApi.controller.exception;

import com.carRentApi.carRentApi.entity.exception.AvailableQuantityException;
import com.carRentApi.carRentApi.entity.exception.ExceptionResponse;
import com.carRentApi.carRentApi.entity.exception.UniqueEntityFieldsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UniqueEntityFieldsException.class)
    public ResponseEntity<ExceptionResponse> captureUniqueException(UniqueEntityFieldsException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now(),
                HttpStatus.CONFLICT.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AvailableQuantityException.class)
    public ResponseEntity<ExceptionResponse> captureAvailableException(AvailableQuantityException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now(),
                HttpStatus.NOT_ACCEPTABLE.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<ExceptionResponse> captureInternalServerException(HttpServerErrorException.InternalServerError internalServerError){
        ExceptionResponse exceptionResponse = new ExceptionResponse(internalServerError.getMessage(), LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> captureMethodNotValidException(MethodArgumentNotValidException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now(),
                HttpStatus.NOT_ACCEPTABLE.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> captureDataIntegrityException(DataIntegrityViolationException exception){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), LocalDateTime.now(), HttpStatus.NOT_ACCEPTABLE.toString());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
