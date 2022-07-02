package org.dilan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String make;
    private int mileage;
    private int numberOfDoors;

    public Car(String name, String make, int mileage, int numberOfDoors) {
        this.name = name;
        this.make = make;
        this.mileage = mileage;
        this.numberOfDoors = numberOfDoors;
    }

}
