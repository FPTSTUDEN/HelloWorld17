// import java.util.HashSet;
// import java.util.Set;
package e5_2;
public class TicketReservation {
    private int totalSeats;

    public TicketReservation(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public synchronized boolean reserveSeat(int amount) {
        if (this.totalSeats >= amount) {
            this.totalSeats -= amount;
            System.out.println(Thread.currentThread().getName() + " reserved " + amount + " seat(s). Remaining seats: " + this.totalSeats);
            return true;
        }
        System.out.println(Thread.currentThread().getName() + " could not reserve " + amount + " seat(s). Remaining seats: " + this.totalSeats);
        return false;
    }
}
