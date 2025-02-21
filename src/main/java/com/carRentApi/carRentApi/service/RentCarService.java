package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.dto.CarResponseDto;
import com.carRentApi.carRentApi.mapper.CarMapper;
import com.carRentApi.carRentApi.repository.RentCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentCarService {

    private RentCarRepository rentCarRepository;

    public RentCarService(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    public List<CarResponseDto> getAllCars(){
        return rentCarRepository.findAll().stream().
                map(CarMapper.CAR_MAPPER::entityToDto).toList();
    }

    public List<CarResponseDto> getCarsByName(String name){
        return rentCarRepository.findCarsByName(name).stream().map(CarMapper.CAR_MAPPER::entityToDto)
                .toList();
    }

}
