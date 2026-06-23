package e3_1;

// Base class
public class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return 0.0; // default
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Shape with color " + color;
    }
}

