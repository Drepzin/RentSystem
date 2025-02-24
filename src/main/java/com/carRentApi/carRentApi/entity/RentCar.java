package com.carRentApi.carRentApi.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rent_cars")
public class RentCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_model", nullable = false)
    private String carModel;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column()
    private String color;

    @Column(nullable = false)
    private Short modelYear;

    @Column(name = "max_speed", nullable = false)
    private Short maxSpeed;

    @Column(name = "people_capacity", nullable = false)
    private Byte peopleCapacity;

    @Column(name = "baggage_capacity", nullable = false)
    private Double baggageCapacity;

    @Column(name = "price_per_day", nullable = false)
    private Double pricePerDay;

    @Column(name = "car_track_code")
    private String carTrackCode;

    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;

    @OneToMany(mappedBy = "rentCar")
    private List<RentOrder> rentOrder;

    public RentCar(){}

    public RentCar(String carModel, String manufacturer, String color, Short modelYear, Short maxSpeed, Byte peopleCapacity,
                   Double baggageCapacity, Double pricePerDay, Integer availableQuantity) {
        this.carModel = carModel;
        this.manufacturer = manufacturer;
        this.color = color;
        this.modelYear = modelYear;
        this.maxSpeed = maxSpeed;
        this.peopleCapacity = peopleCapacity;
        this.baggageCapacity = baggageCapacity;
        this.pricePerDay = pricePerDay;
        carTrackCode = UUID.randomUUID().toString();
        this.availableQuantity = availableQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Short getModelYear() {
        return modelYear;
    }

    public void setModelYear(Short modelYear) {
        this.modelYear = modelYear;
    }

    public Short getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Short maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Byte getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(Byte peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public Double getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(Double baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getCarTrackCode() {
        return carTrackCode;
    }

    public void setCarTrackCode(String carTrackCode) {
        this.carTrackCode = carTrackCode;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
