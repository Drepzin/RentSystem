package com.carRentApi.carRentApi.entity.dto;

public record CarRequestDto(String carModel, String manufacturer,
                            String color, Short modelYear,
                            Short maxSpeed, Byte peopleCapacity,
                            Double pricePerDay, Integer quantity){

    public static CarRequestDto getNoColorInstance(String carModel, String manufacturer,
                                                   Short modelYear,
                                                   Short maxSpeed, Byte peopleCapacity,
                                                   Double pricePerDay, Integer quantity){
        return new CarRequestDto(carModel, manufacturer, null, modelYear, maxSpeed, peopleCapacity,
                pricePerDay, quantity);

    }
}
