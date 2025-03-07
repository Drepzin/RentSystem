package com.carRentApi.carRentApi.entity.dto;

public record ClientOauthRequest(String clientUsername, String clientSecret,
                                 String redirectUri, String scope) {
}
