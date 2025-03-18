package com.carRentApi.carRentApi.configuration.security;

import com.carRentApi.carRentApi.entity.ClientOauth;
import com.carRentApi.carRentApi.service.ClientOauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

@Component
public class CustomRegisteredClientRpository implements RegisteredClientRepository {

    private final ClientOauthService  clientOauthService;
    private final TokenSettings tokenSettings;
    private final ClientSettings clientSettings;

    public CustomRegisteredClientRpository(ClientOauthService clientOauthService, TokenSettings tokenSettings, ClientSettings clientSettings){
        this.clientOauthService = clientOauthService;
        this.tokenSettings = tokenSettings;
        this.clientSettings = clientSettings;
    }

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        ClientOauth clientOauth = clientOauthService.findClientById(clientId);
        return RegisteredClient.withId(clientOauth.getId().toString())
                .clientId(clientId)
                .clientSecret(clientOauth.getClientSecret())
                .clientName(clientOauth.getUsername())
                .redirectUri(clientOauth.getRedirectUri())
                .scope(clientOauth.getScope())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .tokenSettings(tokenSettings)
                .clientSettings(clientSettings)
                .build();
    }
}
