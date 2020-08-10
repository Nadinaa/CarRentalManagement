package ro.jademy.carrentals.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String username;
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
        this.username = firstName.concat(".").concat(lastName);

        return username;
    }

    public RentedCarHistoryItem getCurrentRentedCar() {
        for (RentedCarHistoryItem item : rentedCarHistoryItemList) {
            if (item.isCurrentlyRented()) {
                return item;
            }
        }
        return null;
    }
}