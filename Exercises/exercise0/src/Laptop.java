import java.util.UUID;

public class Laptop {
    String laptopId;
    String brand;
    String model;
    String processor;
    int ramSize;
    int storageCapacity;
    boolean isTouchscreen;
    double price;

    public Laptop(String brand, String model, String processor, int ramSize, int storageCapacity, boolean isTouchscreen, double price) {
        this.laptopId = UUID.randomUUID().toString().substring(0, 8);
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ramSize = ramSize;
        this.storageCapacity = storageCapacity;
        this.isTouchscreen = isTouchscreen;
        this.price = price;
        System.out.println("Laptop instance created. Laptop ID: " + this.laptopId);
    }

    public void powerOn() {
        System.out.println(brand + " " + model + " is powering on.");
    }

    public void runSoftware() {
    }

    public void sleep() {
    }

}