package com.carRentApi.carRentApi.mapper;

import com.carRentApi.carRentApi.entity.RentOrder;
import com.carRentApi.carRentApi.entity.dto.OrderRequestDto;
import com.carRentApi.carRentApi.entity.dto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    RentOrder dtoToEntity(OrderRequestDto orderRequestDto);

    OrderResponseDto entityToDto(RentOrder rentOrder);
}
