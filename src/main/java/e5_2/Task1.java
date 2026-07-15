package e5_2;
public class Task1 {
    public static void main(String[] args) {
        TicketReservation reservationSystem = new TicketReservation(10);

        Thread c1 = new Thread(new Customer(reservationSystem, 5), "Customer-1");
        Thread c2 = new Thread(new Customer(reservationSystem, 5), "Customer-2");
        Thread c3 = new Thread(new Customer(reservationSystem, 7), "Customer-3");

        c1.start();
        c2.start();
        c3.start();
    }
}
