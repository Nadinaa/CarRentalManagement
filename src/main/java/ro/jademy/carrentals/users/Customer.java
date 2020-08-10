package ro.jademy.carrentals.users;

import ro.jademy.carrentals.model.User;

public class Customer extends User {

    public Customer(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
    }
}