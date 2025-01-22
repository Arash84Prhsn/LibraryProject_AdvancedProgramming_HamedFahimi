public class Manager {

    private String name;
    private int ID;
    private int age;
    private double salary;

    public String getName() {return this.name;}
    public int getID() {return this.ID;}
    public int getAge() {return this.age;}
    public double getSalary() {return this.salary;}

    public Manager(String name, int ID, int age, double salary) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.salary = salary;
    }

    // Setter methods:
    public void setName(String name) {this.name = name;}
    public void setID(int ID) {this.ID = ID;}
    public void setAge(int age) {this.age = age;}
    public void setSalary(double salary) {this.salary = salary;}

    @Override
    public String toString() {
        return String.format("Name: %s, ID: %d, Age: %d, Salary: %.2f", this.name, this.ID, this.age, this.salary);
    }

}
