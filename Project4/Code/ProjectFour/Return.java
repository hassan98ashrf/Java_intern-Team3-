package ProjectFour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Return {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void returnBook(Member member, Book book, String returnDateStr) {
        try {
            Date returnDate = dateFormat.parse(returnDateStr);

            if (member.getBorrowedBooks().contains(book)) {
                returnBookAvailable(member,book,returnDateStr,returnDate);
            } else {
                System.out.println("This book was not borrowed by " + member.getName());
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
        }
    }

    public  void returnBookAvailable(Member member, Book book, String returnDateStr,Date returnDate){
        member.removeBorrowedBook(book);
        book.setAvailable(true);
        calculateFine(book, returnDate);
        book.setBorrowDate(null);
        System.out.println(member.getName() + " returned " + book.getTitle() + " on " + returnDateStr);

    }

    private void calculateFine(Book book, Date returnDate) {
        Date borrowDate = book.getBorrowDate();

        if (borrowDate != null) {
            long daysBorrowed = calculateBorrowDate(returnDate,borrowDate);
            long dueDays = 14;
            if (daysBorrowed > dueDays) {
                getFine(daysBorrowed,dueDays);
            } else {
                System.out.println("No overdue fine.");
            }
        }
    }

    private  long calculateBorrowDate(Date returnDate,Date borrowDate ){
        long borrowDuration = returnDate.getTime() - borrowDate.getTime();
        long daysBorrowed = TimeUnit.MILLISECONDS.toDays(borrowDuration);
        return daysBorrowed;
    }

    private void getFine(long daysBorrowed,long dueDays){
        long overdueDays = daysBorrowed - dueDays;
        long fine = overdueDays * 2;
        System.out.println("Overdue by " + overdueDays + " days. Fine: " + fine);
    }


}
