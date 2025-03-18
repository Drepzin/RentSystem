package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.ClientOauth;
import com.carRentApi.carRentApi.entity.dto.ClientOauthRequest;
import com.carRentApi.carRentApi.mapper.ClientOauthMapper;
import com.carRentApi.carRentApi.repository.ClientOauthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientOauthService {

    @Autowired
    private ClientOauthRepository clientOauthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClientOauth addClientOauth(ClientOauthRequest clientOauthRequest){
        ClientOauth clientOauth = ClientOauthMapper.CLIENT_OAUTH_MAPPER.dtoToEntity(clientOauthRequest);
        clientOauth.setClientSecret(passwordEncoder.encode(clientOauth.getClientSecret()));
        return clientOauthRepository.save(clientOauth);
    }

    public ClientOauth findClientByUsername(String username){
        Optional<ClientOauth> clientOauth = clientOauthRepository.findByUsername(username);
        return clientOauth.orElseThrow(RuntimeException::new);
    }

    public ClientOauth findClientById(String clientID){
        Optional<ClientOauth> clientOauth = clientOauthRepository.findByClientId(clientID);
        return clientOauth.orElseThrow(RuntimeException::new);
    }
}
