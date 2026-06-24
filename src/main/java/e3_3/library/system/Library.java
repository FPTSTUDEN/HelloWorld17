package e3_3.library.system;

import e3_3.library.model.Book;
import e3_3.library.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void borrowBook(String memberId, Book book) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) { //member.getBorrowedBooks().size() < 5 && 
                member.borrowBook(book);
                break;
            }
        }
    }

    public void returnBook(String memberId, Book book) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) {
                member.returnBook(book);
                break;
            }
        }
    }
    public void reserveBook(String memberId, Book book) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId) && !book.isReserved()) {
                member.reserveBook(book);
                System.out.println(member.getName() + " reserved: " + book.getTitle());
                break;
            }
        }
    }

    public void cancelReservation(String memberId, Book book) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId) && book.isReserved()) {
                member.cancelReservation(book);
                System.out.println(member.getName() + " canceled reservation for: " + book.getTitle());
                break;
            }
        }
    }

    public void displayReservedBooks(String memberId) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) {
                System.out.println(member.getName() + " has reserved:");
                for (Book book : member.getReservedBooks()) {
                    System.out.println("- " + book.getTitle());
                }
                break;
            }
        }
    }

}
