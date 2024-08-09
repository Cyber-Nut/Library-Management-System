import java.util.ArrayList;

public class Borrower {
    private String name;
    private int borrowerId;

    private ArrayList<Integer> issuedBooks;

    public ArrayList<Integer> getIssuedBooks() {
        return issuedBooks;
    }


    public Borrower(String name, int borrowerId, ArrayList<Integer> issuedBooks) {
        this.name = name;
        this.borrowerId = borrowerId;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void removeIssued_book(int isbn) {
        this.issuedBooks.remove(isbn);
    }

    public void addIssued_book(int isbn) {

        if (!issuedBooks.contains(isbn)) { // Check if the book is not already issued
            issuedBooks.add(isbn);
        }
    }
}
