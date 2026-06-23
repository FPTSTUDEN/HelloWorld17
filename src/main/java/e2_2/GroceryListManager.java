package e2_2;
import java.util.*;

public class GroceryListManager {

    // --- Task 1: Simple list of items ---
    private ArrayList<String> groceryListArray = new ArrayList<>();

    // --- Task 2: Items with cost ---
    private HashMap<String, Double> groceryListCost = new HashMap<>();

    // --- Task 3: Categorized items ---
    private HashMap<String, String> groceryListCategory = new HashMap<>();

    // --- Task 4: Items with quantity ---
    private static class GroceryItem {
        String name;
        double cost;
        String category;
        int quantity;

        GroceryItem(String name, double cost, String category, int quantity) {
            this.name = name;
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }
    private HashMap<String, GroceryItem> groceryListQuantity = new HashMap<>();

    // ---------------- Task 1 Methods ----------------
    public void addItemArray(String item) { groceryListArray.add(item); }
    public void removeItemArray(String item) { groceryListArray.remove(item); }
    public void displayListArray() {
        System.out.println("Task 1 Grocery List:");
        for (int i = 0; i < groceryListArray.size(); i++) {
            System.out.println((i+1) + ". " + groceryListArray.get(i));
        }
    }
    public boolean checkItemArray(String item) { return groceryListArray.contains(item); }

    // ---------------- Task 2 Methods ----------------
    public void addItemCost(String item, double cost) { groceryListCost.put(item, cost); }
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (double cost : groceryListCost.values()) {
            totalCost += cost;
        }
        return totalCost;
    }
    public void displayListCost() {
        System.out.println("Task 2 Grocery List with Costs:");
        groceryListCost.forEach((item, cost) -> System.out.println(item + " - $" + cost));
    }

    // ---------------- Task 3 Methods ----------------
    public void addItemCategory(String item, double cost, String category) {
        groceryListCategory.put(item, category);
        groceryListCost.put(item, cost);
    }
    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (String item : groceryListCategory.keySet()) {
            if (groceryListCategory.get(item).equals(category)) {
                System.out.println(item + " - $" + groceryListCost.get(item));
            }
        }
    }

    // ---------------- Task 4 Methods ----------------
    public void addItemQuantity(String item, double cost, String category, int quantity) {
        groceryListQuantity.put(item, new GroceryItem(item, cost, category, quantity));
    }
    public void updateQuantity(String item, int newQuantity) {
        if (groceryListQuantity.containsKey(item)) {
            groceryListQuantity.get(item).quantity = newQuantity;
        }
    }
    public void displayAvailableItems() {
        System.out.println("Available items:");
        for (GroceryItem item : groceryListQuantity.values()) {
            if (item.quantity > 0) {
                System.out.println(item.name + " - $" + item.cost + " - " + item.quantity + " in stock");
            }
        }
    }
    // public double calculateTotalCostWithQuantity() {
    //     return groceryListQuantity.values().stream()
    //         .mapToDouble(i -> i.cost * i.quantity).sum();
    // }

    // ---------------- Task 5 Tester ----------------
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Task 1 demo
        manager.addItemArray("Apples");
        manager.addItemArray("Milk");
        manager.addItemArray("Bread");
        manager.displayListArray();
        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItemArray("Milk"));
        manager.removeItemArray("Milk");
        System.out.println("\nAfter removing Milk:");
        manager.displayListArray();

        // Task 4 demo
        manager.addItemQuantity("Eggs", 0.2, "Dairy", 12);
        manager.updateQuantity("Eggs", 6);
        manager.displayAvailableItems();
        // System.out.println("Total cost with quantities: $" + manager.calculateTotalCostWithQuantity());
    }
}
