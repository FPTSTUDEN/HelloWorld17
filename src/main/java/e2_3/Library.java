package e2_3;

// Library.java
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // Task 1: Add, display, find
    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        int i = 1;
        for (Book b : books) {
            System.out.println(i++ + ". " + b);
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Title: \"" + b.getTitle() + "\", Year: " + b.getYear());
            }
        }
    }

    // Task 2: Borrowing system
    public Book borrowBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                books.remove(b);
                return b;
            }
        }
        return null;
    }

    public void returnBook(Book book) {
        books.add(book);
    }

    // Task 3: Availability check
    public boolean isBookAvailable(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Task 5: Statistics
    public double getAverageBookRating() {
        if (books.isEmpty()) return 0;
        double sum = 0;
        for (Book b : books) sum += b.getRating();
        return sum / books.size();
    }

    public Book getMostReviewedBook() {
        Book mostReviewed = null;
        int maxReviews = -1;
        for (Book b : books) {
            if (b.getReviews().size() > maxReviews) {
                maxReviews = b.getReviews().size();
                mostReviewed = b;
            }
        }
        return mostReviewed;
    }

    // Task 6: Users
    public void addUser(User user) {
        users.add(user);
    }

    public void listUsers() {
        System.out.println("Library Users:");
        for (User u : users) {
            System.out.println(u);
        }
    }
}

