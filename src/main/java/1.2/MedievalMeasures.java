import java.util.Scanner;

public class MedievalMeasures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): ");
        double grams = scanner.nextDouble();

        // Conversion constants
        double gramsPerLuoti = 13.28;
        int luotiPerNaula = 32;
        int naulaPerLeiviska = 20;

        // Convert grams to luoti
        double totalLuoti = grams / gramsPerLuoti;

        // Break down into leiviskä, naula, and luoti
        int leiviska = (int) (totalLuoti / (luotiPerNaula * naulaPerLeiviska));
        totalLuoti %= (luotiPerNaula * naulaPerLeiviska);

        int naula = (int) (totalLuoti / luotiPerNaula);
        totalLuoti %= luotiPerNaula;

        double luoti = totalLuoti;

        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n",
                          grams, leiviska, naula, luoti);

        scanner.close();
    }
}
