package com.carRentApi.carRentApi.entity.dto;

public record OrderResponseDto(Integer id, String firstName, String lastName, String carModel,
                              String phoneNumber, String email, Short rentDays, Double totalValue, Integer quantity){
}
