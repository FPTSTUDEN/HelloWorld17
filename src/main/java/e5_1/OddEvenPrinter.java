package e5_1;
public class OddEvenPrinter {
    public static void main(String[] args) {
        // Thread for odd numbers
        Thread oddThread = new Thread(new OddPrinter(), "OddThread");
        // Thread for even numbers
        Thread evenThread = new Thread(new EvenPrinter(), "EvenThread");

        // Start both threads
        oddThread.start();
        evenThread.start();
    }
}

// Runnable for printing odd numbers
class OddPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // pause for readability
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Runnable for printing even numbers
class EvenPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // pause for readability
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
