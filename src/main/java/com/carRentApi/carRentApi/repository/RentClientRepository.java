package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.RentClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RentClientRepository extends JpaRepository<RentClient, Integer> {

    Optional<RentClient> findByPhoneNumber(String phone);

    Optional<RentClient> findByEmail(String email);

    void deleteById(Integer id);

    @Query("SELECT c FROM RentClient c WHERE c.firstName LIKE :name%")
    List<RentClient> findClientsByName(@Param("name") String name);

    @Query("SELECT c FROM RentClient c WHERE c.phoneNumber = :phone")
    Optional<RentClient> findClientByPhoneNumber(@Param("phone") String phone);

}
