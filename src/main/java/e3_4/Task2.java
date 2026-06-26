package e3_4;

import java.io.FileWriter;
import java.io.BufferedWriter;
// import java.io.PrintWriter;


public class Task2 {
    public static void main(String[] args) {
        long[] fib = new long[60];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < 60; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("fibonacci.csv"))) {
            for (int i = 0; i < 60; i++) {
                bw.write(i + "," + fib[i]);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Fibonacci sequence saved to fibonacci.csv");
    }
}
