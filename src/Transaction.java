import java.sql.*;
import java.util.Scanner;

public class Transaction {
    Scanner scan = new Scanner(System.in);
    private int transaction_id;
    private int transaction_count=0;
    private String T_bookid;
    private String T_studentid;
    private String T_taken_date;
    private String T_ending_date;

    public Transaction(){
        this.transaction_id = scan.nextInt();
        this.T_taken_date = scan.next();
        this.T_ending_date = scan.next();
        System.out.println("Enter the book id: ");
        this.T_bookid = scan.next();
        System.out.println("Enter the Student id: ");
        this.T_studentid = scan.next();
    }

    public void insertTransactionToDB() {
        String query = "select noofbooks from Student where student_id = '" + T_studentid + "'";
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/gautam/IdeaProjects/SmartLibrary/library.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Transactions (transaction_id INTEGER PRIMARY KEY NOT NULL, T_bookid TEXT,T_studentid TEXT,T_taken_date TEXT, T_ending_date TEXT,FOREIGN KEY(T_bookid) REFERENCES Books(bookdb_id),FOREIGN KEY(T_studentid) REFERENCES Students(student_id))");
            ResultSet result = statement.executeQuery(query);
            int booksTaken = result.getInt("noofbooks");
            System.out.println("No of books = "+ booksTaken);
            if(booksTaken <=3)
                statement.execute("INSERT into Transactions values ('" + transaction_id + "','" + T_bookid + "','"+ T_studentid +"','" + T_taken_date + "','" + T_ending_date + "')");
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public int getTransaction_id() {
        return transaction_id;
    }
    public String getT_bookid() {
        return T_bookid;
    }

    public String getT_studentid() {
        return T_studentid;
    }

    public String getT_taken_date() {
        return T_taken_date;
    }
    public String getT_ending_date() {
        return T_ending_date;
    }
    public int getTransaction_count(){ return transaction_count++;}
}