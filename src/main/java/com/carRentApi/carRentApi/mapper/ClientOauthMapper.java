package com.carRentApi.carRentApi.mapper;

import com.carRentApi.carRentApi.entity.ClientOauth;
import com.carRentApi.carRentApi.entity.dto.ClientOauthRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientOauthMapper {

    @Mapping(target = "username", source = "clientUsername")
    ClientOauth dtoToEntity(ClientOauthRequest clientOauthRequest);
}
