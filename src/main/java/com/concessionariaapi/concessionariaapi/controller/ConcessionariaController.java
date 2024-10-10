package com.concessionariaapi.concessionariaapi.controller;

import com.concessionariaapi.concessionariaapi.dto.CarDto;
import com.concessionariaapi.concessionariaapi.dto.CarResponseDto;
import com.concessionariaapi.concessionariaapi.repository.ICarRepo;
import com.concessionariaapi.concessionariaapi.service.ICarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionariaController {

    ICarService carService;

    public ConcessionariaController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping("v1/api/vehicles")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.createCar(carDto));
    }

    @GetMapping("v1/api/vehicles")
    public ResponseEntity<List<CarResponseDto>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("v1/api/vehicles/dates")
    public ResponseEntity<List<CarResponseDto>> getAllCarsByDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(carService.getCarsByDate(since, to));
    }
    @GetMapping("v1/api/vehicles/prices")
    public ResponseEntity<List<CarResponseDto>> getAllCarsByPrice(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(carService.getCarsByPrice(since, to));
    }

    @GetMapping("v1/api/vehicles/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Integer id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

}
