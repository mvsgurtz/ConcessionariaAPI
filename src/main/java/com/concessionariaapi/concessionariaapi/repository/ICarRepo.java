package com.concessionariaapi.concessionariaapi.repository;

import com.concessionariaapi.concessionariaapi.dto.UpdateDto;
import com.concessionariaapi.concessionariaapi.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarRepo {
    Car createCar(Car car);
    Car getCarById(Integer id);
    List<Car> getAllCars();
    List<Car> getCarsByDate(LocalDate dateStart, LocalDate dateEnd);
    List<Car> getCarsByPrice(Double priceSince, Double priceTo);
    Car updateCarPrice(Integer id, Double price);
    void deleteCarById(Integer id);


}