package com.carRentApi.carRentApi.configuration.security;

import com.carRentApi.carRentApi.entity.ClientAuth;
import com.carRentApi.carRentApi.service.ClientAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientAuthService clientAuthService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        ClientAuth clientAuth = clientAuthService.findByUsername(authentication.getName());
        String passwordClient = clientAuth.getPassword();
        String passwordAuth = authentication.getCredentials().toString();

        if(passwordEncoder.matches(passwordAuth, clientAuth.getPassword())){
            return new CustomAuthentication(clientAuth);
        }
        throw new RuntimeException();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
