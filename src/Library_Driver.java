import java.util.InputMismatchException;
import java.util.Scanner;

public class Library_Driver 
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        while(true) {
            try {
                // Take input to initialize the library:
                System.out.println("Input the name of your library: ");
                String libraryName = input.nextLine();
                System.out.println("Input the ID of your library: ");
                int libraryID = input.nextInt();
                if (libraryID < 0) {
                    throw new IllegalArgumentException("The ID of the library cannot be negative.");
                }
                input.nextLine();
                System.out.println("Input the name of the manager: ");
                String managerName = input.nextLine();
                System.out.println("Input the ID of the manager: (Please input an integer only)");
                int managerID = input.nextInt();
                System.out.println("Input the age of the manager: (Please input an integer only)");
                int managerAge = input.nextInt();
                System.out.println("Input the salary of the manager: (Please input a number, decimal points are allowed)");
                double managerSalary = input.nextDouble();
                input.nextLine();
                
                Manager manager = new Manager(managerName, managerID, managerAge, managerSalary);

                // Initialize the library:
                Libarary library = new Libarary(libraryName, libraryID, manager);

                break;
            }
            
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please pay attention to certain input constraints.");
                continue;
            }
        }
        
        while(true) {
            try {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("You can manage your library using the following options:");
                System.out.println("1. Add a book to the library \n2. Add a member to the library \n3. Add an employee to the library\n" + 
                                "4. Manage a member \n5. Search for a member \n6. Remove a member\n" + 
                                "7. Exit the program \nPlease input the number of the option you want to choose: ");

                


            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please pay attention to certain input constraints.");
                continue;
            }

            catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please pay attention to certain input constraints.");
                continue;
            }
        }



    }// End of main

}// End of Library_Driver class
