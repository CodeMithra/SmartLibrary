public class Book {
    private int book_id;
    private String book_name;
    private String book_author;
    private String book_publication;
    private String book_isbn;
    private boolean book_taken;

    public Book(int book_id, String book_name, String book_author, String book_publication, String book_isbn, boolean book_taken) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_publication = book_publication;
        this.book_isbn = book_isbn;
        this.book_taken = book_taken;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public String getBook_publication() {
        return book_publication;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public boolean isBook_taken() {
        return book_taken;
    }
}
