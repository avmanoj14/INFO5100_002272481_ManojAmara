import java.io.*;

// Main class for testing
public class Main {
    public static void main(String[] args) {
        // Set color using static method
        Shape.setColor("Red");

        // Example usage
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(4, 5);
        Circle circle = new Circle(3);
        Square square = new Square(4);

        // Serialization
        serializeObjects(triangle, "triangle.ser");
        serializeObjects(rectangle, "rectangle.ser");
        serializeObjects(circle, "circle.ser");
        serializeObjects(square, "square.ser");

        // Deserialization
        Triangle deserializedTriangle = (Triangle) deserializeObject("triangle.ser");
        Rectangle deserializedRectangle = (Rectangle) deserializeObject("rectangle.ser");
        Circle deserializedCircle = (Circle) deserializeObject("circle.ser");
        Square deserializedSquare = (Square) deserializeObject("square.ser");

        // Verify deserialized objects
        System.out.println("Deserialized Triangle Area: " + deserializedTriangle.calculateArea());
        System.out.println("Deserialized Triangle Color: " + Shape.getColor());

        System.out.println("Deserialized Rectangle Area: " + deserializedRectangle.calculateArea());
        System.out.println("Deserialized Rectangle Color: " + Shape.getColor());

        System.out.println("Deserialized Circle Area: " + deserializedCircle.calculateArea());
        System.out.println("Deserialized Circle Color: " + Shape.getColor());

        System.out.println("Deserialized Square Area: " + deserializedSquare.calculateArea());
        System.out.println("Deserialized Square Color: " + Shape.getColor());
    }

    private static void serializeObjects(Object object, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
            System.out.println("Serialized " + object.getClass().getSimpleName() + " object to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object deserializeObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = ois.readObject();
            System.out.println("Deserialized " + object.getClass().getSimpleName() + " object from " + fileName);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

