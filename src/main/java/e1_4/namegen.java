package e1_4;
//import random
import java.util.Scanner;

public class namegen {
    public static void main(String[] args) {
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eve"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones"};
        Scanner scanner = new Scanner(System.in);
        int nameCount;
        // namegen() {
            System.out.print("How many names do you want to generate? ");
            nameCount = scanner.nextInt();
            for (int i = 0; i < nameCount; i++) {
                String firstName = firstNames[(int)(Math.random() * firstNames.length)];
                String lastName = lastNames[(int)(Math.random() * lastNames.length)];
                System.out.println(firstName + " " + lastName);
            // }
        }
        scanner.close();
    }
}
