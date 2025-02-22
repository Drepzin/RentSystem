package com.carRentApi.carRentApi.repository;

import com.carRentApi.carRentApi.entity.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RentOrderRepository extends PagingAndSortingRepository<RentOrder, Integer> {
}
