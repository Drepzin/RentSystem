package com.carRentApi.carRentApi.entity.dto;

public record OrderRequestDto(Integer clientId, Integer carId, Short rentDays, Double totalValue){
}
