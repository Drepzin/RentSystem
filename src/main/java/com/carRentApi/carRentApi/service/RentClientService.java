package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.RentClient;
import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;
import com.carRentApi.carRentApi.entity.dto.ClientResponseDto;
import com.carRentApi.carRentApi.mapper.ClientMapper;
import com.carRentApi.carRentApi.repository.RentClientRepository;
import com.carRentApi.carRentApi.utils.ClientValidator;
import org.springframework.stereotype.Service;

@Service
public class RentClientService {

    private final RentClientRepository rentClientRepository;

    private final ClientValidator clientValidator;

    public RentClientService(RentClientRepository rentClientRepository, ClientValidator clientValidator) {
        this.rentClientRepository = rentClientRepository;
        this.clientValidator = clientValidator;
    }

    public ClientResponseDto addClient(ClientRequestDto clientRequestDto){
        clientValidator.verify(clientRequestDto);
        RentClient rentClient = ClientMapper.CLIENT_MAPPER.dtoToEntity(clientRequestDto);
        rentClientRepository.save(rentClient);
        return ClientMapper.CLIENT_MAPPER.entityToDto(rentClient);
    }
}
