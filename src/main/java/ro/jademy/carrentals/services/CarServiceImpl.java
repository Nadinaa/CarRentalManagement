package ro.jademy.carrentals.services;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.models.cars.Car;

public class CarServiceImpl implements CarService {
    private RentalService rentalService = new RentalServiceImpl();

    public RentalService getRentalService() {
        return rentalService;
    }

    @Override
    public void getAllCars() {
        System.out.println("All cars: ");
        for (Car car : DataSource.carList) {
            System.out.println(DataSource.carList.indexOf(car) + 1 + ". " + car.toString());
        }
    }

    @Override
    public void getAvailableCars() {
        System.out.println("Available cars: ");
        for (Car car : DataSource.availableCarList) {
            System.out.println(DataSource.availableCarList.indexOf(car) + 1 + ". " + car.toString());
        }
    }

    @Override
    public void getRentedCars() {
        System.out.println("Rented cars: ");
        for (Car car : DataSource.rentedCarList) {
            System.out.println(DataSource.rentedCarList.indexOf(car) + 1 + ". " + car.toString());
        }
        if(DataSource.rentedCarList.isEmpty()){
            System.out.println("There are no rented cars!");
        }
    }
}