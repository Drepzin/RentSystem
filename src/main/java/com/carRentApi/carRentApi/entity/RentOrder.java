package com.carRentApi.carRentApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rent_orders")
public class RentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    private RentClient rentClient;

    @ManyToOne()
    @JoinColumn(name = "car_id", nullable = false)
    private RentCar rentCar;

    @Column(name = "rent_days", nullable = false)
    private Short rentDays;

    @Column(name = "total_value", nullable = false)
    private Double totalValue;

    public RentOrder(){}

    public RentOrder(RentClient rentClient, RentCar rentCar,
                     Short rentDays) {
        this.rentClient = rentClient;
        this.rentCar = rentCar;
        this.rentDays = rentDays;
        totalValue = rentCar.getPricePerDay() * rentDays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RentClient getRentClient() {
        return rentClient;
    }

    public void setRentClient(RentClient rentClient) {
        this.rentClient = rentClient;
    }

    public RentCar getRentCar() {
        return rentCar;
    }

    public void setRentCar(RentCar rentCar) {
        this.rentCar = rentCar;
    }

    public Short getRentDays() {
        return rentDays;
    }

    public void setRentDays(Short rentDays) {
        this.rentDays = rentDays;
    }

    public Double getTotalValue() {
        return rentCar.getPricePerDay() * rentDays;
    }
}
