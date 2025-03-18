package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.ClientAuth;
import com.carRentApi.carRentApi.entity.ClientOauth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientOauthRepository extends JpaRepository<ClientOauth, UUID> {

    Optional<ClientOauth> findByUsername(String username);

    Optional<ClientOauth> findByClientId(String clientId);

}
