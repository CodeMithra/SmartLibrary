import java.sql.*;
import java.util.Scanner;

public class Transaction implements Globalvariables{
    private int transactionId;
    private int transactionCount=0;
    private String tBookId;
    private String tStudentId;
    private String tTakenDate;
    private String tEndingDate;

    public Transaction(){
        System.out.println("Enter Transaction id:");
        this.transactionId = reader.nextInt();
        System.out.println("Enter Transaction taken date:");
        this.tTakenDate = reader.next();
        System.out.println("Enter Transaction Ending date:");
        this.tEndingDate = reader.next();
        System.out.println("Enter the book id: ");
        this.tBookId = reader.next();
        System.out.println("Enter the Student id: ");
        this.tStudentId = reader.next();
    }

    public void insertTransactionToDB() {
        String query = "select noofbooks from Students where student_id = '" + tStudentId + "'";
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Transactions (transaction_id INTEGER PRIMARY KEY NOT NULL, T_bookid TEXT,T_studentid TEXT,T_taken_date TEXT, T_ending_date TEXT,FOREIGN KEY(T_bookid) REFERENCES Books(bookdb_id),FOREIGN KEY(T_studentid) REFERENCES Students(student_id))");
            ResultSet result = statement.executeQuery(query);
            int booksTaken = result.getInt("noofbooks");
            if(booksTaken <3) {
                statement.execute("INSERT into Transactions values ('" + transactionId + "','" + tBookId + "','" + tStudentId + "','" + tTakenDate + "','" + tEndingDate + "')");
                booksTaken++;
                statement.execute("UPDATE Students SET noofbooks = '"+booksTaken+"' where student_id = '"+tStudentId+"'");
                System.out.println("No of books = "+ booksTaken);
            }
            else
                System.out.println("Books can't be issued! :)");
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public int getTransaction_id() {
        return transactionId;
    }
    public String getT_bookid() {
        return tBookId;
    }

    public String getT_studentid() {
        return tStudentId;
    }

    public String getT_taken_date() {
        return tTakenDate;
    }
    public String getT_ending_date() {
        return tEndingDate;
    }
    public int getTransaction_count(){ return transactionCount++;}
}