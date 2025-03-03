package com.carRentApi.carRentApi.repo;

import com.carRentApi.carRentApi.repository.RentCarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RentCarRepoTest {

    @Autowired
    RentCarRepository rentCarRepository;

    @Test
    public void repositoryIsNotNull(){
        assertThat(rentCarRepository.findAll()).hasSizeGreaterThan(5);
    }

}
