package com.concessionariaapi.concessionariaapi.service;

import com.concessionariaapi.concessionariaapi.dto.CarDto;
import com.concessionariaapi.concessionariaapi.dto.CarResponseDto;
import com.concessionariaapi.concessionariaapi.dto.ServiceDto;
import com.concessionariaapi.concessionariaapi.model.Car;
import com.concessionariaapi.concessionariaapi.model.Service;
import com.concessionariaapi.concessionariaapi.repository.CarRepo;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class CarService implements ICarService {

    CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = fromCarDtoToCar(carDto);
        if (carRepo.getCarById(car.getId()) != null) {
            throw new RuntimeException("This ID already exists");
        }
        carRepo.createCar(car);
        return carDto;
    }

    @Override
    public List<CarResponseDto> getAllCars() {
        List<Car> cars = carRepo.getAllCars();
        return cars.stream()
                .map(this::fromCarToCarResponseDto)
                .toList();
    }

    @Override
    public List<CarResponseDto> getCarsByDate(String dateStart, String dateEnd) {
        LocalDate startDate = LocalDate.parse(dateStart.trim());
        LocalDate endDate = LocalDate.parse(dateEnd.trim());

        return  carRepo.getCarsByDate(startDate, endDate).stream()
                .map(this::fromCarToCarResponseDto)
                .toList();
    }

    @Override
    public CarDto getCarById(Integer id) {
        Car car = carRepo.getCarById(id);
        return fromCarToCarDto(car);
    }

    @Override
    public List<CarResponseDto> getCarsByPrice(String priceSince, String priceTo) {
        Double priceSinceToDouble = Double.parseDouble(priceSince);
        Double priceUntilToDouble = Double.parseDouble(priceTo);

        return carRepo.getCarsByPrice(priceSinceToDouble, priceUntilToDouble).stream().map(this::fromCarToCarResponseDto).toList();

    }

    public Car fromCarDtoToCar(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setModel(carDto.model());
        car.setManufacturingDate(LocalDate.parse(carDto.manufacturingDate()));
        car.setNumberOfKilometers(Long.parseLong(carDto.numberOfKilometers()));
        car.setDoors(Integer.parseInt(carDto.doors()));
        car.setCurrency(carDto.currency());
        car.setServices(carDto.services().stream().map(this::fromSerciceDtoToService).toList());
        car.setCountOfOwners(Integer.parseInt(carDto.countOfOwners()));
        car.setPrice(Double.parseDouble(carDto.price()));

        return car;
    }

    public CarResponseDto fromCarToCarResponseDto(Car car) {
        return new CarResponseDto(
                car.getBrand(),
                car.getModel(),
                car.getNumberOfKilometers().toString(),
                car.getManufacturingDate().toString(),
                car.getDoors().toString(),
                car.getCurrency(),
                car.getCountOfOwners().toString(),
                car.getPrice().toString()
        );
    }

    public CarDto fromCarToCarDto(Car car) {
        return new CarDto(
                car.getBrand(),
                car.getModel(),
                car.getNumberOfKilometers().toString(),
                car.getManufacturingDate().toString(),
                car.getDoors().toString(),
                car.getCurrency(),
                car.getPrice().toString(),
                car.getServices().stream().map(this::fromServiceToServiceDto).toList(),
                car.getCountOfOwners().toString()
        );
    }


    public Service fromSerciceDtoToService(ServiceDto serviceDto) {
        Service service = new Service();
        service.setDate(LocalDate.parse(serviceDto.date()));
        service.setDescription(serviceDto.description());
        service.setKilometers(Long.parseLong(serviceDto.Kilometers()));

        return service;
    }

    public ServiceDto fromServiceToServiceDto(Service service) {
        ServiceDto serviceDto = new ServiceDto(
                service.getDescription().toString(),
                service.getDate().toString(),
                service.getKilometers().toString()
        );

        return serviceDto;
    }
}
