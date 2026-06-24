package e3_3.library;
import e3_3.library.model.Book;
import e3_3.library.model.LibraryMember;
import e3_3.library.system.Library;
public class Main {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();

        // Create book instances
        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Create library members
        LibraryMember member1 = new LibraryMember("Alice", "M001");
        LibraryMember member2 = new LibraryMember("Bob", "M002");

        // Add members to the library
        library.addMember(member1);
        library.addMember(member2);

        // Borrowing operations
        member1.borrowBook(book1);
        System.out.println(member1.getName() + " borrowed: " + book1.getTitle());
        System.out.println(member1.getName() + " now has: ");
        for (Book i : member1.getBorrowedBooks()){
            System.err.println(i.getTitle());
        }

        member2.borrowBook(book2);
        System.out.println(member2.getName() + " borrowed: " + book2.getTitle());

        // Returning operations
        member1.returnBook(book1);
        System.out.println(member1.getName() + " returned: " + book1.getTitle());
        System.out.println(member1.getName() + " now has: ");
        for (Book i : member1.getBorrowedBooks()){
            System.err.println(i.getTitle());
        }
                // Reserve a book
        library.reserveBook("M001", book1);

        // Display reserved books
        library.displayReservedBooks("M001");

        // Cancel reservation
        library.cancelReservation("M001", book1);

        // Display again
        library.displayReservedBooks("M001");
    }
}