package e3_2.task2;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("gas","red");
        Vehicle bus = new Bus("diesel","red",40);
        

        car.start();
        System.out.println(car.getInfo());
        car.stop();

        bus.start();
        System.out.println(bus.getInfo());
        bus.stop();

    }
}

