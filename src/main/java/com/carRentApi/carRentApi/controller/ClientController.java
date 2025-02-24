package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.dto.ClientRequestDto;
import com.carRentApi.carRentApi.entity.dto.ClientResponseDto;
import com.carRentApi.carRentApi.service.RentClientService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("Rent_client")
public class ClientController {

    @Autowired
    RentClientService rentClientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> addClient(@RequestBody ClientRequestDto clientRequestDto){
        return new ResponseEntity<>(rentClientService.addClient(clientRequestDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Page<ClientResponseDto>> getAllClients(@RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "size", defaultValue = "1") Integer size){
        return new ResponseEntity<>(rentClientService.findAllClients(page, size), HttpStatus.FOUND);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<ClientResponseDto>> findALlClientsByName(@RequestParam("name")String name){
        return new ResponseEntity<>(rentClientService.findClientsByName(name), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable(name = "id") Integer id){
        rentClientService.deleteByClient(id);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ClientResponseDto> updateClient(@PathVariable("id") Integer id,@RequestBody ClientRequestDto clientRequestDto){
        rentClientService.updateClientInfos(id, clientRequestDto);
        return new ResponseEntity<>(rentClientService.findClientById(id), HttpStatus.OK);
    }
}
