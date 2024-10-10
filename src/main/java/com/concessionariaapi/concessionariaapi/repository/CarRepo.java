package com.concessionariaapi.concessionariaapi.repository;

import com.concessionariaapi.concessionariaapi.dto.UpdateDto;
import com.concessionariaapi.concessionariaapi.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepo implements ICarRepo {

    List<Car> cars = new ArrayList<>();

    @Override
    public Car createCar(Car car) {
        car.setId(cars.size() + 1);
        cars.add(car);
        return car;
    }

    @Override
    public Car getCarById(Integer id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsByDate(LocalDate dateStart, LocalDate dateEnd) {
        return cars.stream()
                .filter(car ->
                        (car.getManufacturingDate().isAfter(dateStart) || car.getManufacturingDate().isEqual(dateStart)) &&
                        (car.getManufacturingDate().isBefore(dateEnd) || car.getManufacturingDate().isEqual(dateEnd))
                )
                .toList();
    }

    @Override
    public List<Car> getCarsByPrice(Double priceSince, Double priceTo) {
        return cars.stream().filter(car -> car.getPrice() >= priceSince && car.getPrice() <= priceTo).toList();
    }

    @Override
    public Car updateCarPrice(Integer id, Double price) {
        Car carFounded = getCarById(id);
        carFounded.setPrice(price);
        return carFounded;
    }

    @Override
    public void deleteCarById(Integer id) {
        cars.remove(getCarById(id));
    }
}
