package com.carRentApi.carRentApi.entity.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrderRequestDto(
        @Max(value = 15, message = "max value is 15 chars for phone number")
        @NotBlank(message = "phone number cannot ne null")
        String phoneNumber,
        @Max(value = 20)
        @NotBlank(message = "car model cannot be null")
        String carModel,
        @Max(value = 30)
        @Min(value = 1)
        @NotBlank(message = "rent days cannot be 0")
        Short rentDays,
        @Min(value = 10)
        @NotBlank(message = "the quantity cannot be null")
        Integer quantity){
}
