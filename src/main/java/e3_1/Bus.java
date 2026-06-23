package e3_1;

public class Bus extends Car {
    private int passengers;
    private int capacity;

    public Bus(String typeName, double gasolineCapacity, double startSpeed, int capacity) {
        super(typeName, gasolineCapacity, startSpeed);
        this.capacity = capacity;
        this.passengers = 0;
    }

    public void passengerEnter() {
        if (passengers < capacity) {
            passengers++;
            System.out.println("One passenger entered. Total: " + passengers);
        } else {
            System.out.println("Bus is full!");
        }
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("One passenger exited. Total: " + passengers);
        } else {
            System.out.println("No passengers to exit.");
        }
    }

    public int getPassengerCount() {
        return passengers;
    }
}

