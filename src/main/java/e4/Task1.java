package e4;

public class Task1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.reset();
        calc.add(5);
        calc.add(10);
        System.out.println("Current value: " + calc.getValue());

        try {
            calc.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
