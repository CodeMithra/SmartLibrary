import static java.lang.System.exit;

public class Main implements Globalvariables {
    public static void main(String args[]){
        while(true){
            System.out.println("1: Add Book to database\n2: Add Student to database\n3: Add Transaction details\n"+
                    "4: Remove Book from database\n5: Remove Student from database\n6: Remove Transaction from database\n" +
                    "7: Edit the book information\n8: Edit the student information\n9: Select this option to exit" );
            System.out.println("Enter your choice:");
            String choice = reader.next();
            switch (choice){
                case "1":System.out.println("Enter the Book details!");
                         Book newBook = new Book();
                         newBook.insertBookToDB();
                         break;

                case "2":System.out.println("Enter the Student details!");
                         Student student = new Student();
                         student.insertStudentToDB();
                         break;

                case "3":System.out.println("Enter the Transaction details!");
                         Transaction transaction = new Transaction();
                         transaction.insertTransactionToDB();
                         break;

                case "4":System.out.println("Enter the book id to delete from database!");
                         String bookId = reader.next();
                         newBook = new Book(bookId);
                         newBook.removeBookFromDB();
                         break;

                case "5":System.out.println("Enter the student id to delete from database!");
                         String studentId= reader.next();
                         student = new Student(studentId);
                         student.removeStudentFromDB();
                         break;

                case "6":System.out.println("Enter the Transaction id to delete from database!");
                         int transactionId= reader.nextInt();
                         transaction = new Transaction(transactionId);
                         transaction.removeTransactionFromDB();
                         break;

                case "7":System.out.println("Enter the book id to edit in database!");
                         bookId = reader.next();
                         newBook = new Book(bookId);
                         newBook.editBookInfo();
                         break;

                case "8":System.out.println("Enter the student id to edit in database!");
                         studentId = reader.next();
                         student = new Student(studentId);
                         student.editStudentInfo();
                         break;

                case "9": exit(0);

                         default:
                             System.out.println("You have Entered a wrong choice! Re-enter the choice again!!");
                             break;
            }
        }
    }
}
