package com.concessionariaapi.concessionariaapi.service;

import com.concessionariaapi.concessionariaapi.dto.CarDto;
import com.concessionariaapi.concessionariaapi.dto.CarResponseDto;

import java.util.List;

public interface ICarService {
    CarDto createCar(CarDto carDto);
    List<CarResponseDto> getAllCars();
    List<CarResponseDto> getCarsByDate(String dateStart, String dateEnd);
    List<CarResponseDto> getCarsByPrice(String priceSince, String priceTo);
    CarDto getCarById(Integer id);

}
