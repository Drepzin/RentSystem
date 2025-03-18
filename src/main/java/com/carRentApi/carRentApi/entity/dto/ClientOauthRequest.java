package com.carRentApi.carRentApi.entity.dto;

public record ClientOauthRequest(String clientId, String username, String clientSecret,
                                 String redirectUri, String scope) {
}
