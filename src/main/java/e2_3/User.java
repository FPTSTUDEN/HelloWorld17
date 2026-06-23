package e2_3;

// User.java
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void borrowBook(Library library, String title) {
        Book b = library.borrowBook(title);
        if (b != null) {
            borrowedBooks.add(b);
            System.out.println(name + " borrowed \"" + b.getTitle() + "\"");
        } else {
            System.out.println("Book \"" + title + "\" not available.");
        }
    }

    public void returnBook(Library library, Book book) {
        if (borrowedBooks.remove(book)) {
            library.returnBook(book);
            System.out.println(name + " returned \"" + book.getTitle() + "\"");
        }
    }

    @Override
    public String toString() {
        return "User: " + name + ", Age: " + age + ", Borrowed Books: " + borrowedBooks.size();
    }
}

