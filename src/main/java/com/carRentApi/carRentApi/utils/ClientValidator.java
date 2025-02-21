package com.carRentApi.carRentApi.utils;

import com.carRentApi.carRentApi.entity.RentClient;
import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;
import com.carRentApi.carRentApi.repository.RentClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientValidator {

    @Autowired
    RentClientRepository rentClientRepository;

    public void verify(ClientRequestDto clientRequestDto){
        if(validatePhone(clientRequestDto) || validateEmail(clientRequestDto) || clientRequestDto == null){
            throw new RuntimeException("error");
        }
    }

    private boolean validatePhone(ClientRequestDto clientRequestDto){
        Optional<RentClient> rentClient = rentClientRepository.findByPhoneNumber(clientRequestDto.phoneNumber());
        return rentClient.isPresent();
    }

    private boolean validateEmail(ClientRequestDto clientRequestDto){
        Optional<RentClient> rentClient = rentClientRepository.findByEmail(clientRequestDto.email());
        return rentClient.isPresent();
    }

}
