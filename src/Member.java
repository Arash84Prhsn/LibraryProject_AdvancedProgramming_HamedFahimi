import java.util.ArrayList;

public class Member {

    private String name;
    private int membershipID;
    private int phoneNumber;
    private String signUpDate;
    private boolean subscriptionStatus;
    private boolean isSpecialMember = false;
    private ArrayList<Book> borrowedBooks = new ArrayList<>(); // max size 6 for normal members and 9 for special members.

    // getter methods:
    public String getName() {return this.name;}
    public int getMembershipID() {return this.membershipID;}
    public int getPhoneNumber() {return this.phoneNumber;}
    public String getSignUpDate() {return this.signUpDate;}
    public boolean getSubscriptionStatus() {return this.subscriptionStatus;}
    public boolean isSpecialMember() {return this.isSpecialMember;}
    public ArrayList<Book> getBorrowedBooksList() {return this.borrowedBooks;}

    // Constructors:
    public Member(String name, int membershipID, int phoneNumber, String signUpDate, boolean subscriptionStatus) {
        this.name = name;
        this.membershipID = membershipID;
        this.phoneNumber = phoneNumber;
        this.signUpDate = signUpDate;
        this.subscriptionStatus = subscriptionStatus;
        this.isSpecialMember = false;
        this.borrowedBooks = new ArrayList<>();
    }

    public Member (String name, int membershipID, int phoneNumber, String signUpDate, boolean subscriptionStatus, boolean isSpecialMember) {
        
        this.name = name;
        this.membershipID = membershipID;
        this.phoneNumber = phoneNumber;
        this.signUpDate = signUpDate;
        this.subscriptionStatus = subscriptionStatus;
        this.isSpecialMember = isSpecialMember;
        this.borrowedBooks = new ArrayList<>();
    }

    // Setter methods:
    public void setName(String name) {this.name = name;}
    public void setMembershipID(int membershipID) {this.membershipID = membershipID;}
    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setSignUpDate(String signUpDate) {this.signUpDate = signUpDate;}
    public void setSubscriptionStatus(boolean subscriptionStatus) {this.subscriptionStatus = subscriptionStatus;}
    
    public void makeSpecialMember() {this.isSpecialMember = true;}
    public void makeNormalMember() {this.isSpecialMember = false;}

    private boolean canBorrow() {
        if (this.isSpecialMember) {
            return this.borrowedBooks.size() < 9;
        } else {
            return this.borrowedBooks.size() < 6;
        }
    }

    public void borrowBook(Book book) {
        
        if (this.canBorrow() && !book.IsBorrowed()) {
            this.borrowedBooks.add(book);
            return;
        }

        if (this.canBorrow() && book.IsBorrowed()) {
            book.addReserver(this);
            System.out.println("The book <" + book.getName() + "> is currently borrowed by another member.\n" + 
                               "You have been added to the reservation list.");
            return;
        }
        
        if (this.isSpecialMember) 
            System.out.println("You have reached the maximum number of books you can borrow.\n Please return a book to borrow another one.");
        

        else 
            System.out.println("You have reached the maximum number of books you can borrow.\n" + 
                               "Please return a book to borrow another one Or become a special member to borrow more books.");
        
    }

    public void returnBook(Book book) {
        if (!this.borrowedBooks.remove(book))
            System.out.println("Member <" + this.getName() + "> has not borrowed the <" + book.getName() + "> book.");
    }

    public String getBorrowedBooks() {
        if (this.borrowedBooks.size() == 0) {
            return "Member <" + this.getName() + "> has not borrowed any books.";
        }

        String borrowedBooks = "Member <" + this.getName() + "> has borrowed the following books: \n";
        for (Book book : this.borrowedBooks) {
            borrowedBooks += book.getName() + " | ";
        }
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nMembership ID: %d%nPhone number: %d%nSign up date: %s%nSubscription status: %b%nSpecial member: %b%nBorrowed books: %s%n", 
                             this.name, this.membershipID, this.phoneNumber, this.signUpDate, this.subscriptionStatus, this.isSpecialMember, this.getBorrowedBooks());
    }

}// End of Member class
