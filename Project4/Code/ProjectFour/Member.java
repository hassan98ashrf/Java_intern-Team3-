package ProjectFour;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String membershipID;
    private List<Book> borrowedBooks;

    public Member(String name, String membershipID) {
        this.name = name;
        this.membershipID = membershipID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMembershipID() {
        return membershipID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + membershipID + ")";
    }
}
