package e8_3;

import java.util.*;

public class LambdaTask2 {
    public static void main(String[] args) {
        // Step 1: Create a list of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        System.out.println("Original list: " + numbers);

        // Step 2: Filter even numbers (remove them)
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removing even numbers: " + numbers);

        // Step 3: Double the odd numbers
        numbers.replaceAll(n -> n * 2);
        System.out.println("After doubling odd numbers: " + numbers);

        // Step 4: Calculate the sum of all numbers
            int sum = 0;
            for (Integer n : numbers) {
                sum += n;
            }
            System.out.println("Sum of numbers: " + sum);
    }
}
