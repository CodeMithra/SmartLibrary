import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student implements Globalvariables{
    private String studentId;
    private String studentName;
    private long studentContact;
    private String studentEmail;
    private String studentAddress;
    private int noOfBooks;

    public Student() {

        System.out.println("Enter student id:");
        this.studentId = reader.next();
        System.out.println("Enter student name:");
        this.studentName = reader.next();
        System.out.println("Enter student contact:");
        this.studentContact = reader.nextLong();
        System.out.println("Enter student email:");
        this.studentEmail = reader.next();
        System.out.println("Enter student address:");
        this.studentAddress = reader.next();
        this.noOfBooks = noOfBooks;
    }
    public void insertStudentToDB() {
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Students (student_id TEXT PRIMARY KEY NOT NULL ,student_name TEXT ,student_contact BIGINT, student_email TEXT ,student_address LONGVARCHAR,noofbooks INTEGER)");
            statement.execute("INSERT into Students values ('" + studentId + "','" + studentName + "','" + studentContact + "','" + studentEmail + "','" + studentAddress + "','" + noOfBooks +"')");
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }


    public String getStudent_id() {
        return studentId;
    }

    public String getStudent_name() {
        return studentName;
    }

    public Long getStudent_contact() {
        return studentContact;
    }

    public String getStudent_email() {
        return studentEmail;
    }

    public String getStudent_address() {
        return studentAddress;
    }

    public int getNoofbooks() {
        return noOfBooks;
    }
}
