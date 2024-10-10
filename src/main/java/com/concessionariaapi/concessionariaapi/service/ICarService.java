package com.concessionariaapi.concessionariaapi.service;

import com.concessionariaapi.concessionariaapi.dto.CarDto;
import com.concessionariaapi.concessionariaapi.model.Car;

public interface ICarService {
    CarDto createCar(CarDto carDto);
}
