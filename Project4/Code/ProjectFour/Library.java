package ProjectFour;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (findBookByISBN(book.getISBN()) != null) {
            System.out.println("Error: A book with ISBN " + book.getISBN() + " already exists.");
        } else {
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
        System.out.println("Book removed with ISBN: " + ISBN);
    }

    public void registerMember(Member member) {
        if (findMemberByID(member.getMembershipID()) != null) {
            System.out.println("Error: A member with ID " + member.getMembershipID() + " already exists.");
        } else {
            members.add(member);
            System.out.println("Member registered: " + member.getName());
        }
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberByID(String membershipID) {
        for (Member member : members) {
            if (member.getMembershipID().equals(membershipID)) {
                return member;
            }
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println(book + (book.isAvailable() ? " (Available)" : " (Checked Out)"));
        }
    }

    public void displayMembers() {
        System.out.println("\nRegistered Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
