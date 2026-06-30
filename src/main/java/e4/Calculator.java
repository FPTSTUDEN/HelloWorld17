package e4;

public class Calculator {
    private int value;

    // Reset calculator to zero
    public void reset() {
        value = 0;
    }

    // This method adds a positive integer to the calculator. If the integer is negative, throw an exception.
    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        value += number;
    }

    // Return the current value
    public int getValue() {
        return value;
    }
}

