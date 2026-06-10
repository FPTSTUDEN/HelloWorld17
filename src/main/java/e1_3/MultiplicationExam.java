package e1_3;
import java.util.Scanner;

public class MultiplicationExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int score = 0;

            for (int i = 1; i <= 10; i++) {
                int a = (int) (Math.random() * 10) + 1;
                int b = (int) (Math.random() * 10) + 1;

                System.out.print("Question " + i + ": " + a + " x " + b + " = ");
                int answer = scanner.nextInt();

                if (answer == a * b) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is " + (a * b));
                }
            }

            if (score == 10) {
                System.out.println("Congratulations! You mastered the multiplication tables!");
                break;
            } else {
                System.out.println("You scored " + score + " points. Let's try again!");
            }
        }

        scanner.close();
    }
}
