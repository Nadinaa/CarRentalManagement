package ro.jademy.carrentals.model.cars.audiCars;

import ro.jademy.carrentals.model.cars.Car;

public class Audi extends Car {

    public Audi(String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, double engine, long rentalPrice) {
        super("Audi", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, rentalPrice);
    }
}