import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Book implements Globalvariables{
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublication;
    private String bookIsbn;
    private String bookCategory;
    private boolean bookTaken;

    public Book() {
        System.out.println("Enter book id:");
        this.bookId = reader.next();
        System.out.println("Enter book name:");
        this.bookName = reader.next();
        System.out.println("Enter book author:");
        this.bookAuthor = reader.next();
        System.out.println("Enter book publication:");
        this.bookPublication = reader.next();
        System.out.println("Enter book isbn:");
        this.bookIsbn = reader.next();
        System.out.println("Enter book category:");
        this.bookCategory = reader.next();
        System.out.println("Enter whether book is issued or not:");
        this.bookTaken = reader.nextBoolean();
    }
    public void insertBookToDB() {
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Books (bookdb_id TEXT PRIMARY KEY NOT NULL ,bookdb_name TEXT ,bookdb_author TEXT , bookdb_publication TEXT ,bookdb_isbn TEXT,book_category TEXT ,bookdb_taken INTEGER)");
            statement.execute("INSERT into Books values ('" + bookId + "','" + bookName + "','" + bookAuthor + "','" + bookPublication + "','" + bookIsbn + "','"+ bookCategory +"','" + bookTaken + "')");
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public String getBook_id() {
        return bookId;
    }

    public String getBook_name() {
        return bookName;
    }

    public String getBook_author() {
        return bookAuthor;
    }

    public String getBook_publication() {
        return bookPublication;
    }

    public String getBook_isbn() {
        return bookIsbn;
    }

    public String getBookCategory() { return bookCategory; }

    public boolean isBook_taken() {
        return bookTaken;
    }


}
