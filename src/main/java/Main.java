public class Main {
    public static boolean isEven(int number) {
        return ((number % 2) == 0);
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println("Number " + n + " is even: " + isEven(n));
    }
}