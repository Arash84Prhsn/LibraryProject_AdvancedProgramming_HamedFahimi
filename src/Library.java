import java.util.ArrayList;

public class Library {
    // Classs attributes:
    private String libararyName;
    private int libararyID;
    private ArrayList<Book> booksList;
    private ArrayList<Member> membersList;
    private Manager manager;
    private ArrayList<Employee> employeesList;

    // Getter methods:
    public String getName(){return this.libararyName;}
    public Manager getManager() {return this.manager;}
    public int getID(){return this.libararyID;}
    public ArrayList<Employee> getEmployeesList() {return this.employeesList;}
    public ArrayList<Member> getMembersList() {return this.membersList;}
    public ArrayList<Book> getBooksList() {return this.booksList;}

    // Constructor:
    public Library(String libararyName, int libararyID, Manager manager) {
        this.libararyName = libararyName;
        this.libararyID = libararyID;
        this.manager = manager;
        this.booksList = new ArrayList<>();
        this.membersList = new ArrayList<>();
        this.employeesList = new ArrayList<>();
    }

    public Library(String libraryName, int LibraryID) {
        this.libararyName = libraryName;
        this.libararyID = LibraryID;
        this.manager = null;
        this.booksList = new ArrayList<>();
        this.membersList = new ArrayList<>();
        this.employeesList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.booksList.add(book);
    }

    public boolean removeBook(Book book) {
        return this.booksList.remove(book);
    }

    public void addMember(Member member) {
        this.membersList.add(member);
    }

    public boolean removeMember(Member member) {
        return this.membersList.remove(member);
    }

    public void addEmployee(Employee employee) {
        this.employeesList.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return this.employeesList.remove(employee);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void addEmplyee(Employee employee) {
        this.employeesList.add(employee);
    }

    public Member getMemberByName(String name) {
        
        for (Member member : this.getMembersList())
            if (member.getName().equals(name))
                return member;

        return null;
    }

    public Member getMemberByID(int id) {

        for (Member member : this.getMembersList())
            if (member.getMembershipID() == id)
                return member;

        return null;
    }
    
    public Member getMemberByPhoneNumber(int id) {

        for (Member member : this.getMembersList())
            if (member.getPhoneNumber() == id)
                return member;

        return null;
    }

    
    public ArrayList<Book> getBooksByAuthor(String author) {
        
        ArrayList<Book> books = new ArrayList<>();
        
        for (Book book : this.getBooksList())
            if (book.getAuthor().equals(author))
                books.add(book);

        return books;
    }

    public ArrayList<Book> getBooksByCategory(String category) {
        
        ArrayList<Book> books = new ArrayList<>();
        
        for (Book book : this.getBooksList())
            if (book.getCategory().equals(category))
                books.add(book);

        return books;
    }   

    public ArrayList<Book> getBooksByName(String name) {
        
        ArrayList<Book> books = new ArrayList<>();
        
        for (Book book : this.getBooksList())
            if (book.getName().equals(name))
                books.add(book);

        return books;
    }


    @Override
    public String toString() {
        String line = "-------------------------------------------------------------------------------------------------";
        System.out.println(line);
        System.out.println(line);
        System.out.println(line);
        return String.format("Library Name: %s%nLibrary ID: %d%nManager: %s%nNumber of Employees: %d%nNumber of Members: %d%nNumber of Books: %d%nBooks: \n" + this.getBooksList() + line +
                             "%nMembers :\n" + this.getMembersList() + line +"%nEmployees:\n" + this.getEmployeesList() + line,
                             this.getName(), this.getID(), this.getManager().getName(), this.getEmployeesList().size(), this.getMembersList().size(), this.getBooksList().size(), line,line);
    }
    

}
