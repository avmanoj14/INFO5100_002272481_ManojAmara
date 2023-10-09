import java.util.UUID;

public class Watch {
     String watchId;
     String brand;
     String model;
     String strapMaterial;
     boolean isDigital;
     boolean isWaterResistant;
     boolean isBatteryPowered;
     double batteryLevel;

    public Watch(String brand, String model, String strapMaterial, boolean isDigital, boolean isWaterResistant, boolean isBatteryPowered, double initialBatteryLevel) {
        this.watchId = UUID.randomUUID().toString().substring(0, 8);
        this.brand = brand;
        this.model = model;
        this.strapMaterial = strapMaterial;
        this.isDigital = isDigital;
        this.isWaterResistant = isWaterResistant;
        this.isBatteryPowered = isBatteryPowered;
        this.batteryLevel = initialBatteryLevel;
        System.out.println("Watch instance created. Watch ID: " + this.watchId);
    }

    public void checkBatteryStatus() {
        System.out.println("Battery level is " + batteryLevel + "% on " + brand + " " + model);
    }

    public void setTime() {
    }
    public void chargeWatch() {

    }

}

