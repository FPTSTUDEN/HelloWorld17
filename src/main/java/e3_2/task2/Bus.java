package e3_2.task2;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String fuel, String color, int capacity) {
        super("Bus", fuel, color);
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity + " passengers";
    }
}
