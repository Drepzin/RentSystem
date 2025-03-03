package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.ClientAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientAuthRepository extends JpaRepository<ClientAuth, Integer> {

    Optional<ClientAuth> findByUsername(String username);
}
