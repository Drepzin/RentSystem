package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RentCarRepository extends PagingAndSortingRepository<RentCar, Integer> {

    @Query("SELECT c FROM RentCar c WHERE c.carModel LIKE :name%")
    Optional<RentCar> findCarsByName(@Param("name") String carName);
}
