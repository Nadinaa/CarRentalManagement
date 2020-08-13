package ro.jademy.carrentals.services;

public interface FilterService {
    void showCarsByMake(String make);

    void showCarsByModel(String model);

    void showCarsByBudget(int budget);
}