import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Book {
    private String book_id;
    private String book_name;
    private String book_author;
    private String book_publication;
    private String book_isbn;
    private String book_category;
    private boolean book_taken;

    public Book() {
        System.out.println("Please enter the book details:\n");
        Scanner reader = new Scanner(System.in);
        this.book_id = reader.next();
        this.book_name = reader.next();
        this.book_author = reader.next();
        this.book_publication = reader.next();
        this.book_isbn = reader.next();
        this.book_category = reader.next();
        this.book_taken = reader.nextBoolean();
    }

    public void insertBookToDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/gautam/IdeaProjects/SmartLibrary/library.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Books (bookdb_id TEXT PRIMARY KEY NOT NULL ,bookdb_name TEXT,bookdb_author TEXT, bookdb_publication TEXT,bookdb_isbn TEXT,book_category TEXT,bookdb_taken INTEGER)");
            statement.execute("INSERT into Books values ('" + book_id + "','" + book_name + "','" + book_author + "','" + book_publication + "','" + book_isbn + "','"+ book_category +"','" + book_taken + "')");
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }

    public String getBook_id() {
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
