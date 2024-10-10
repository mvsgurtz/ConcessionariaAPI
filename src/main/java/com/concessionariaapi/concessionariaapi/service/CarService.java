package com.concessionariaapi.concessionariaapi.service;

import com.concessionariaapi.concessionariaapi.dto.CarDto;
import com.concessionariaapi.concessionariaapi.dto.ServiceDto;
import com.concessionariaapi.concessionariaapi.model.Car;
import com.concessionariaapi.concessionariaapi.model.Service;
import com.concessionariaapi.concessionariaapi.repository.CarRepo;

import java.time.LocalDate;

public class CarService implements ICarService{

    CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = carDtoToCar(carDto);
        if (carRepo.getCarById(car.getId()) == null) {
            carRepo.createCar(car);
        }
        throw new RuntimeException("This ID already exists");
    }


    public Car carDtoToCar(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setModel(carDto.model());
        car.setManufacturingDate(LocalDate.parse(carDto.manufacturingDate()));
        car.setNumberOfKilometers(Long.parseLong(carDto.numberOfKilometers()));
        car.setDoors(Integer.parseInt(carDto.doors()));
        car.setCurrency(carDto.currency());
        car.setServices(carDto.services().stream().map(this::fromSerciceDtoToService).toList());
        car.setCountOfOwners(Integer.parseInt(carDto.countOfOwners()));

        return car;
    }

    public Service fromSerciceDtoToService(ServiceDto serviceDto) {
        Service service = new Service();
        service.setDate(LocalDate.parse(serviceDto.date()));
        service.setDescription(serviceDto.description());
        service.setKilometers(Long.parseLong(serviceDto.Kilometers()));

        return service;
    }
}
