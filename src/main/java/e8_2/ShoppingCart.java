package e8_2;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();

    public void addItem(String name, double price) {
        items.put(name, price);
    }

    public void removeItem(String name) {
        items.remove(name);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
        // Double::doubleValue is a method reference that converts Double objects to primitive double values.
    }
}
