package ro.jademy.carrentals.model;

import java.time.LocalDate;

public class RentedCarHistoryItem {
    private Car car;
    private LocalDate pickUpDate;
    private LocalDate returnUpDate;
    private boolean isCurrentlyRented;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getReturnUpDate() {
        return returnUpDate;
    }

    public void setReturnUpDate(LocalDate returnUpDate) {
        this.returnUpDate = returnUpDate;
    }

    public boolean isCurrentlyRented() {
        return isCurrentlyRented;
    }

    public void setCurrentlyRented(boolean currentlyRented) {
        isCurrentlyRented = currentlyRented;
    }
}