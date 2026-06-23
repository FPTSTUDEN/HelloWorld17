package e2_1;

// CoffeeMaker.java
// CoffeeMakerDriver.java
public class CoffeeMakerDriver {
    public static class CoffeeMaker {
        private boolean isOn;
        private String coffeeType;
        private int coffeeAmount;

        public CoffeeMaker() {
            this.isOn = false;
            this.coffeeType = "normal"; // default
            this.coffeeAmount = 10;     // default minimum
        }

        public void turnOn() {
            isOn = true;
            System.out.println("Coffee maker is on");
        }

        public void turnOff() {
            isOn = false;
            System.out.println("Coffee maker is off");
        }

        public void setCoffeeType(String type) {
            if (isOn) {
                if (type.equalsIgnoreCase("normal") || type.equalsIgnoreCase("espresso")) {
                    coffeeType = type;
                    System.out.println("Coffee type is " + coffeeType);
                } else {
                    System.out.println("Invalid coffee type");
                }
            } else {
                System.out.println("Cannot change coffee type when off");
            }
        }

        public void setCoffeeAmount(int amount) {
            if (isOn) {
                if (amount >= 10 && amount <= 80) {
                    coffeeAmount = amount;
                    System.out.println("Coffee amount is " + coffeeAmount + " ml");
                } else {
                    System.out.println("Invalid amount. Must be 10–80 ml");
                }
            } else {
                System.out.println("Cannot change coffee amount when off");
            }
        }
    }

    public static void main(String[] args) {
        CoffeeMaker cm = new CoffeeMaker();
        cm.turnOn();
        cm.setCoffeeType("espresso");
        cm.setCoffeeAmount(50);
        cm.turnOff();
    }
}
