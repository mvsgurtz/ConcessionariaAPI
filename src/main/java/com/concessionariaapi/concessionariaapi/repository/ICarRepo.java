package com.concessionariaapi.concessionariaapi.repository;

import com.concessionariaapi.concessionariaapi.model.Car;

import java.util.List;

public interface ICarRepo {
    Car createCar(Car car);
    Car getCarById(Integer id);
}