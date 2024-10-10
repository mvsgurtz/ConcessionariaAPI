package com.concessionariaapi.concessionariaapi.model;

import java.time.LocalDate;
import java.util.List;

public class Car {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Double price;
    private Integer doors;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Long getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(Long numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currenc) {
        this.currency = currenc;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Integer getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(Integer countOfOwners) {
        this.countOfOwners = countOfOwners;
    }
}
