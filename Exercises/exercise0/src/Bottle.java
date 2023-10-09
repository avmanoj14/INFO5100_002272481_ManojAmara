import java.util.UUID;

public class Bottle {
     String bottleId;
     double capacity;
     String material;
     boolean isReusable;
     String color;
     boolean isSealed;
     boolean isFilled;
     String contents;

    public Bottle(double capacity, String material, boolean isReusable, String color) {
        this.bottleId = UUID.randomUUID().toString().substring(0, 8);
        this.capacity = capacity;
        this.material = material;
        this.isReusable = isReusable;
        this.color = color;
        this.isSealed = true;
        this.isFilled = false;
        this.contents = null;
        System.out.println("Bottle instance created. Bottle ID: " + this.bottleId);
    }

    public void displayInfo() {
        System.out.println("Bottle ID: " + bottleId);
        System.out.println("Capacity: " + capacity + " liters");
        System.out.println("Material: " + material);
        System.out.println("Is Reusable: " + (isReusable ? "Yes" : "No"));
        System.out.println("Color: " + color);
        System.out.println("Is Sealed: " + (isSealed ? "Yes" : "No"));
        System.out.println("Is Filled: " + (isFilled ? "Yes" : "No"));
        System.out.println("Contents: " + (contents != null ? contents : "Empty"));
    }

    public void openBottle() {
        isSealed = false;
        System.out.println("Bottle opened.");
    }
    public void fillBottle() {
    }
    public void pourOut() {
    }
}
