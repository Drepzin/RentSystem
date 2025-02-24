package com.carRentApi.carRentApi.controller;

import com.carRentApi.carRentApi.entity.dto.OrderRequestDto;
import com.carRentApi.carRentApi.entity.dto.OrderResponseDto;
import com.carRentApi.carRentApi.service.RentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
   private RentOrderService rentOrderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> addOrder(@RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(rentOrderService.addClientOrder(orderRequestDto), HttpStatus.CREATED);
    }
}
