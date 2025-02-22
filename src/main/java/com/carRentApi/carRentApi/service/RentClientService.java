package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.RentClient;
import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;
import com.carRentApi.carRentApi.entity.dto.ClientResponseDto;
import com.carRentApi.carRentApi.mapper.ClientMapper;
import com.carRentApi.carRentApi.repository.RentClientRepository;
import com.carRentApi.carRentApi.utils.ClientUpdater;
import com.carRentApi.carRentApi.utils.ClientValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Page<ClientResponseDto> findAllClients(Integer page, Integer qnt){
        Pageable pageable = PageRequest.of(page, qnt);
        return rentClientRepository.findAll(pageable).map(ClientMapper.CLIENT_MAPPER::entityToDto);
    }

    public ClientResponseDto findClientById(Integer id){
        return ClientMapper.CLIENT_MAPPER
                .entityToDto(rentClientRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    public void deleteByClient(Integer id){
        Optional<RentClient> rentClient = rentClientRepository.findById(id);
        if(rentClient.isEmpty()){
            throw new RuntimeException();
        }
        rentClientRepository.deleteById(id);
    }

    public void updateClientInfos(Integer id, ClientRequestDto clientRequestDto){
        Optional<RentClient> rentClient = rentClientRepository.findById(id);
        if(rentClient.isEmpty()){
            throw new RuntimeException();
        }
        ClientUpdater.updateClient(rentClient.get(), clientRequestDto);
    }
}
