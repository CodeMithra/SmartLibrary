import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String args[]){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/gautam/IdeaProjects/SmartLibrary/library.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Book (bookdb_id INTEGER ,bookdb_name TEXT,bookdb_author TEXT, bookdb_publication TEXT,bookdb_isbn TEXT,bookdb_taken INTEGER)");
            statement.execute("INSERT into Book values (1,'physics','dc pandey','arihant','12345',0)");


            Book book = new Book(2, "physics", "dc pandey", "arihant", "12345", 0);
            Transaction transaction = new Transaction(book, 12, "23-9-1998", "23-08-1996");
            System.out.println("---------------------------------------------------------------");
            Student student = new Student(121, "karthik", 99802, "karthik.2396@gmail.com", "#7,3rd B Main Road,brindavan layout", transaction);
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }

    }
}
