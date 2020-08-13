package ro.jademy.carrentals.models;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.models.cars.Car;
import ro.jademy.carrentals.models.users.Customer;
import ro.jademy.carrentals.models.users.Salesman;
import ro.jademy.carrentals.models.users.User;
import ro.jademy.carrentals.services.CarServiceImpl;
import ro.jademy.carrentals.services.FilterService;
import ro.jademy.carrentals.services.FilterServiceImpl;

import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    User user;
    private long totalIncome;
    private CarServiceImpl carService = new CarServiceImpl();
    private FilterService filterService = new FilterServiceImpl();
    private boolean isLoginSuccessful;

    private void showWelcomeScreen() {
        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Jademy Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
    }

    private void showMenu() {
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. Search cars");
        if (user instanceof Customer) {
            System.out.println("5. Rent a car");
            System.out.println("6. Return a car");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
        } else if (user instanceof Salesman) {
            System.out.println("5. Check income");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
        }

        chooseCustomerMenuOption();
    }

    private void chooseCustomerMenuOption() {
        System.out.print("Choose an option: ");
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
            case 5:
                if (user instanceof Customer) {
                    carService.getAvailableCars();
                    System.out.print("Choose the number of car you want to rent: ");
                    int carNumber = scanner.nextInt();
                    System.out.print("For how many days do you want to rent this car? ");
                    int noOfDays = scanner.nextInt();
                    Car car = DataSource.availableCarList.get(carNumber - 1);
                    carService.getRentalService().rentCar(user, car, noOfDays);
                    totalIncome += car.rentalPrice * noOfDays;
                    System.out.println("You have to pay: " + totalIncome + "€");
                } else if (user instanceof Salesman) {
                    displayTotalIncome();
                }
                showMenu();
                break;
            case 6:
                if (user instanceof Customer) {
                    carService.getRentalService().returnCar(user);
                    showMenu();
                } else if (user instanceof Salesman) {
                    logout();
                    loginScreen();
                }
                break;
            case 7:
                if (user instanceof Customer) {
                    logout();
                    loginScreen();
                } else if (user instanceof Salesman) {
                    exit();
                }
                break;
            case 8:
                if (user instanceof Customer) {
                    exit();
                }
                break;
            default:
                System.out.println("Choose a correct option!");
                chooseCustomerMenuOption();
        }
    }

    public void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        System.out.println("4. Back to previous menu");

        chooseListMenuOption();
    }

    private void chooseListMenuOption() {
        System.out.print("Choose an option: ");
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                System.out.print("Choose a car make: ");
                String make = scanner.next();
                filterService.showCarsByMake(make);
                showListMenuOptions();
                break;
            case 2:
                System.out.print("Choose a car model: ");
                String model = scanner.next();
                filterService.showCarsByModel(model);
                showListMenuOptions();
                break;
            case 3:
                System.out.print("Choose a maximum car price per day: ");
                int budget = scanner.nextInt();
                filterService.showCarsByBudget(budget);
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

    public void loginScreen() {
        do {
            System.out.println("|----- Welcome! ----|");
            System.out.println("|-- Please Log in --|\n");
            System.out.print("|Username: ");
            String username = scanner.next();
            System.out.print("|Password: ");
            String password = scanner.next();
            isLoginSuccessful = login(username, password);
            if (isLoginSuccessful) {
                showWelcomeScreen();
                showMenu();
            } else {
                System.out.println("\nInvalid credentials! Please retry!\n");
            }
        } while (!isLoginSuccessful);
    }

    private boolean login(String username, String password) {
        for (int i = 0; i < DataSource.userList.size(); i++) {
            if (DataSource.userList.get(i).getUsername().equalsIgnoreCase(username) && DataSource.userList.get(i).getPassword().equals(password)) {
                user = DataSource.userList.get(i);
                return true;
            }
        }
        return false;
    }

    private void logout() {
        isLoginSuccessful = false;
    }

    private void exit() {
        System.out.println("Bye bye...");
    }

    public void displayTotalIncome() {
        System.out.println("Total income is: " + totalIncome + "€");
    }

    public void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller


        // Q: what should be the return type of this method?
    }
}