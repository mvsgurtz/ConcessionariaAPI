package com.concessionariaapi.concessionariaapi.repository;

import com.concessionariaapi.concessionariaapi.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepo implements ICarRepo{

    List<Car> cars = new ArrayList<>();

    @Override
    public Car createCar(Car car) {
        car.setId(cars.size()+1);
        cars.add(car);
        return car;
    }

    @Override
    public Car getCarById(Integer id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }
}
