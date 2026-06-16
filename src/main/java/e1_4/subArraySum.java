package e1_4;
import java.util.Scanner;
public class subArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, maximumSum = Integer.MIN_VALUE;
        System.out.print("Enter the size of the array: ");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        int start = 0, end = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentSum = prefixSum[j + 1] - prefixSum[i];
                if (currentSum > maximumSum) {
                    maximumSum = currentSum;
                    start = i;
                    end = j;
                    // System.out.println("Integers: "+start+" to "+end);
                }
            }
        }
        start++; // Convert to 1-based index
        end++;   // Convert to 1-based index
        System.out.println("Maximum sum: " + maximumSum);
        System.out.println("Integers: "+start+" to "+end);
    }
}
