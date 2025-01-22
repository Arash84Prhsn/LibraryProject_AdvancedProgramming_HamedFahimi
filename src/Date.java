import java.util.InputMismatchException;

public class Date {
    
    private int year;
    private int month;
    private int day;

    public Date() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public Date (int day, int month, int year) throws InputMismatchException {

        this.day = day;
        this.month = month;
        this.year = year;

    }

}
