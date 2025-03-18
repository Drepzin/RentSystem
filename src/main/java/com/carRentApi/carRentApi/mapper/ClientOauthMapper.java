package com.carRentApi.carRentApi.mapper;

import com.carRentApi.carRentApi.entity.ClientOauth;
import com.carRentApi.carRentApi.entity.dto.ClientOauthRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientOauthMapper {

    ClientOauthMapper CLIENT_OAUTH_MAPPER = Mappers.getMapper(ClientOauthMapper.class);

    ClientOauth dtoToEntity(ClientOauthRequest clientOauthRequest);
}
