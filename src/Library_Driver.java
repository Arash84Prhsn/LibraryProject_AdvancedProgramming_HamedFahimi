// Arash Poorhasani 4021299123 AdvancedProgramming library Project.
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
                if (libraryID < 0) throw new IllegalArgumentException("The ID of the library cannot be negative.");
                input.nextLine();
                
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
                System.out.println("1. Add a book to the library \n2. Add a member to the library \n3. Add an employee to the library\n" + 
                                   "4. Manage a member \n5. Search for a member \n6. Remove a member\n7. Manage a book" + 
                                   "8. Exit the program \nPlease input the number of the option you want to choose: ");
                
                int option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 8:
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


                    default:
                        throw new IllegalArgumentException("Invalid option. Please input a valid option.");
                }

                


            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please pay attention to certain input constraints.");
                continue;
            }

            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        input.close();

    }// End of main

}// End of Library_Driver class
