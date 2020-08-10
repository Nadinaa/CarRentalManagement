package ro.jademy.carrentals.model;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.services.CarService;
import ro.jademy.carrentals.services.CarServiceImpl;
import ro.jademy.carrentals.services.FilterService;
import ro.jademy.carrentals.services.FilterServiceImpl;

import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    private CarService carService = new CarServiceImpl();
    private FilterService filterService = new FilterServiceImpl();

    public boolean login(String username, String password) {
        for (int i = 0; i < DataSource.userList.size(); i++) {
            if (DataSource.userList.get(i).getUsername().equalsIgnoreCase(username) && DataSource.userList.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void loginScreen() {
        boolean isLoginSuccessful;
        do {
            System.out.println("  Welcome!\nPlease Log in\n");
            System.out.println("Username: ");
            String username = scanner.next();
            System.out.println("Password: ");
            String password = scanner.next();
            isLoginSuccessful = login(username, password);
            if (isLoginSuccessful) {
                showMenu();
            } else {
                System.out.println("Invalid credentials!");
            }

        } while (!isLoginSuccessful);
    }

    public void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Jademy Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. Search cars");
        System.out.println("5. Check income");
        System.out.println("6. Logout");
        System.out.println("7. Exit");

        chooseMenuOption();
    }

    private void chooseMenuOption() {
        System.out.println("Choose an option:");
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                carService.getAllCars();
                showMenu();
                break;
            case 2:
                carService.getAvailableCars();
                showMenu();
                break;
            case 3:
                carService.getRentedCars();
                showMenu();
                break;
            case 4:
                showListMenuOptions();
                break;
            default:
                System.out.println("Choose a correct option!");
                chooseMenuOption();
        }
    }

    public void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");

        chooseListMenuOption();
    }

    private void chooseListMenuOption() {
        System.out.println("Choose an option:");
        int selectedOption = scanner.nextInt();
        switch(selectedOption){
            case 1:
                filterService.filterCarsByMake();
                showListMenuOptions();
                break;
            case 2:
                filterService.filterCarsByModel();
                showListMenuOptions();
                break;
            case 3:
                filterService.filterCarsByBudget();
                showListMenuOptions();
                break;
            case 4:
                showMenu();
                break;
            default:
                System.out.println("Choose a correct option!");
                chooseListMenuOption();
        }
    }

    public void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller

        // Q: what should be the return type of this method?
    }
}