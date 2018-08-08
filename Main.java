public class Main {
    public static void main(String args[]){
        Book book = new Book(2, "physics","dc pandey","arihant","12345",false);
        System.out.println("book id= "+book.getBook_id());
        System.out.println("book name= "+book.getBook_name());
        System.out.println("book author= "+book.getBook_author());
        System.out.println("book publication= "+book.getBook_publication());
        System.out.println("book isbn= "+book.getBook_isbn());
        System.out.println("book taken= "+book.isBook_taken());
        Transaction transaction1 = new Transaction(book,12,"23-9-1998","23-08-1996");
        Transaction transaction2 = new Transaction(book,13,"23-9-1997","23-08-1998");
        Transaction transaction3 = new Transaction(book,14,"23-9-1996","23-08-1995");
        System.out.println("---------------------------------------------------------------");
        Transaction[] arr = {transaction1,transaction2,transaction3};
        Student student = new Student(121,"karthik",99802,"karthik.2396@gmail.com","#7,3rd B Main Road,brindavan layout",arr);
        System.out.println("student id = "+student.getStudent_id());
        System.out.println("student name = "+student.getStudent_name());
        System.out.println("student contact = "+student.getStudent_contact());
        System.out.println("student email = "+student.getStudent_email());
        System.out.println("student address = "+student.getStudent_address());
        for(int i=0;i<arr.length;i++) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Transaction no "+ i);
            System.out.println("Transaction id = " + student.getNoofbooks()[i].getTransaction_id());
            System.out.println("Transaction book id = " + student.getNoofbooks()[i].getT_bookid());
            System.out.println("Transaction taken date = " + student.getNoofbooks()[i].getT_taken_date());
            System.out.println("Transaction ending date = " + student.getNoofbooks()[i].getT_ending_date());
        }
    }
}
