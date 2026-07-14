package e5_1;

// import java.util.Random;

public class ParallelArraySum {
    public static void main(String[] args) {
        // Step 1: Generate an array of 100000 random integers
        int size = 100000; // int are numbers between -2,147,483,648 and 2,147,483,647
        int[] numbers = new int[size];
        // Random rand = new Random();
        for (int i = 0; i < size; i++) {
            // numbers[i] = rand.nextInt(1000); // random numbers between 0–999
            numbers[i] = (int) (Math.random() * 1000);
        }

        // Step 2: Detect number of processor cores
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processor cores: " + cores);

        // Step 3: Divide array into equal portions
        int chunkSize = size / cores;
        SumWorker[] workers = new SumWorker[cores];
        Thread[] threads = new Thread[cores];

        long startTime = System.nanoTime();

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end =  start + chunkSize;
            if (i == cores - 1) {
                end = size; // last chunk takes the remainder
            }
            workers[i] = new SumWorker(numbers, start, end);
            threads[i] = new Thread(workers[i], "Worker-" + i);
            threads[i].start();
        }

        // Step 4: Wait for all threads and combine results
        long totalSum = 0;
        for (int i = 0; i < cores; i++) {
            try {
                threads[i].join();
                totalSum += workers[i].getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Final Sum = " + totalSum);
        System.out.println("Execution time (ms): " + (endTime - startTime) / 1_000_000);
    }
}

// Worker class for partial summation
class SumWorker implements Runnable {
    private int[] arr;
    private int start, end;
    private long partialSum;

    public SumWorker(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        partialSum = 0;
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
        System.out.println(Thread.currentThread().getName() +
                " computed sum = " + partialSum);
    }

    public long getPartialSum() {
        return partialSum;
    }
}

