package e3_2.task3;

public class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle(String color) {
        super("Electric Motorcycle", "Electricity", color);
    }

    @Override
    public void charge() {
        System.out.println("Electric Motorcycle is charging...");
    }
}
