package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.ClientOauth;
import com.carRentApi.carRentApi.entity.dto.ClientOauthRequest;
import com.carRentApi.carRentApi.service.ClientOauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client_oauth")
public class ClientOauthController {

    @Autowired
    private ClientOauthService clientOauthService;

    @PostMapping
    public ResponseEntity<ClientOauth> addClientOauth(@RequestBody ClientOauthRequest clientOauthRequest){

    }
}
