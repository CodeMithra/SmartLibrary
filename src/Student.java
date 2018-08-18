import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.exit;

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
        this.noOfBooks = 0;
    }
    public Student(String studentId){
        this.studentId = studentId;
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
    public void removeStudentFromDB(){
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Students WHERE student_id = '"+getStudentId()+"'");
            System.out.println("Deletion successful");
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public void editStudentInfo(){
        try {
            Connection conn = DriverManager.getConnection(path);
            Statement statement = conn.createStatement();
            System.out.println("1: Change in student name\n2: Change in student Contact\n3: Change in student Email\n" +
                        "4: Change in student Address\n5: Change in student noOfBooks\n6: Select this option to exit");
            System.out.println("Enter your choice:");
            String choice = reader.next();
            switch (choice) {
                    case "1":System.out.println("Enter the student name to be changed:");
                             String studentName = reader.next();
                             statement.execute("UPDATE Students SET student_name = '"+studentName+"' where student_id = '"+getStudentId()+"'");
                             break;

                    case "2":System.out.println("Enter the student Contact to be changed:");
                             Long studentContact = reader.nextLong();
                             statement.execute("UPDATE Students SET student_contact = '"+studentContact+"' where student_id = '"+getStudentId()+"'");
                             break;

                    case "3":System.out.println("Enter the student Email to be changed:");
                             String studentEmail = reader.next();
                             statement.execute("UPDATE Students SET student_email = '"+studentEmail+"' where student_id = '"+getStudentId()+"'");
                             break;

                    case "4":System.out.println("Enter the student Address to be changed:");
                             String studentAddress = reader.next();
                             statement.execute("UPDATE Students SET student_address = '"+studentAddress+"' where student_id = '"+getStudentId()+"'");
                             break;
            }
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getStudentContact() {
        return studentContact;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }
}
