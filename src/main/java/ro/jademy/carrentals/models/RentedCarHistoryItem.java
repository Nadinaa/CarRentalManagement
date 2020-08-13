package ro.jademy.carrentals.models;

import ro.jademy.carrentals.models.cars.Car;

import java.time.LocalDateTime;

public class RentedCarHistoryItem {
    private Car car;
    private LocalDateTime pickUpDate;
    private LocalDateTime returnUpDate;
    private boolean isCurrentlyRented;

    public RentedCarHistoryItem(Car car, LocalDateTime pickUpDate, LocalDateTime returnUpDate, boolean isCurrentlyRented) {
        this.car = car;
        this.pickUpDate = pickUpDate;
        this.returnUpDate = returnUpDate;
        this.isCurrentlyRented = isCurrentlyRented;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDateTime getReturnUpDate() {
        return returnUpDate;
    }

    public void setReturnUpDate(LocalDateTime returnUpDate) {
        this.returnUpDate = returnUpDate;
    }

    public boolean isCurrentlyRented() {
        return isCurrentlyRented;
    }

    public void setCurrentlyRented(boolean currentlyRented) {
        isCurrentlyRented = currentlyRented;
    }

    @Override
    public String toString() {
        return
                car +
                        ", pickUpDate=" + pickUpDate +
                        ", returnUpDate=" + returnUpDate +
                        ", isCurrentlyRented=" + isCurrentlyRented +
                        '}';
    }
}