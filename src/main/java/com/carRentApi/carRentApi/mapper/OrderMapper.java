package com.carRentApi.carRentApi.mapper;

import com.carRentApi.carRentApi.entity.RentOrder;
import com.carRentApi.carRentApi.entity.dto.OrderRequestDto;
import com.carRentApi.carRentApi.entity.dto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    RentOrder dtoToEntity(OrderRequestDto orderRequestDto);

    @Mappings({
            @Mapping(target = "firstName", source = "rentClient.firstName"),
            @Mapping(target = "lastName", source = "rentClient.lastName"),
            @Mapping(target = "phoneNumber", source = "rentClient.phoneNumber"),
            @Mapping(target = "email", source = "rentClient.email"),
            @Mapping(target = "carModel", source = "rentCar.carModel"),
    })
    OrderResponseDto entityToDto(RentOrder rentOrder);
}
