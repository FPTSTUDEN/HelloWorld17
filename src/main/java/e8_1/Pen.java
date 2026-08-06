package e8_1;
public class Pen {
    public enum Color {// RED, GREEN, BLUE, BLACK, YELLOW, ORANGE, PURPLE, PINK, BROWN, WHITE
    RED, GREEN, BLUE, BLACK, YELLOW, ORANGE, PURPLE, PINK, BROWN, WHITE
    
}
    private Color color;
    private boolean isCapped;

    public Pen() {
        this.color = Color.RED;
        this.isCapped = true;
    }

    public Pen(Color color) {
        this.color = color;
        this.isCapped = true;
    }

    public void capOff() {
        this.isCapped = false;
    }

    public void capOn() {
        this.isCapped = true;
    }

    public String draw() {
        if (isCapped) {
            return "";
        }
        return "Drawing " + color.toString().toLowerCase();
    }

    public void changeColor(Color color) {
        this.color = color;
    }
}
