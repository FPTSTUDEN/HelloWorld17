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
        // // Print the first 10 numbers for verification
        // System.out.print("First 10 numbers: ");
        // for (int i = 0; i < 10; i++) {
        //     System.out.print(numbers[i] + " ");
        // }
        // System.out.println(); // Print a newline

        // Step 2: Detect number of processor cores
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processor cores: " + cores);

        // Step 3: Divide array into equal portions
        int chunkSize = size / cores;
        SumWorker[] workers = new SumWorker[cores];
        // Thread[] threads = new Thread[cores];

        long startTime = System.nanoTime();

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end =  start + chunkSize;
            if (i == cores - 1) {
                end = size; // last chunk takes the remainder
            }
            workers[i] = new SumWorker(numbers, start, end);
            // threads[i] = new Thread(workers[i], "Worker-" + i);
            workers[i].start();
        }

        // Step 4: Wait for all threads and combine results
        long totalSum = 0;
        for (int i = 0; i < cores; i++) {
            try {
                workers[i].join();
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
class SumWorker extends Thread {
    private int[] arr;
    private int start, end;
    private long partialSum;

    public SumWorker(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    // @Override
    public void run() {
        partialSum = 0;
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
        System.out.println(Thread.currentThread().getName() +
                " computed sum = " + partialSum);
        Thread.yield(); // hint to scheduler that this thread is willing to yield its current use of a processor
    }

    public long getPartialSum() {
        return partialSum;
    }
}

