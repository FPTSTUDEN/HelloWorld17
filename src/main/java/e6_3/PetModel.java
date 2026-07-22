package e6_3;

public class PetModel {
    private double x;
    private double y;
    private final double speed = 3.5; // Limits pet's maximum movement speed
    private int mouseX;
    private int mouseY;
    private boolean mousePresent = false;

    public PetModel(double startX, double startY) {
        this.x = startX;
        this.y = startY;
    }

    // Getters and Setters
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getSpeed() { return speed; }

    public int getMouseX() { return mouseX; }
    public int getMouseY() { return mouseY; }

    public void setMousePosition(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public boolean isMousePresent() { return mousePresent; }
    public void setMousePresent(boolean mousePresent) { this.mousePresent = mousePresent; }
}

