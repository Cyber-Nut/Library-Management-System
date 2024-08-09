public class Book {
    private String title, author;
    private  int quantity, isbn;

    public Book(String title, String author, int quantity, int isbn) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
