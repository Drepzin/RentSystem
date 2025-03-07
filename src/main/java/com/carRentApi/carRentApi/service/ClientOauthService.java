package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.ClientOauth;
import com.carRentApi.carRentApi.entity.dto.ClientOauthRequest;
import com.carRentApi.carRentApi.repository.ClientOauthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientOauthService {

    @Autowired
    private ClientOauthRepository clientOauthRepository;

    public ClientOauth addClientOauth(ClientOauthRequest clientOauthRequest){
        return null;
    }
}
