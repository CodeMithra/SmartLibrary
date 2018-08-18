import static java.lang.System.exit;

public class Main implements Globalvariables {
    public static void main(String args[]){
        while(true){
            System.out.println("1: Add Book to database\n2: Add Student to database\n3: Add Transaction details\n4: Select this option to exit" );
            System.out.println("Enter your choice:");
            String choice = reader.next();
            switch (choice){
                case "1":System.out.println("Enter the Book details!");
                         addBook();
                         break;

                case "2":System.out.println("Enter the Student details!");
                         addStudent();
                         break;

                case "3":System.out.println("Enter the Transaction details!");
                         addTransaction();
                         break;

                case "4":exit(0);
                         default:
                             System.out.println("You have Entered a wrong choice! Re-enter the choice again!!");
                             break;
            }
        }
    }
    private static void addStudent(){
        Student student = new Student();
        student.insertStudentToDB();
    }
    private static void addBook(){
        Book newBook = new Book();
        newBook.insertBookToDB();
    }
    private static void addTransaction(){
        Transaction transaction = new Transaction();
        transaction.insertTransactionToDB();
    }
}
