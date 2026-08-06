package e8_3;

import java.util.*;

class Person {
    String name;
    int age;
    String city;

    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " (" + age + ") - " + city;
    }
}

public class LambdaTask1 {
    public static void main(String[] args) {
        // Step 1: Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Bob", 30, "Chicago"));
        people.add(new Person("Charlie", 22, "New York"));
        people.add(new Person("Diana", 28, "Los Angeles"));
        people.add(new Person("Ethan", 35, "New York"));

        // Step 2: Sort by age using lambda and Comparator
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        System.out.println("Sorted by age:");
        people.forEach(System.out::println);

        // Step 3: Filter by city (keep only New York)
        people.removeIf(p -> !p.city.equals("New York"));

        System.out.println("\nFiltered by city (New York only):");
        people.forEach(System.out::println);
    }
}

