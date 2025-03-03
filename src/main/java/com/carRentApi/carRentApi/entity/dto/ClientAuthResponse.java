package com.carRentApi.carRentApi.entity.dto;

public record ClientAuthResponse(String username, String email, String phoneNumber, String role) {
}
