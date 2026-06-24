package e3_3.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;
    private List<Book> reservedBooks; // new list

    public LibraryMember(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public void reserveBook(Book book) {
        reservedBooks.add(book);
        book.setReserved(true);
    }

    public void cancelReservation(Book book) {
        reservedBooks.remove(book);
        book.setReserved(false);
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }
    public String getMemberId() {return this.memberId;}
    public String getName() {return this.name;}
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
