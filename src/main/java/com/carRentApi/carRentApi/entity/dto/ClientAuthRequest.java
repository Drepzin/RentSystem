package com.carRentApi.carRentApi.entity.dto;

public record ClientAuthRequest(String username, String password,
                                String email, String phoneNumber, String role) {
}
