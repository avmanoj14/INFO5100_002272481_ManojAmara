// Shape class (Base class)
abstract class Shape {
    private static String color; // Static field representing color

    // Static method to set the color
    public static void setColor(String newColor) {
        color = newColor;
    }

    // Abstract methods for calculating area and perimeter
    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    // Non-abstract method to get the color
    public static String getColor() {
        return color;
    }
}

// Triangle class (Derived from Shape)
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    // Constructor
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Override abstract methods to calculate area and perimeter for Triangle
    //@Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    //@Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

// Rectangle class (Derived from Shape)
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Override abstract methods to calculate area and perimeter for Rectangle
    //@Override
    public double calculateArea() {
        return length * width;
    }

    //@Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Circle class (Derived from Shape)
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }


    // Override abstract methods to calculate area and perimeter for Circle
    //@Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    //@Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Square class (Derived from Shape)
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side*side;
    }

    public double calculatePerimeter() {
        return 4*side;
    }

}




