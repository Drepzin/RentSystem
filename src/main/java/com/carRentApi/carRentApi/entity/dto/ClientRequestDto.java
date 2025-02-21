package com.carRentApi.carRentApi.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record ClientRequestDto(String firstName, String lastName, String email, String phoneNumber,
                               String country, String city, Date birthDate) {

    public static ClientRequestDto getOnlyNameInstance(String firstName, String email, String phoneNumber,
                                                       String country, String city, Date birthDate){
        return new ClientRequestDto(firstName, null, email, phoneNumber, country, city, birthDate);
    }
}
