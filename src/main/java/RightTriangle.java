import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of first leg: ");
        double a = scanner.nextDouble();

        System.out.print("Enter length of second leg: ");
        double b = scanner.nextDouble();

        double hypotenuse = Math.sqrt(a * a + b * b);
        // System.out.printf("Length of hypotenuse: %.2f%n", hypotenuse);
        System.out.println("Length of hypotenuse: " + hypotenuse);

        scanner.close();
    }
}
