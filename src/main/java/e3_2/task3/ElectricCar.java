package e3_2.task3;

public class ElectricCar extends AbstractVehicle {
    public ElectricCar(String color) {
        super("Electric Car", "Electricity", color);
    }

    @Override
    public void charge() {
        System.out.println("Electric Car is charging...");
    }
}
