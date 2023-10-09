import java.util.UUID;

// Chair Class
public class Chair {
    String chairId;
    String material;
    String color;
    int legs;
    boolean hasArmrest;
    boolean isAdjustable;
    double price;
    String manufacturer;

    public Chair(String material, String color, int legs, boolean hasArmrest, boolean isAdjustable, double price, String manufacturer) {
        this.chairId = UUID.randomUUID().toString().substring(0, 8);
        this.material = material;
        this.color = color;
        this.legs = legs;
        this.hasArmrest = hasArmrest;
        this.isAdjustable = isAdjustable;
        this.price = price;
        this.manufacturer = manufacturer;
        System.out.println("Chair instance created. Chair ID: " + this.chairId);
    }

    public void chairInfo() {
        System.out.println("Material: " + material);
    }
    public void manufacturerInfo() {}

    public void useChair() {}
}
