package com.carRentApi.carRentApi.entity.dto;

import java.util.Date;

public record ClientResponseDto (Integer id, String firstName, String lastName, String email, String phoneNumber,
                                String country, String city, Date birthDate){
}
