package ro.jademy.carrentals.services;

import ro.jademy.carrentals.models.cars.Car;
import ro.jademy.carrentals.models.users.User;

public interface RentalService {
    void rentCar(User user, Car car, int noOfDays);
    void returnCar(User user);
}