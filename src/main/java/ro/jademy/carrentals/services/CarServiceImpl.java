package ro.jademy.carrentals.services;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.model.Car;

public class CarServiceImpl implements CarService {
    @Override
    public void getAllCars() {
        System.out.println("All cars: ");
        for (Car car: DataSource.carList) {
            System.out.println(car.toString());
        }
    }

    @Override
    public void getAvailableCars() {
        System.out.println("Available cars: ");
        for (Car car: DataSource.availableCarList) {
            System.out.println(car.toString());
        }
    }

    @Override
    public void getRentedCars() {
        System.out.println("Rented cars: ");
        for (Car car: DataSource.rentedCarList) {
            System.out.println(car.toString());
        }
    }
}