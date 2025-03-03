package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.ClientAuth;
import com.carRentApi.carRentApi.entity.dto.ClientAuthRequest;
import com.carRentApi.carRentApi.entity.dto.ClientAuthResponse;
import com.carRentApi.carRentApi.mapper.ClientAuthMapper;
import com.carRentApi.carRentApi.repository.ClientAuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientAuthService {

    private ClientAuthRepository clientAuthRepository;

    private PasswordEncoder passwordEncoder;

    public ClientAuthService(ClientAuthRepository clientAuthRepository, PasswordEncoder passwordEncoder) {
        this.clientAuthRepository = clientAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ClientAuthResponse addClientAuth(ClientAuthRequest clientAuthRequest){
        ClientAuth auth = ClientAuthMapper.CLIENT_AUTH_MAPPER.dtoToEntity(clientAuthRequest);
        auth.setPassword(passwordEncoder.encode(clientAuthRequest.password()));
        clientAuthRepository.save(auth);
        return ClientAuthMapper.CLIENT_AUTH_MAPPER.entityToDto(auth);
    }

    public ClientAuth findByUsername(String username){
        Optional<ClientAuth> optionalClientAuth = clientAuthRepository.findByUsername(username);
        return optionalClientAuth.orElseThrow(RuntimeException::new);
    }


}
