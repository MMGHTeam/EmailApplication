package mim.mmgh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String f_name = sc.nextLine();
        System.out.println("Enter last name: ");
        String l_name = sc.nextLine();
        Email email = new Email(f_name, l_name);
        int choice = -1;
        do {
            System.out.println("\n ****** \n Enter choice: \n 1. Show Info \n 2. Change password \n 3. Change Mailbox capacity \n 4. Set Alternate email \n 5. Store in file \n 6. Read from file \n 7. Exit ******");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    email.displayEmployeeDetails();
                    break;
                case 2:
                    email.changePassword();
                    break;
                case 3:
                    email.setMailboxCapacity();
                    break;
                case 4:
                    email.setAlternateEmail();
                    break;
                case 5:
                    System.out.println("Store data to file");
                    email.storeFile();
                    break;
                case 6:
                    System.out.println("Load data from file");
                    email.readFile();
                    break;
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }

        }while (choice != 5);
    }
}
