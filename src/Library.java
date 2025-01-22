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

}
