public class Book {

    private String name;
    private int isbn;
    private String author;
    private String category;
    private boolean isBorrowed = false;
    private String borrower = "";
    private Queue<Member> reservers = new Queue<>();

    //getter methods:
    public String getName() {return this.name;}
    public int getIsbn() {return this.isbn;}
    public String getAuthor() {return this.author;}
    public String getCategory() {return this.category;}
    public boolean IsBorrowed() {return this.isBorrowed;}
    public String getBorrower() {return this.borrower;}
    public Queue<Member> getReservers() {return this.reservers;}

    // Constructor:
    public Book(String name, int isbn, String author, String category) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
    }

    // Method to update the borrower of the book:
    public void updateBorrower(Member borrower) {
        this.borrower = borrower.getName();
        this.isBorrowed = true;
    }

    // Method to add a member to the reservers queue:
    public void addReserver(Member member) {
        this.reservers.enqueue(member);
    }

    // Method to remove the borrower of the book:
    public void removeBorrower() {
        
        if (this.getReservers().isEmpty()) {
            this.borrower = "";
            this.isBorrowed = false;
        } 
        
        else 
            this.updateBorrower(this.getReservers().dequeue());
    }


    public String reserversString() {
        String s = "";

        Queue<Member> queue = new Queue<>();

        for (int i = 0; i < this.getReservers().getSize(); i++) {
            Member m = this.getReservers().dequeue();
            queue.enqueue(m);
            s += m.getName() + " | ";
        }

        this.reservers = queue;
        return s;

    }

    @Override
    public String toString() {

        return String.format("Name: %s \nISBN: %d \nAuthor: %s \ncategory: %s\nPeople reserving this book:\n" + this.reserversString() + "\n"
        , this.getName(), this.getIsbn(), this.getAuthor(), this.getCategory());

    }

}