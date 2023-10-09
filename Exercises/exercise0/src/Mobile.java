import java.util.UUID;

public class Mobile {
     String mobileId;
     String brand;
     String model;
     double screenSize;
     int storageCapacity;
     boolean isSmartphone;
     boolean is5GEnabled;
     double price;

    public Mobile(String brand, String model, double screenSize, int storageCapacity, boolean isSmartphone, boolean is5GEnabled, double price) {
        this.mobileId = UUID.randomUUID().toString().substring(0, 8);
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
        this.isSmartphone = isSmartphone;
        this.is5GEnabled = is5GEnabled;
        this.price = price;
        System.out.println("Mobile instance created. Mobile ID: " + this.mobileId);
    }

    public void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

    public void makeCall() {}

    public void powerOff() {}

}