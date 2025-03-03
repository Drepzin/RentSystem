package com.carRentApi.carRentApi.mapper;

import com.carRentApi.carRentApi.entity.RentCar;
import com.carRentApi.carRentApi.entity.dto.CarRequestDto;
import com.carRentApi.carRentApi.entity.dto.CarResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "availableQuantity", source = "quantity")
    RentCar dtoToEntity(CarRequestDto carRequestDto);

    CarResponseDto entityToDto(RentCar rentCar);
}
