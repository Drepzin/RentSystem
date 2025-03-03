package com.carRentApi.carRentApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Secret")
public class SecretController {

    @GetMapping
    public String gotcha(){
        return "You found the secret Controller congrats!";
    }
}
