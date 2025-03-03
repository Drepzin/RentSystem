package com.carRentApi.carRentApi.service;

import com.carRentApi.carRentApi.entity.RentCar;
import com.carRentApi.carRentApi.entity.dto.CarRequestDto;
import com.carRentApi.carRentApi.entity.dto.CarResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
class RentCarServiceTest {

    @Autowired
    RentCarService rentCarService;

    @Test
    public void isRentCarSaved(){
        CarRequestDto carRequestDto = new CarRequestDto("Opala", "frime", "blue", (short) 1988,
                (short) 124, (byte) 4, 43.50, 50.50, 4);
        rentCarService.saveCar(carRequestDto);
        List<CarResponseDto> carResponseDtos = rentCarService.getAllCars();
        assertThat(carResponseDtos).hasSizeGreaterThan(0);
    }

    @Test
    public void rentCarExist(){
        RentCar rentCar = rentCarService.getCarById(1);
        assertThat(rentCar.getCarModel()).isEqualTo("Opala");
    }

}
