import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    private int student_id;
    private String student_name;
    private int student_contact;
    private String student_email;
    private String student_address;
    private int noofbooks;

    public Student() {
        Scanner reader = new Scanner(System.in);
        this.student_id = reader.nextInt();
        this.student_name = reader.next();
        this.student_contact = reader.nextInt();
        this.student_email = reader.next();
        this.student_address = reader.next();
        this.noofbooks = noofbooks;
    }

    public void insertStudentToDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/karthikgr/IdeaProjects/SmartLibrary/library.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists Students (student_id INTEGER PRIMARY KEY NOT NULL ,student_name TEXT,student_contact BIGINT, student_email TEXT,student_address LONGVARCHAR,noofbooks INTEGER)");
            statement.execute("INSERT into Students values ('" + student_id + "','" + student_name + "','" + student_contact + "','" + student_email + "','" + student_address + "','" + noofbooks +"')");
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("something went wrong: "+e.getMessage());
        }
    }


    public int getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_contact() {
        return student_contact;
    }

    public String getStudent_email() {
        return student_email;
    }

    public String getStudent_address() {
        return student_address;
    }

    public int getNoofbooks() {
        return noofbooks;
    }
}
