package ProjectFour;

import java.util.Scanner;

public class LMS {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void initialBookData(Library library)
    {
        library.addBook(new Book("Palace Walk", "Nagib Mahfouz", "12345"));
        library.addBook(new Book("The Yacoubian Building", "Alaa Al Aswany", "67890"));
        library.addBook(new Book("The Map of Love", "Ahdaf Soueif", "54321"));
    }

    public static void addBook(Library library)
    {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        library.addBook(new Book(title, author, isbn));
    }

    public static void removeBook(Library library)
    {
        System.out.print("Enter book ISBN to remove: ");
        String isbnRemove = scanner.nextLine();
        library.removeBook(isbnRemove);
    }

    public static void registerMember(Library library)
    {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter membership ID: ");
        String membershipID = scanner.nextLine();
        library.registerMember(new Member(name, membershipID));
    }

    public static Member getAndCheckMemberID()
    {
        System.out.print("Enter membership ID: ");
        String borrowMemberID = scanner.nextLine();
        Member borrowMember = library.findMemberByID(borrowMemberID);
        return borrowMember;
    }

    public static Book getAndCheckISBN()
    {
        System.out.print("Enter book ISBN to borrow: ");
        String borrowISBN = scanner.nextLine();
        Book borrowBook = library.findBookByISBN(borrowISBN);
        return borrowBook;
    }

    public static void getDateOfBorrow(Member borrowMember,Book borrowBook  )
    {
        System.out.print("Enter borrow date (dd-MM-yyyy): ");
        String borrowDate = scanner.nextLine();
        new Borrow().borrowBook(borrowMember, borrowBook, borrowDate);
    }

    public static void getDateOfReturn(Member returnMember,Book returnBook  )
    {
        System.out.print("Enter return date (dd-MM-yyyy): ");
        String returnDate = scanner.nextLine();
        new Return().returnBook(returnMember, returnBook, returnDate);
    }


    public static void main(String[] args) {

        initialBookData(library);
        System.out.println("Library Management System");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Books");
            System.out.println("7. Display Members");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(library);
                    break;
                case 2:
                    removeBook(library);
                    break;
                case 3:
                    registerMember(library);
                    break;
                case 4:
                    Member borrowMember = getAndCheckMemberID();
                    if (borrowMember == null) {
                        System.out.println("Member not found!");
                        break;
                    }
                    Book borrowBook = getAndCheckISBN();
                    if (borrowBook == null) {
                        System.out.println("Book not found!");
                        break;
                    }
                    getDateOfBorrow(borrowMember,borrowBook);
                    break;
                case 5:
                    Member returnMember = getAndCheckMemberID();
                    if (returnMember == null) {
                        System.out.println("Member not found!");
                        break;
                    }
                    Book returnBook = getAndCheckISBN();
                    if (returnBook == null) {
                        System.out.println("Book not found!");
                        break;
                    }
                    getDateOfReturn(returnMember,returnBook);
                    break;
                case 6:
                    library.displayBooks();
                    break;
                case 7:
                    library.displayMembers();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

}
