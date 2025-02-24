package com.carRentApi.carRentApi.entity.dto;

public record CarResponseDto(String carModel, String manufacturer,
                             String color, Short modelYear,
                             Short maxSpeed, Byte peopleCapacity,
                             Double pricePerDay, String carTrackCode, Integer quantity) {
}
