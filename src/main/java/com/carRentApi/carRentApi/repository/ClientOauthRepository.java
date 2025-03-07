package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.ClientAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOauthRepository extends JpaRepository<ClientAuth, Integer> {
}
