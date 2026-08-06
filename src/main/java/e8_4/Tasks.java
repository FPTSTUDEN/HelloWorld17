package e8_4;
import java.util.Arrays;


public class Tasks {
    public static void main(String[] args) {
        // Task 1: Calculate mean of an array in functional way (e.g. no for-loops)
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};
        double mean = Arrays.stream(numbers).average().orElse(Double.NaN);
        System.out.println("Mean: " + mean);
        // Task 2: Filter out even numbers, double each remaining number, and sum them up
        int[] integers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(integers)
                .filter(n -> n % 2 != 0) // Filter out even numbers
                .map(n -> n * 2) // Double each remaining number
                .sum(); // Sum them up
        System.out.println("Sum: " + sum);
    }
}
