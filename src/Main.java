import java.awt.dnd.peer.DragSourceContextPeer;
import java.sql.*;
import java.util.Scanner;
import java.util.Date;



public class Main {
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        Date date = new Date();
        System.out.println(date.getHours());
        while(true){
            System.out.println("Enter a new Book?");
            String choice = reader.next();
            if (choice.equals("n"))
                break;
            Book newBook = new Book();
            newBook.insertBookToDB();
            System.out.println("------------------------------");
            Student student = new Student();
            student.insertStudentToDB();
            System.out.println("------------------------------");
            Transaction transaction = new Transaction(newBook,student);
            transaction.insertTransactionToDB();
        }

    }
}
