package e5_2;

public class Task2 {
    public static void main(String[] args) {
        ThreadSafeArrayList<Integer> list = new ThreadSafeArrayList<>();

        Thread t1 = new Thread(new Worker(list), "Worker-1");
        Thread t2 = new Thread(new Worker(list), "Worker-2");
        Thread t3 = new Thread(new Worker(list), "Worker-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final size: " + list.size());
        System.out.println("Final list: " + list.toString());
    }
}
