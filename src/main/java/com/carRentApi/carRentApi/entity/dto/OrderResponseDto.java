package com.carRentApi.carRentApi.entity.dto;

public record OrderResponseDto(Integer id, Integer clientId, Integer carId,
                               Short rentDays, Double totalValue){
}
