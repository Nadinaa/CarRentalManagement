package ro.jademy.carrentals.model.users;

import ro.jademy.carrentals.model.RentedCarHistoryItem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private List<RentedCarHistoryItem> rentedCarHistoryItemList = new ArrayList<>();

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return firstName.concat(".").concat(lastName);
    }

    public List<RentedCarHistoryItem> getRentedCarHistoryItemList() {
        return rentedCarHistoryItemList;
    }

    public RentedCarHistoryItem getCurrentRentedCar() {
        for (RentedCarHistoryItem item : rentedCarHistoryItemList) {
            if (item.isCurrentlyRented()) {
                return item;
            }
        }
        return null;
    }

    public void showRentedCars(){
        System.out.println("Your rented cars are: ");
        for (RentedCarHistoryItem item : rentedCarHistoryItemList) {
            if (item.isCurrentlyRented()) {
                System.out.println(rentedCarHistoryItemList.indexOf(item) + 1 + ". " + item);
            }
        }
    }
}