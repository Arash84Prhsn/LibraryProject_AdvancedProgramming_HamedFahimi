// Arash Poorhasani 4021299123 AdvancedProgramming library Project.
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library_Driver 
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Library library = null;

        while(true) {
            try {
                // Take input to initialize the library:
                System.out.println("Input the name of your library: ");
                String libraryName = input.nextLine();
                
                System.out.println("Input the ID of your library: ");
                int libraryID = input.nextInt();
                input.nextLine();
                if (libraryID < 0) throw new IllegalArgumentException("The ID of the library cannot be negative.");
                
                System.out.println("Input the name of the manager: ");
                String managerName = input.nextLine();
                
                System.out.println("Input the ID of the manager: (Please input an integer only)");
                int managerID = input.nextInt();
                input.nextLine();
                if (managerID < 0) throw new IllegalArgumentException("The ID of the manager cannot be negative.");
                
                System.out.println("Input the age of the manager: (Please input an integer only)");
                int managerAge = input.nextInt();
                input.nextLine();
                if (managerAge < 0) throw new IllegalArgumentException("The age of the manager cannot be negative.");
                
                System.out.println("Input the salary of the manager: (Please input a number, decimal points are allowed)");
                double managerSalary = input.nextDouble();
                input.nextLine();
                if (managerSalary < 0) throw new IllegalArgumentException("The salary of the manager cannot be negative.");
                
                // instantiate the manager object:
                Manager manager = new Manager(managerName, managerID, managerAge, managerSalary);

                // Initialize the library:
                library = new Library(libraryName, libraryID, manager);

                break;
            }
            
            catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Please pay attention to certain input constraints.");
                continue;
            }

            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        
        boolean continueProgram = true;
        
        while(continueProgram) {
            try {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("You can manage your library using the following options: (Enter an integer matching the option)");
                System.out.println("1. Add a book to the library 2. Add a member to the library 3. Add an employee to the library 4. Remove an employee from the libaray\n" + 
                                   "5. Manage a member 6. Search for a member 7. Remove a member\n8. Search for Books 9. Remove a book\n" + 
                                   "10. Show library 11. Exit the program \n\nPlease input the number of the option you want to choose: ");
                
                int option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 11:
                        System.out.println("Exiting the program...");
                        
                        continueProgram = false;
                        break;
                    
                    case 1:
                        System.out.println("Input the name of the book: ");
                        String bookName = input.nextLine();
                        
                        System.out.println("Input the ISBN of the book: (Integer only) ");
                        int bookISBN = input.nextInt();
                        input.nextLine();
                        if (bookISBN < 0) throw new IllegalArgumentException("The ISBN of the book cannot be negative.");
                        
                        System.out.println("Input the author of the book: ");
                        String bookAuthor = input.nextLine();
                        
                        System.out.println("Input the category of the book: ");
                        String bookCategory = input.nextLine();

                        Book book = new Book(bookName, bookISBN, bookAuthor, bookCategory);
                        library.getBooksList().add(book);

                        System.out.println("The book has been added to the library successfully.");
                        break;

                    case 2 :
                        System.out.println("Input the name of the member: ");
                        String memberName = input.nextLine();
                        
                        System.out.println("Input the membership ID of the member: (Integer only)");
                        int memberID = input.nextInt();
                        input.nextLine();
                        if (memberID < 0) throw new IllegalArgumentException("The ID of the member cannot be negative.");
                        
                        System.out.println("Input the phone number of the member: (Integer only)");
                        int memberPhoneNumber = input.nextInt();
                        input.nextLine();
                        if (memberPhoneNumber < 0) throw new IllegalArgumentException("The phone number of the member cannot be negative.");
                        
                        System.out.println("Input the sign up date of the member: ");
                        String memberSignUpDate = input.nextLine();

                        System.out.println("Is the member a special member? (true/false)");
                        boolean isSpecialMember = input.nextBoolean();
                        input.nextLine();

                        Member member = new Member(memberName, memberID, memberPhoneNumber, memberSignUpDate, isSpecialMember);
                        library.getMembersList().add(member);

                        System.out.println("The member has been added to the library successfully.");
                        break;

                    case 3:
                        System.out.println("Input the name of the employee: ");
                        String employeeName = input.nextLine();
                        
                        System.out.println("Input the ID of the employee: (Integer only)");
                        int employeeID = input.nextInt();
                        input.nextLine();
                        if (employeeID < 0) throw new IllegalArgumentException("The ID of the employee cannot be negative.");
                        
                        System.out.println("Input the age of the employee: (Integer only)");
                        int employeeAge = input.nextInt();
                        input.nextLine();
                        if (employeeAge < 0) throw new IllegalArgumentException("The age of the employee cannot be negative.");
                        
                        System.out.println("Input the salary of the employee: (Number only)");
                        double employeeSalary = input.nextDouble();
                        input.nextLine();
                        if (employeeSalary < 0) throw new IllegalArgumentException("The salary of the employee cannot be negative.");
                        
                        System.out.println("Input the role of the employee: ");
                        String employeeRole = input.nextLine();

                        System.out.println("Input the section of the employee: ");
                        String employeeSection = input.nextLine();

                        Employee employee = new Employee(employeeName, employeeID, employeeAge, employeeSalary, employeeRole, employeeSection);
                        library.addEmployee(employee);

                        System.out.println("The employee has been added to the library successfully.");
                        break;


                    case 4:
                        System.out.println("Input the name of the employee you would like to remove: ");
                        String employeeName2 = input.nextLine();
                        Employee employee2 = null;
                        for (Employee e : library.getEmployeesList()) {
                            if (e.getName().equals(employeeName2)) {
                                employee2 = e;
                                break;
                            }
                        }

                        if (employee2 == null) {
                            System.out.println("The employee you are looking for does work in the library.");
                            return;
                        }

                        library.removeEmployee(employee2);
                        System.out.println("The employee has been removed from the library successfully.");
                        break;
                    
                    case 5:
                        manageMember(library);
                        break;
                    
                    case 6:
                        Member member2 = searchMember(library);
                        System.out.println("The member has been found: \n" + member2);
                        break;

                    case 7:
                        System.out.println("Please specify the member you would like to remove: ");
                        Member member3 = searchMember(library);
                        library.removeMember(member3);
                        System.out.println("Member removed successfully.");
                        break;
                    case 8:
                        ArrayList<Book> books = SearchBooks(library);
                        System.out.println("The books have been found: ");
                        System.out.println(books);
                        break;
                        
                    case 9:
                        System.out.println("Input the name of the book you would like to remove: ");
                        String bookName2 = input.nextLine();
                        Book book2 = null;
                        for (Book b : library.getBooksList()) {
                            if (b.getName().equals(bookName2)) {
                                book2 = b;
                                break;
                            }
                        }

                        if (book2 == null) {
                            System.out.println("The book you are looking for does not exist in the library.");
                            return;
                        }

                        library.getBooksList().remove(book2);
                        System.out.println("The book has been removed from the library successfully.");
                        break;
                        
                    case 10:
                        System.out.println(library);
                        break;
                
                    default:
                        throw new IllegalArgumentException("Invalid option. Please input a valid option.");
                    
                    
                }
                

            }

            catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Please pay attention to certain input constraints.\n");
                continue;
            }

            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()+"\n");
                continue;
            }
        }

        

    }// End of main-------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------
    private static ArrayList<Book> SearchBooks(Library library) throws IllegalArgumentException, InputMismatchException {

        Scanner input = new Scanner(System.in);
        
        System.out.println("How would you like to search for the books?");
        System.out.println("1. Search by name 2. Search by author 3. Search by category");
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.println("Input the name of the book: ");
                String name = input.nextLine();
                
                return library.getBooksByName(name);
            
            case 2:
                System.out.println("Input the author of the book: ");
                String author = input.nextLine();
                
                return library.getBooksByAuthor(author);

            case 3:
                System.out.println("Input the category of the book: ");
                String category = input.nextLine();
                
                return library.getBooksByCategory(category);
            
            default:
                
                throw new IllegalArgumentException("Invalid option. Please input a valid option.");
        }



    }

    private static Member searchMember(Library library) throws IllegalArgumentException, InputMismatchException{

        Scanner input = new Scanner(System.in);

        System.out.println("How would you like to search for the member?");
        System.out.println("1. Search by name \n2. Search by ID \n3. Search by phone number");

        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.println("Input the name of the member: ");
                String name = input.nextLine();
                
                return library.getMemberByName(name);
            
            case 2:
                System.out.println("Input the ID of the member: ");
                int id = input.nextInt();
                input.nextLine();
                
                return library.getMemberByID(id);

            case 3:
                System.out.println("Input the phone number of the member: ");
                int phoneNumber = input.nextInt();
                input.nextLine();
                
                return library.getMemberByPhoneNumber(phoneNumber);
            
            default:
                
                throw new IllegalArgumentException("Invalid option. Please input a valid option.");
        }

    }


    private static void manageMember(Library library) throws IllegalArgumentException, InputMismatchException{

        
        System.out.println("Pleas specify the member you would like to manage: ");
        Member member = searchMember(library);
        
        
        System.out.println("How would you like to manage the member?");
        System.out.println("1. Borrow a book \n2. Return a book \n3. Edit the member's info");  
        
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            
            case 1:
                System.out.println("Input the name of the book you would like to borrow: ");
                String bookName = input.nextLine();
                Book book = null;
                for (Book b : library.getBooksList()) {
                    if (b.getName().equals(bookName)) {
                        book = b;
                        break;
                    }
                }

                if (book == null) {
                    System.out.println("The book you are looking for does not exist in the library.");
                    return;
                }

                member.borrowBook(book);
                break;

            case 2:
                System.out.println("Input the name of the book you would like to return: ");
                String bookName2 = input.nextLine();
                Book book2 = null;
                for (Book b : member.getBorrowedBooksList()) {
                    if (b.getName().equals(bookName2)) {
                        book2 = b;
                        break;
                    }
                }

                if (book2 == null) {
                    System.out.println("The book you are looking for is not borrowed by the member.");
                    return;
                }

                member.returnBook(book2);
                break;

            case 3:
                
                System.out.println("What would you like to edit?");
                System.out.println("1. Name \n2. Membership ID \n3. Phone number \n4. Subscription status \n5. Special member status");
                int editOption = input.nextInt();
                input.nextLine();

                switch (editOption) {
                    case 1:
                        System.out.println("Input the new name of the member: ");
                        String name = input.nextLine();
                        member.setName(name);
                        break;

                    case 2:
                        System.out.println("Input the new membership ID of the member: ");
                        int id = input.nextInt();
                        input.nextLine();
                        member.setMembershipID(id);
                        break;

                    case 3:
                        System.out.println("Input the new phone number of the member: ");
                        int phoneNumber = input.nextInt();
                        input.nextLine();
                        member.setPhoneNumber(phoneNumber);
                        break;


                    case 4:
                        System.out.println("Input the new subscription status of the member: input true/false for active/inactive subscription");
                        boolean subscriptionStatus = input.nextBoolean();
                        input.nextLine();
                        member.setSubscriptionStatus(subscriptionStatus);

                    case 5:
                        System.out.println("Do you want to make the member a special member? (true/false)");
                        boolean isSpecialMember = input.nextBoolean();
                        input.nextLine();
                        if (isSpecialMember)  {
                            if (member.isSpecialMember()) {
                                System.out.println("The member is already a special member.");
                                return;
                            }
                            member.makeSpecialMember();
                        }
                        else member.makeNormalMember();
                        break;

                    }//End inner switch
                
                }//End outer Switch
    
            }//End manage member method.

}// End of Library_Driver class.
