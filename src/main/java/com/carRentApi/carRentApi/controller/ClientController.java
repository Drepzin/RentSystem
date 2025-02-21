package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;
import com.carRentApi.carRentApi.entity.dto.ClientResponseDto;
import com.carRentApi.carRentApi.service.RentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("Rent_clients")
public class ClientController {

    @Autowired
    RentClientService rentClientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> addClient(@RequestBody ClientRequestDto clientRequestDto){
        return new ResponseEntity<>(rentClientService.addClient(clientRequestDto), HttpStatus.CREATED);
    }
}
