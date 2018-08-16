import java.util.Scanner;


public class Main {
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        while(true){
            System.out.println("Enter a new Book?y/n");
            String choice = reader.next();
            if (choice.equals("y")) {
                Book newBook = new Book();
                newBook.insertBookToDB();
                System.out.println("------------------------------");
                Student student = new Student();
                student.insertStudentToDB();
                System.out.println("------------------------------");
                Transaction transaction = new Transaction(newBook, student);
                transaction.insertTransactionToDB();
            }
            else
                break;
        }

    }
}
