import java.util.UUID;

public class Headphones {
    String headphonesId;
    String brand;
    String model;
    boolean isWireless;
    boolean hasMicrophone;
    boolean isNoiseCancelling;
    String color;
    double price;

    public Headphones(String brand, String model, boolean isWireless, boolean hasMicrophone, boolean isNoiseCancelling, String color, double price) {
        this.headphonesId = UUID.randomUUID().toString().substring(0, 8);
        this.brand = brand;
        this.model = model;
        this.isWireless = isWireless;
        this.hasMicrophone = hasMicrophone;
        this.isNoiseCancelling = isNoiseCancelling;
        this.color = color;
        this.price = price;
        System.out.println("Headphones instance created. Headphones ID: " + this.headphonesId);
    }

    public void playMusic() {
        System.out.println("Playing music on " + brand + " " + model);
    }

    public void turnOn() {
    }

    public void adjustVolume() {
    }

}
