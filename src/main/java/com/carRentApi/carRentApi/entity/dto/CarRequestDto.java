package com.carRentApi.carRentApi.entity.dto;

public record CarRequestDto(String carModel, String manufacturer,
                            String color, Short modelYear,
                            Short maxSpeed, Byte peopleCapacity,
                            Double pricePerDay){

    public static CarRequestDto getNoColorInstance(String carModel, String manufacturer,
                                                   Short modelYear,
                                                   Short maxSpeed, Byte peopleCapacity,
                                                   Double pricePerDay){
        return new CarRequestDto(carModel, manufacturer, null, modelYear, maxSpeed, peopleCapacity,
                pricePerDay);

    }
}
