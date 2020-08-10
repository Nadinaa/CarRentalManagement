package ro.jademy.carrentals.model.cars.audiCars;

import ro.jademy.carrentals.model.Car;

public class Audi extends Car {

    public Audi(String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, double engine, long basePrice) {
        super("Audi", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}