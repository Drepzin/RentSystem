package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentOrderRepository extends JpaRepository<RentOrder, Integer> {
}
