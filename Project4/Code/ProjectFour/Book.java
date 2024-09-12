package ProjectFour;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;
    private Date borrowDate;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ")";
    }
}