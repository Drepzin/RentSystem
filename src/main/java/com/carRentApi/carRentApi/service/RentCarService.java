package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.RentCar;
import com.carRentApi.carRentApi.entity.dto.CarRequestDto;
import com.carRentApi.carRentApi.entity.dto.CarResponseDto;
import com.carRentApi.carRentApi.mapper.CarMapper;
import com.carRentApi.carRentApi.repository.RentCarRepository;
import com.carRentApi.carRentApi.utils.EntityUpdater;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentCarService {

    private RentCarRepository rentCarRepository;

    public RentCarService(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    public void saveCar(CarRequestDto carRequestDto){
        RentCar rentCar = CarMapper.CAR_MAPPER.dtoToEntity(carRequestDto);
        rentCarRepository.save(rentCar);
    }

    public List<CarResponseDto> getAllCars(){
        return rentCarRepository.findAll().stream().
                map(CarMapper.CAR_MAPPER::entityToDto).toList();
    }

    public List<CarResponseDto> getCarsByName(String name){
        return rentCarRepository.findCarsByName(name).stream().map(CarMapper.CAR_MAPPER::entityToDto)
                .toList();
    }

    public CarResponseDto findCarById(Integer id){
        return CarMapper.CAR_MAPPER.entityToDto(getCarById(id));
    }

    public void deleteCarById(Integer id){
        RentCar rentCar = getCarById(id);
        rentCarRepository.delete(rentCar);
    }

    public void updateCarInfos(Integer id, CarRequestDto carRequestDto){
        RentCar rentCar = getCarById(id);
        rentCarRepository.save(EntityUpdater.updateCar(rentCar, carRequestDto));
    }

    public RentCar getCarById(Integer id){
        Optional<RentCar> optionalRentCar = rentCarRepository.findById(id);
        if(optionalRentCar.isEmpty()){
            throw new RuntimeException();
        }
        return optionalRentCar.get();
    }
}