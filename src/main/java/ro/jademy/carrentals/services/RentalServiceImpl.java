package ro.jademy.carrentals.services;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.models.cars.Car;
import ro.jademy.carrentals.models.RentedCarHistoryItem;
import ro.jademy.carrentals.models.users.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RentalServiceImpl implements RentalService {
    @Override
    public void rentCar(User user, Car car, int noOfDays) {
        user.getRentedCarHistoryItemList().add(new RentedCarHistoryItem(car, LocalDateTime.now(), LocalDateTime.now().plusDays(noOfDays), true));

        DataSource.rentedCarList.add(car);
        DataSource.availableCarList.remove(car);
    }

    @Override
    public void returnCar(User user) {
        if(user.getRentedCarHistoryItemList().size() > 1){
            user.showRentedCars();
            for(RentedCarHistoryItem rentedCar : user.getRentedCarHistoryItemList()){
                if (rentedCar.isCurrentlyRented()){
                    System.out.print("Choose the car you want to return: ");
                    Scanner scanner = new Scanner(System.in);
                    int chosenCar = scanner.nextInt();
                    rentedCar.setCurrentlyRented(false);
                    user.getRentedCarHistoryItemList().set(chosenCar - 1, rentedCar);
                    DataSource.rentedCarList.remove(rentedCar.getCar());
                    DataSource.availableCarList.add(rentedCar.getCar());
                    break;
                }
            }
        } else {
            user.getRentedCarHistoryItemList().get(0).setCurrentlyRented(false);
            DataSource.rentedCarList.remove(user.getRentedCarHistoryItemList().get(0).getCar());
            DataSource.availableCarList.add(user.getRentedCarHistoryItemList().get(0).getCar());
        }
    }
}