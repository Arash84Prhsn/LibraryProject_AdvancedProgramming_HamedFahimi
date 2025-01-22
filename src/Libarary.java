import java.util.ArrayList;

public class Libarary {
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
    public Libarary(String libararyName, int libararyID, Manager manager) {
        this.libararyName = libararyName;
        this.libararyID = libararyID;
        this.manager = manager;
        this.booksList = new ArrayList<>();
        this.membersList = new ArrayList<>();
        this.employeesList = new ArrayList<>();
    }

    public Libarary(String libraryName, int LibraryID) {
        this.libararyName = libraryName;
        this.libararyID = LibraryID;
        this.manager = null;
        this.booksList = new ArrayList<>();
        this.membersList = new ArrayList<>();
        this.employeesList = new ArrayList<>();
    }

}
