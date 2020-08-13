package ro.jademy.carrentals.data;

import ro.jademy.carrentals.models.cars.Car;
import ro.jademy.carrentals.models.users.User;
import ro.jademy.carrentals.models.cars.audiCars.A6;
import ro.jademy.carrentals.models.cars.audiCars.A7;
import ro.jademy.carrentals.models.cars.audiCars.A8;
import ro.jademy.carrentals.models.cars.bmwCars.Series3;
import ro.jademy.carrentals.models.cars.bmwCars.Series4;
import ro.jademy.carrentals.models.cars.bmwCars.Series5;
import ro.jademy.carrentals.models.users.Customer;
import ro.jademy.carrentals.models.users.Salesman;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Car> carList = new ArrayList<>();
    public static List<Car> availableCarList;
    public static List<Car> rentedCarList = new ArrayList<>();

    public static List<User> userList = new ArrayList<>();

    public static void createCarList(){
        carList.add(new A6(2010, "sedan", "diesel", 4, "black", "manual", 2.2, 220));
        carList.add(new A7(2014, "hatchback", "gasoline", 4, "red", "automatic", 2.7, 320));
        carList.add(new A7(2015, "hatchback", "diesel", 4, "white", "manual", 2.5, 330));
        carList.add(new A8(2019, "coupe", "alternative", 2, "white", "manual", 4.0, 800));
        carList.add(new Series3(2010, "coupe", "gasoline", 4, "black", "manual", 2.2, 420));
        carList.add(new Series4(2016, "sedan", "diesel", 4, "blue", "automatic", 2.2, 610));
        carList.add(new Series5(2019, "sedan", "gasoline", 2, "grey", "automatic", 2.2, 750));

        availableCarList = new ArrayList<>(carList);
    }

    public static void createUserList() {
        userList.add(new Customer("Adrian", "Florea", "adrian1234"));
        userList.add(new Customer("Ion", "Ionescu", "ion1234"));
        userList.add(new Salesman("Marius", "Popescu", "marius1234"));
    }
}