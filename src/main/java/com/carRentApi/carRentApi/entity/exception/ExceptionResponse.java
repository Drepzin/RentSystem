package com.carRentApi.carRentApi.entity.exception;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime localDateTime, String code){
}
