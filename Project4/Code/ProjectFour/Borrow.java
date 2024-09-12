package ProjectFour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrow {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void borrowBook(Member member, Book book, String borrowDateStr) {
        try {
            Date borrowDate = dateFormat.parse(borrowDateStr);
            if (book.isAvailable()) {
                bookAvailable(member,book,borrowDateStr,borrowDate);
            } else {
                System.out.println(book.getTitle() + " is not available.");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
        }
    }

    public void bookAvailable(Member member, Book book, String borrowDateStr,Date borrowDate ){
        member.addBorrowedBook(book);
        book.setAvailable(false);
        book.setBorrowDate(borrowDate);
        System.out.println(member.getName() + " borrowed " + book.getTitle() + " on " + borrowDateStr);
    }

}

