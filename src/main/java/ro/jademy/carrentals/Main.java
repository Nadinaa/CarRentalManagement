package ro.jademy.carrentals;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.models.Shop;

public class Main {
    public static void main(String[] args) {

        DataSource.createCarList();
        DataSource.createUserList();

        Shop shop = new Shop();
        shop.loginScreen();
    }
}