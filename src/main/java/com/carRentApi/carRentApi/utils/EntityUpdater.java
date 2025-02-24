package com.carRentApi.carRentApi.utils;

import com.carRentApi.carRentApi.entity.RentCar;
import com.carRentApi.carRentApi.entity.RentClient;
import com.carRentApi.carRentApi.entity.dto.CarRequestDto;
import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;

public class EntityUpdater {

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

    public static RentCar updateCar(RentCar rentCar, CarRequestDto carRequestDto){
        if(carRequestDto.carModel() != null){
            rentCar.setCarModel(carRequestDto.carModel());
        }
        if(carRequestDto.color() != null){
            rentCar.setColor(carRequestDto.color());
        }
        if(carRequestDto.manufacturer() != null){
            rentCar.setManufacturer(carRequestDto.manufacturer());
        }
        if(carRequestDto.maxSpeed() != null){
            rentCar.setMaxSpeed(carRequestDto.maxSpeed());
        }
        if(carRequestDto.modelYear() != null){
            rentCar.setModelYear(carRequestDto.modelYear());
        }
        if(carRequestDto.peopleCapacity() != null){
            rentCar.setPeopleCapacity(carRequestDto.peopleCapacity());
        }
        if(carRequestDto.pricePerDay() != null){
            rentCar.setPricePerDay(carRequestDto.pricePerDay());
        }
        return rentCar;
    }
}
