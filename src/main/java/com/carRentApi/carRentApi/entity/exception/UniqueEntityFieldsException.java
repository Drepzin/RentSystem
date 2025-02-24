package com.carRentApi.carRentApi.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UniqueEntityFieldsException extends RuntimeException {
    public UniqueEntityFieldsException(String message) {
        super(message);
    }
}
