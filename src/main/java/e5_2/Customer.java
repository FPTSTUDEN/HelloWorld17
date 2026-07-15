package e5_2;
public class Customer implements Runnable {
    private final TicketReservation reservationSystem;
    private final int seatNumber;

    public Customer(TicketReservation reservationSystem, int seatNumber) {
        this.reservationSystem = reservationSystem;
        this.seatNumber = seatNumber;
    }

    @Override
    public void run() {
        reservationSystem.reserveSeat(seatNumber);
    }
}
