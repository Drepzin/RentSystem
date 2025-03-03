package com.carRentApi.carRentApi.configuration.security;

import com.carRentApi.carRentApi.entity.ClientAuth;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Stream;

public class CustomAuthentication implements Authentication {

    private final ClientAuth clientAuth;

    public CustomAuthentication(ClientAuth clientAuth) {
        this.clientAuth = clientAuth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(clientAuth.getRole()).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return clientAuth;
    }

    @Override
    public Object getPrincipal() {
        return clientAuth;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return clientAuth.getUsername();
    }
}
