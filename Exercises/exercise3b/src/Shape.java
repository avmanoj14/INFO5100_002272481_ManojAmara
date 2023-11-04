import java.io.*;

// Shape class (Base class)
abstract class Shape implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version UID
    private static String color;

    public static void setColor(String newColor) {
        color = newColor;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public static String getColor() {
        return color;
    }
}

// Triangle class (Derived from Shape)
class Triangle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

// Rectangle class (Derived from Shape)
class Rectangle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Circle class (Derived from Shape)
class Circle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Square class (Derived from Shape)
class Square extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }

    public double calculatePerimeter() {
        return 4 * side;
    }
}

