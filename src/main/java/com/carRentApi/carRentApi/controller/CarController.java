package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.dto.CarRequestDto;
import com.carRentApi.carRentApi.entity.dto.CarResponseDto;
import com.carRentApi.carRentApi.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Car")
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

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable("id") Integer id){
        rentCarService.deleteCarById(id);
    }

    @PatchMapping("{Id}")
    public ResponseEntity<CarResponseDto> updateCar(@PathVariable("id") Integer id, @RequestBody CarRequestDto carRequestDto){
        rentCarService.updateCarInfos(id, carRequestDto);
        return new ResponseEntity<>(rentCarService.findCarById(id), HttpStatus.OK);
    }

}