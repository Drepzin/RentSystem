package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.RentCar;
import org.springframework.data.repository.CrudRepository;

public interface RentCarRepository extends CrudRepository<RentCar, Integer> {
}
