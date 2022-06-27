package mim.mmgh;

import java.util.Random;
import java.util.Scanner;

public class Email {

    public Scanner sc = new Scanner(System.in);

    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailboxCapacity = 500;
    private String alternateEmail;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + fname + " " + lname);
        this.dept = setDept();
        this.password = generatePassword(8);
        this.email = generateEmail();

    }

    //Generate email method
    private String generateEmail() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".com";
    }

    //Ask for department
    private String setDept() {
        System.out.println("Department codes \n1. IT \n2. HR " + "\n3. Accounting \n4. Sales \n5. Marketing");
        boolean flag = false;
        do {
            System.out.println("Enter department code: ");
            int deptCode = sc.nextInt();
            switch (deptCode) {
                case 1:
                    return "IT";
                case 2:
                    return "HR";
                case 3:
                    return "Accounting";
                case 4:
                    return "Sales";
                case 5:
                    return "Marketing";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid department code, try again! ");
                    flag = true;
            }
        } while (!flag);
        return null;
    }

    // generate random password method
    private String generatePassword(int length) {
        Random rnd = new Random();
        String Capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smalls = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%&?";
        String values = Capitals + smalls + numbers + special;
        String password = "";
        for (int i = 0; i < length; i++) {
            password += values.charAt(rnd.nextInt(values.length()));
        }
        return password;
    }

    // generate farsi password method
    private String generateFarsiPassword(int length) {
        Random rnd = new Random();
        String Capitals = "آابپتثجچحخدذرزژسشصضطظعغفقکگلمنوهی";
        String smalls = "أإبپتثجچحخدذرزژسشصضطظعغفقکگلمنوهی";
        String numbers = "0123456789";
        String special = "!@#$%&?";
        String values = Capitals + smalls + numbers + special;
        String password = "";
        for (int i = 0; i < length; i++) {
            password += values.charAt(rnd.nextInt(values.length()));
        }
        return password;
    }

    // change password method
    public void changePassword() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password? (y/n)");
            char answer = sc.next().charAt(0);
            if (answer == 'y' | answer == 'Y') {
                flag = true;
                System.out.println("Enter your old password: ");
                String temp = sc.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter your new password: ");
                    String newPassword = sc.next();
                    this.password = newPassword;
                    System.out.println("Password changed successfully!");
                } else {
                    System.out.println("Wrong password, try again!");
                }
            } else if (answer == 'n' | answer == 'N') {
                flag = true;
                System.out.println("Password not changed!");
            } else {
                System.out.println("Invalid answer, try again!");
            }
        } while (!flag);
    }

    // set mailbox capacity method
    public void setMailboxCapacity() {
        System.out.println("current capacity: " + this.mailboxCapacity);
        System.out.println("Enter new capacity: ");
        this.mailboxCapacity = sc.nextInt();
        System.out.println("Capacity changed to " + this.mailboxCapacity + "successfully!");
    }

    // set alternate email method + email validation method
    public void setAlternateEmail() {
        System.out.println("Enter new alternate email: ");
        if (this.alternateEmail.contains("@")) {
            this.alternateEmail = sc.next();
            System.out.println("Alternate email changed to " + this.alternateEmail + "successfully!");
        } else {
            System.out.println("Invalid email, try again!");
            setAlternateEmail();
        }
    }

    //Display Employee details method
    public void displayEmployeeDetails() {
        System.out.println("Employee Details: ");
        System.out.println("First Name: " + this.fname);
        System.out.println("Last Name: " + this.lname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailboxCapacity);
        System.out.println("Alternate Email: " + this.alternateEmail);
    }

}



