package ro.jademy.carrentals.services;

import ro.jademy.carrentals.data.DataSource;
import ro.jademy.carrentals.models.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class FilterServiceImpl implements FilterService {
    private static final String NOT_FOUND = "No results found.";

    @Override
    public void showCarsByMake(String make) {
        List<Car> carListFilteredByMake = new ArrayList<>();

        for (Car car : DataSource.availableCarList) {
            if (car.make.equalsIgnoreCase(make)) {
                carListFilteredByMake.add(car);
            }
        }
        showResults(carListFilteredByMake);
    }

    @Override
    public void showCarsByModel(String model) {
        List<Car> carListFilteredByModel = new ArrayList<>();

        for (Car car : DataSource.availableCarList) {
            if (car.model.equalsIgnoreCase(model)) {
                carListFilteredByModel.add(car);
            }
        }
        showResults(carListFilteredByModel);
    }

    @Override
    public void showCarsByBudget(int budget) {
        List<Car> carListFilteredByBudget = new ArrayList<>();

        for (Car car : DataSource.availableCarList) {
            if (car.rentalPrice <= budget) {
                carListFilteredByBudget.add(car);
            }
        }
        showResults(carListFilteredByBudget);
    }

    private void showResults(List<Car> carList) {
        if (!carList.isEmpty()) {
            for (Car car : carList) {
                System.out.println(carList.indexOf(car) + 1 + ". " + car.toString());
            }
        } else {
            System.out.println(NOT_FOUND);
        }
    }
}