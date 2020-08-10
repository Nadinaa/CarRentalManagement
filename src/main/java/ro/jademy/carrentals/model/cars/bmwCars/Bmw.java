package ro.jademy.carrentals.model.cars.bmwCars;

import ro.jademy.carrentals.model.Car;

public class Bmw extends Car {

    public Bmw(String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, double engine, long basePrice) {
        super("BMW", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}
