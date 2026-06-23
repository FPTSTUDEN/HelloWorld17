package e2_1;
// Car Driver & Car with Cruise 

public class CarDriver {
    public static class Car {
        private double speed;
        private double gasolineLevel;
        private double gasolineCapacity;
        private String typeName;

        // Cruise control fields
        private boolean cruiseOn;
        private double targetSpeed;
        private final double MIN_CRUISE = 30;
        private final double MAX_CRUISE = 180;

        public Car(String typeName) {
            this.typeName = typeName;
            this.gasolineCapacity = 50; // default tank size
            this.gasolineLevel = 0;
            this.speed = 0;
            this.cruiseOn = false;
            this.targetSpeed = 0;
        }

        public void accelerate() {
            if (gasolineLevel > 0) {
                speed += 10;
                gasolineLevel -= 0.5;
            } else {
                speed = 0;
            }
        }

        public void decelerate(int amount) {
            if (gasolineLevel > 0 && amount > 0) {
                speed = Math.max(0, speed - amount);
            } else {
                speed = 0;
            }
        }

        public double getSpeed() {
            return speed;
        }

        public String getTypeName() {
            return typeName;
        }

        public void fillTank() {
            gasolineLevel = gasolineCapacity;
        }

        public double getGasolineLevel() {
            return gasolineLevel;
        }

        // --- Cruise Control Methods ---
        public boolean turnOnCruise(double target) {
            if (target < MIN_CRUISE || target > MAX_CRUISE) {
                System.out.println("Target speed out of range. Cruise control off.");
                cruiseOn = false;
                return false;
            }
            if (gasolineLevel <= 0) {
                System.out.println("No fuel. Cruise control off.");
                cruiseOn = false;
                return false;
            }
            targetSpeed = target;
            cruiseOn = true;
            System.out.println("Cruise control on. Target speed: " + targetSpeed + " km/h");
            adjustSpeed();
            return true;
        }

        public void turnOffCruise() {
            cruiseOn = false;
            System.out.println("Cruise control off.");
        }

        public double getTargetSpeed() {
            return targetSpeed;
        }

        private void adjustSpeed() {
            if (cruiseOn) {
                if (speed < targetSpeed) {
                    while (speed < targetSpeed && gasolineLevel > 0) {
                        accelerate();
                    }
                } else if (speed > targetSpeed) {
                    while (speed > targetSpeed) {
                        decelerate(5);
                    }
                }
                System.out.println("Car adjusted to " + speed + " km/h");
            }
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        // Accelerate manually
        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        // Turn on cruise control
        boolean success = myCar.turnOnCruise(100);
        if (!success) {
            System.out.println("Cruise control could not be activated.");
        }

        // Decelerate until stop
        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.turnOffCruise();
    }
}

