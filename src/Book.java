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
    public Book(String bookId){
        this.bookId = bookId;
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
    public void removeBookFromDB(){
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Books WHERE bookdb_id = '"+getBookId()+"'");
            System.out.println("Deletion successful");
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public void editBookInfo(){
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            System.out.println("1: Change in book name\n2: Change in author name\n3: Change in publication name\n" +
                    "4: Change in book isbn\n5: Change in book category\n6: Select this option to exit");
            System.out.println("Enter your choice:");
            String choice = reader.next();
            switch (choice) {
                case "1":System.out.println("Enter the book name to be changed:");
                    String bookName = reader.next();
                    statement.execute("UPDATE Books SET bookdb_name = '"+bookName+"' where bookdb_id = '"+getBookId()+"'");
                    break;

                case "2":System.out.println("Enter the author name to be changed:");
                    String bookAuthor = reader.next();
                    statement.execute("UPDATE Books SET bookdb_author = '"+bookAuthor+"' where bookdb_id = '"+getBookId()+"'");
                    break;

                case "3":System.out.println("Enter the publication name to be changed:");
                    String bookPublication = reader.next();
                    statement.execute("UPDATE Books SET bookdb_publication = '"+bookPublication+"' where bookdb_id = '"+getBookId()+"'");
                    break;

                case "4":System.out.println("Enter the ISBN to be changed:");
                    String bookIsbn = reader.next();
                    statement.execute("UPDATE Books SET bookdb_isbn = '"+bookIsbn+"' where bookdb_id = '"+getBookId()+"'");
                    break;

                case "5":System.out.println("Enter the book category to be changed:");
                    String bookCategory = reader.next();
                    statement.execute("UPDATE Books SET bookdb_category = '"+bookCategory+"' where bookdb_id = '"+getBookId()+"'");
                    break;
            }
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPublication() {
        return bookPublication;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getBookCategory() { return bookCategory; }

    public boolean isBookTaken() {
        return bookTaken;
    }


}
