package org.dilan;

import org.dilan.entity.Car;
import org.dilan.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(CarRepository repository) {
        return (args) -> {
            repository.save(new Car("Corolla", "Toyota", 5000, 4));
            repository.save(new Car("Civic", "Honda", 30000, 4));
            repository.save(new Car("A3", "Audi", 2000, 2));
        };
    }
}