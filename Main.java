import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //created 3 new books
        Book book1 = new Book("Hello There", "Deva", 2, 94129);
        Book book2 = new Book("The Story", "Divyansh", 1, 89479);
        Book book3 = new Book("Mayhem", "Debu", 5, 87554);


        //created a list of those new books
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        //created a library to handle those books
        HashMap<Borrower,ArrayList<Book>> borrowerMap = new HashMap<>();
        Library library = new Library(bookList,borrowerMap);

        //create some borrowers
        ArrayList<Integer> issuedBooks1 = new ArrayList<>();
        Borrower borrower1 = new Borrower("Alice", 1, issuedBooks1);

        ArrayList<Integer> issuedBooks2 = new ArrayList<>();
        Borrower borrower2 = new Borrower("Bob", 2, issuedBooks2);

        //Add new book to the library
        Book book4 = new Book("In the desert", "Devansh", 4, 123214);
        library.addBook(book4);

        // Issue a book to a borrower
        System.out.println("\nIssuing Book with ISBN 123456 to Alice...");
        library.issueBook(123214, borrower1);

        // View issued books for a borrower
        System.out.println("\nIssued Books for Alice:");
        library.viewIssuedBooks(borrower1);

        // Return a book
        System.out.println("\nReturning Book with ISBN 123456 from Alice...");
        library.returnBook(94129, borrower1);

        // View issued books for a borrower after returning a book
        System.out.println("\nIssued Books for Alice after returning the book:");
        library.viewIssuedBooks(borrower1);

        // Delete a book from the library
        System.out.println("\nDeleting Book with ISBN 345678...");
        library.deleteBook(87554);

        // View all books in the library after deletion
        System.out.println("\nAll Books in the Library after deletion:");
        library.viewAllBooks();

    }
}
