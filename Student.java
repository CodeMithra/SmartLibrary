public class Student {
    private int student_id;
    private String student_name;
    private int student_contact;
    private String student_email;
    private String student_address;
    private Transaction noofbooks[]=new Transaction[3];

    public Student(int student_id, String student_name, int student_contact, String student_email, String student_address, Transaction[] noofbooks) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_contact = student_contact;
        this.student_email = student_email;
        this.student_address = student_address;
        this.noofbooks = noofbooks;
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

    public Transaction[] getNoofbooks() {
        return noofbooks;
    }
}
