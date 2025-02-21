package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.RentClient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RentClientRepository extends CrudRepository<RentClient, Integer> {

    Optional<RentClient> findByPhoneNumber(String phone);

    Optional<RentClient> findByEmail(String email);

}
