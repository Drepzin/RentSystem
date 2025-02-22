package com.carRentApi.carRentApi.utils;

import com.carRentApi.carRentApi.entity.RentClient;
import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;

public class ClientUpdater {

    public static RentClient updateClient(RentClient rentClient, ClientRequestDto clientRequestDto){
        if(clientRequestDto.firstName() != null){
            rentClient.setFirstName(clientRequestDto.firstName());
        }
        if(clientRequestDto.lastName() != null){
            rentClient.setLastName(clientRequestDto.lastName());
        }
        if(clientRequestDto.email() != null){
            rentClient.setEmail(clientRequestDto.email());
        }
        if(clientRequestDto.birthDate() != null){
            rentClient.setBirthDate(clientRequestDto.birthDate());
        }
        if(clientRequestDto.country() != null){
            rentClient.setCountry(clientRequestDto.country());
        }
        if(clientRequestDto.city() != null){
            rentClient.setCity(clientRequestDto.city());
        }
        return rentClient;
    }
}
