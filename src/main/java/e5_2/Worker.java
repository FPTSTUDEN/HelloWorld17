package e5_2;

public class Worker implements Runnable {
    private final ThreadSafeArrayList<Integer> sharedList;

    public Worker(ThreadSafeArrayList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // synchronized add() and print the current list
            synchronized (sharedList) {
                sharedList.add(i);
                System.out.println("Current list: " + sharedList.toString());
            }
            if (i % 2 == 0) {
                synchronized (sharedList) {
                    sharedList.remove(i);
                    System.out.println("Current list: " + sharedList.toString());
                }
            }
        }
    }
}
