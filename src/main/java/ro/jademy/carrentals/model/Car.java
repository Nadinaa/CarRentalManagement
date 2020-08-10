package ro.jademy.carrentals.model;

public class Car {
    // Q: how can we better represent the car make?
    public String make;
    public String model;
    public Integer year;

    // Q: how can we better represent the car type?
    public String carType; // coupe, sedan, hatchback, convertible, wagon, SUV

    // Q: how can we better represent the motor type?
    public String fuelType; // diesel, gasoline, alternative

    public Integer doorNumber;

    public String color;

    // Q: how can we better represent the transmission type?
    public String transmissionType; // automatic, manual

    // Q: how can we better represent the engine?
    public double engine;

    // Q: how can we better represent money value?
    public long basePrice;

    // Q: do we need a constructor other than the default one?
    // Q: how can we better protect the car data?


    public Car(String make, String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, double engine, long basePrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.carType = carType;
        this.fuelType = fuelType;
        this.doorNumber = doorNumber;
        this.color = color;
        this.transmissionType = transmissionType;
        this.engine = engine;
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", carType='" + carType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", doorNumber=" + doorNumber +
                ", color='" + color + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", engine=" + engine +
                ", basePrice=" + basePrice +
                '}';
    }
}