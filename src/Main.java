import java.awt.dnd.peer.DragSourceContextPeer;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        while(true){
            System.out.println("Enter a new Book?");
            String choice = reader.next();
            if (choice.equals("n"))
                break;
            Book newBook = new Book();
            newBook.insertBookToDB();

        }

    }
}
