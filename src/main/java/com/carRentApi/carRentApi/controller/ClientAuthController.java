package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.dto.ClientAuthRequest;
import com.carRentApi.carRentApi.entity.dto.ClientAuthResponse;
import com.carRentApi.carRentApi.service.ClientAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api_Client")
public class ClientAuthController {

    @Autowired
    private ClientAuthService clientAuthService;

    @PostMapping
    public ResponseEntity<ClientAuthResponse> addClient(@RequestBody ClientAuthRequest clientAuthRequest){
        ClientAuthResponse clientAuthResponse = clientAuthService.addClientAuth(clientAuthRequest);
        return new ResponseEntity<>(clientAuthResponse, HttpStatus.CREATED);
    }
}
