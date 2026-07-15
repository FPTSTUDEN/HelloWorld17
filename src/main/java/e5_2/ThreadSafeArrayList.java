package e5_2;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeArrayList<T> {
    private final List<T> list = new ArrayList<>();

    public synchronized void add(T element) {
        list.add(element);
        System.out.println(Thread.currentThread().getName() + " added: " + element);
    }

    public synchronized void remove(T element) {
        list.remove(element);
        System.out.println(Thread.currentThread().getName() + " removed: " + element);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized String toString() {
        String listString = "";
        for (T element : list) {
            listString += element + " ";
        }
        return listString.trim();
    }
}

