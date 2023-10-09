import java.util.UUID;

public class Car {
    String carId;
    String make;
    String model;
    int year;
    String color;
    double mileage;
    boolean isAutomatic;
    double price;

    public Car(String make, String model, int year, String color, double mileage, boolean isAutomatic, double price) {
        this.carId = UUID.randomUUID().toString().substring(0, 8);
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.isAutomatic = isAutomatic;
        this.price = price;
        System.out.println("Car instance created. Car ID: " + this.carId);
    }

    public void startEngine() {
        System.out.println("Engine started in " + make + " " + model);
    }

    public void accelerate() {
    }

    public void brake() {
    }

}
