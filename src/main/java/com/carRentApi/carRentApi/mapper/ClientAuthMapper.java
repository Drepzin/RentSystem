package com.carRentApi.carRentApi.mapper;

import com.carRentApi.carRentApi.entity.ClientAuth;
import com.carRentApi.carRentApi.entity.dto.ClientAuthRequest;
import com.carRentApi.carRentApi.entity.dto.ClientAuthResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientAuthMapper {

    ClientAuthMapper CLIENT_AUTH_MAPPER = Mappers.getMapper(ClientAuthMapper.class);

    ClientAuth dtoToEntity(ClientAuthRequest clientAuthRequest);

    ClientAuthResponse entityToDto(ClientAuth clientAuth);
}
