package e2_3;

// LibraryMain.java
public class LibraryMain {
    public static void main(String[] args) {
        // Create books
        Book b1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book b2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book b3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Ratings and reviews
        b1.setRating(4.5);
        b1.addReview("Great for beginners!");
        b2.setRating(4.7);
        b2.addReview("Very detailed.");
        b2.addReview("Excellent reference.");
        b3.setRating(4.0);

        // Create library
        Library library = new Library();
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Display books
        library.displayBooks();

        // Find by author
        library.findBooksByAuthor("Jane Doe");

        // Borrowing
        // User u1 = new User("Michael", 25);
        // library.addUser(u1);
        // u1.borrowBook(library, "Data Structures and Algorithms");

        // // Availability check
        // System.out.println("Is 'Data Structures and Algorithms' available? " + library.isBookAvailable("Data Structures and Algorithms"));

        // // Return book
        // u1.returnBook(library, b2);

        // // Statistics
        // System.out.println("Average Rating: " + library.getAverageBookRating());
        // System.out.println("Most Reviewed Book: " + library.getMostReviewedBook().getTitle());

        // // List users
        // library.listUsers();
    }
}

