package org.dilan.controller;

import org.dilan.entity.Car;
import org.dilan.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping(value = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getCar(@PathVariable long id){
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid car id %s", id)));
    }

    @PostMapping(value = "/car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(@Valid @RequestBody Car car) {
        return carRepository.save(car);
    }
}
