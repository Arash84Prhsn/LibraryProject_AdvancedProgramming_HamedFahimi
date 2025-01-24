public class Employee extends Manager {

    private String role;
    private String section;

    public String getRole() {return this.role;}
    public String getSection() {return this.section;}

    public Employee(String name, int ID, int age, double salary, String role, String section) {
        super(name, ID, age, salary);
        this.role = role;
        this.section = section;
    }                       

    public void setRole(String role) {this.role = role;}
    public void setSection(String section) {this.section = section;}

    @Override
    public String toString() {
        return String.format("Name: %s%nID: %d%nAge: %d%nSalary: %.2f%nRole: %s%nSection: %s\n",
                             this.getName(), this.getID(), this.getAge(), this.getSalary(), this.getRole(), this.getSection());
    }

}
