package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.RentCar;
import com.carRentApi.carRentApi.entity.RentClient;
import com.carRentApi.carRentApi.entity.RentOrder;
import com.carRentApi.carRentApi.entity.dto.OrderRequestDto;
import com.carRentApi.carRentApi.entity.dto.OrderResponseDto;
import com.carRentApi.carRentApi.entity.exception.AvailableQuantityException;
import com.carRentApi.carRentApi.mapper.OrderMapper;
import com.carRentApi.carRentApi.repository.RentCarRepository;
import com.carRentApi.carRentApi.repository.RentClientRepository;
import com.carRentApi.carRentApi.repository.RentOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentOrderService {

    private final RentClientRepository rentClientRepository;

    private final RentCarRepository rentCarRepository;

    private final RentOrderRepository rentOrderRepository;

    public RentOrderService(RentClientRepository rentClientRepository, RentCarRepository rentCarRepository,
                            RentOrderRepository rentOrderRepository) {
        this.rentClientRepository = rentClientRepository;
        this.rentCarRepository = rentCarRepository;
        this.rentOrderRepository = rentOrderRepository;
    }

    public OrderResponseDto addClientOrder(OrderRequestDto orderRequestDto){
       var rentClient = rentClientRepository.findClientByPhoneNumber(orderRequestDto.phoneNumber()).orElseThrow(RuntimeException::new);
        var rentCar = rentCarRepository.findCarByModel(orderRequestDto.carModel()).orElseThrow(RuntimeException::new);
        if(rentCar.getAvailableQuantity() < orderRequestDto.quantity() || rentCar.getAvailableQuantity() <= 0){
            throw new AvailableQuantityException("The solicited quantity is out of stock");
        }
        rentCar.setAvailableQuantity(rentCar.getAvailableQuantity() - orderRequestDto.quantity());
        RentOrder rentOrder = new RentOrder(rentClient, rentCar, orderRequestDto.rentDays(), orderRequestDto.quantity());
        rentOrderRepository.save(rentOrder);
        return OrderMapper.ORDER_MAPPER.entityToDto(rentOrder);
    }

    public List<OrderResponseDto> findAllOrders(){
        return rentOrderRepository.findAll().stream().map(OrderMapper.ORDER_MAPPER::entityToDto).toList();
    }

    public void deleteById(Integer id){
        RentOrder rentOrder = getOrderById(id);
        rentOrderRepository.delete(rentOrder);
    }

    private RentOrder getOrderById(Integer id){
        return rentOrderRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
