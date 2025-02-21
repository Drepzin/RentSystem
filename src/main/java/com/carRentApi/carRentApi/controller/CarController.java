package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.dto.CarResponseDto;
import com.carRentApi.carRentApi.service.RentCarService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Cars")
public class CarController {

    @Autowired
    private RentCarService rentCarService;

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> findAllCars(){
        return new ResponseEntity<>(rentCarService.getAllCars(), HttpStatus.FOUND);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<CarResponseDto>> findCarByRegex(@RequestParam("name")String name){
        return new ResponseEntity<>(rentCarService.getCarsByName(name), HttpStatus.FOUND);
    }
}
