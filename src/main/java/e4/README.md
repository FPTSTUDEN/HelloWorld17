
## Project Overview
This project demonstrates a simple **Calculator** class that acts as the *Model* in the MVC pattern. The calculator can reset its value, add positive integers, and return the current sum. Negative integers are not allowed and will throw an exception.

---

## Calculator Class Code

```java
public class Calculator {
    private int value;

    // Reset calculator to zero
    public void reset() {
        value = 0;
    }

    // Add an integer to the calculator
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
```

---

## Explanation of How It Works

- **reset method**: This sets the calculator’s internal value back to zero. It’s useful when starting a new calculation.
- **add method**: This takes an integer and adds it to the current value. If the integer is negative, the method throws an `IllegalArgumentException` to prevent invalid input.
- **getValue method**: This simply returns the current stored value, allowing other parts of the program (like the controller or view in MVC) to display or use the result.
