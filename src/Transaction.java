public class Transaction {
    private int transaction_id;
    private int T_bookid;
    private String T_taken_date;
    private String T_ending_date;


    public Transaction(Book book,int transaction_id, String t_taken_date, String t_ending_date) {
        this.transaction_id = transaction_id;
        T_taken_date = t_taken_date;
        T_ending_date = t_ending_date;
        T_bookid= book.getBook_id();
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getT_bookid() {
        return T_bookid;
    }

    public String getT_taken_date() {
        return T_taken_date;
    }

    public String getT_ending_date() {
        return T_ending_date;
    }
}
