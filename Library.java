import java.util.ArrayList;
import java.util.HashMap;



public class Library {

    private ArrayList<Book> books;
    private HashMap<Borrower,ArrayList<Book>> map;

    public Library(ArrayList<Book> books, HashMap<Borrower, ArrayList<Book>> map) {
        this.books = books;
        this.map = map;
    }

    public void addBook(Book book){
       for(Book b : books){
           if(b.getIsbn() == book.getIsbn()){
               b.setQuantity(b.getQuantity()+ book.getQuantity());
               return;
           }
       }
       books.add(book);
    }

    public boolean searchBookByTitle(String title){
        for(Book b : books){
            if(b.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    public boolean searchBookByAuthor(String author){
        for(Book b : books){
            if(b.getAuthor().equalsIgnoreCase(author)){
                return true;
            }
        }
        return false;
    }

    public boolean searchBookByIsbn(int isbn){
        for(Book b : books){
            if(b.getIsbn() == isbn){
                return true;
            }
        }
        return false;
    }
        //upon issung  the book will be updated in the map as well as the list of borrower
    public void issueBook(int isbn, Borrower borrower){ //first the borrower will search if the book is available or not, then he will issue the book
       Book bookToIssue = null;

       //fetch the book to be issued
       for(Book b : books){
           if(b.getIsbn() == isbn){
               bookToIssue = b;
               break;
           }
       }

       //check if the book was found
       if(bookToIssue == null){
           System.out.println("The book with the input isbn is not present" );
           return;
       }

       //check if book is availabe
        if(bookToIssue.getQuantity()==0){
            System.out.println("All the copies of the given isbn book has already been issued, please come later!");
            return;
        }

        //issue the book
        if (!map.containsKey(borrower)) { //if borrower is not in the map this will run
            map.put(borrower, new ArrayList<>()); //this will add the value of map (mapping of borrower and the list of books he has issued
        }
        map.get(borrower).add(bookToIssue); //this will update in the map with the issued book and borrower
        //map.get() will fetch the arraylist for the borrower
        borrower.addIssued_book(isbn); //this will add the book to the borrower's list
        bookToIssue.setQuantity(bookToIssue.getQuantity()-1);
    }

    public void returnBook(int isbn, Borrower borrower){
        Book bookToReturn = null;
        for(Book b : books){
            if(b.getIsbn() == isbn){
                bookToReturn = b;
                break;
            }
        }
        // Check if the book exists in the library
        if (bookToReturn == null) {
            System.out.println("Book with ISBN " + isbn + " not found in the library.");
            return;
        }
        // Check if the borrower has the book issued
        if (!map.containsKey(borrower) || !map.get(borrower).contains(bookToReturn)) {
            System.out.println("This borrower hasn't issued the book with ISBN " + isbn + ".");
            return;
        }
            //the below lines will return the book updating the values acordingly
        map.get(borrower).remove(bookToReturn);
        bookToReturn.setQuantity(bookToReturn.getQuantity()+1);


    }

    public void deleteBook(int isbn){
        Book bookToBeDeleted = null;
        for(Book b : books){
            if(b.getIsbn() ==isbn){
                bookToBeDeleted = b;
                break;
            }
        }

        //check if the book is present in the library or not
        if(bookToBeDeleted == null){
            System.out.println("The book with the given isbn do not exist in the library");
            return;
        }

        books.remove(bookToBeDeleted);
        System.out.println("The requested book has been successfully deleted");
    }

    public void viewAllBooks(){
        System.out.println("Title    Author    ISBN    Quantity");
        for (Book b : books){
            System.out.println(b.getTitle()+"    "+b.getAuthor()+"    "+b.getIsbn()+"    "+b.getQuantity());
        }
    }

    public void viewIssuedBooks(Borrower borrower){
        ArrayList<Book> issuedBooks = map.get(borrower);
        if (issuedBooks == null || issuedBooks.isEmpty()) {
            System.out.println(borrower.getName() + " has not issued any books.");
            return;
        }

        System.out.println("Books issued by " + borrower.getName() + ":");
        System.out.printf("%-20s %-20s %-10s%n", "Title", "Author", "ISBN");
        for (Book b : issuedBooks) {
            System.out.printf("%-20s %-20s %-10d%n", b.getTitle(), b.getAuthor(), b.getIsbn());
        }
    }






}