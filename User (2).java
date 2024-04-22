package onlineshoppingsystem;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mariam
 */
public class User {
    private String name;
    private String email;
    private String username;
    private String password;
    private long phoneNo;
    private int age;
    private String address;
    private static int accountNo = 0;
    public static int error = 0;

    public User() {
        int op = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Login or Register");
        String option = input.next();
        if (option.equalsIgnoreCase("Register")) {
            op = 2;
        }
        switch (op) {
            case 2: {
                register();
                break;
            }
            default:
                login();
                break;
            // default is to login not to register
        }

    }

    public User(String email) {
        register(email);
    }

    public void register(String email) {
        this.email = email;
        accountNo++;
        username = "User" + Integer.toString(accountNo); // first user will be User1 and 2nd will be User2 and so on
        // we need to generate random password
        String pw = "";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@?$ ";
        Random r = new Random();
        for (int i = 0; i < 12; i++) {
            int x = r.nextInt(63); // generates random integer between 0 and 63 excluding 63
            x++;
            String c = characters.substring(x - 1, x); // obtains a random character
            pw = pw.concat(c);
        }
        this.password = pw;
        System.out.println("Your password is: " + password);
        System.out.println(toString());
    }

    public void register() {
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email address: ");
        this.email = input.next();
        setName();
        System.out.println("Enter Username: ");
        this.username = input.next();
        setPassword();
        setPhoneNo();
        setAge();
        System.out.println("Enter Address: ");
        this.address = input.next();
        System.out.println(toString());
    }

    public void login() {
        accountNo++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter email address: ");
        String enteredEmail = input.next();
        System.out.println("Enter Password: ");
        String enteredPassword = input.next();

        if (enteredPassword != this.getPassword()) {
            System.out.println("Invalid Password, retry");
            if (error >= 2) {
                System.out.println(error + 1 + " invalid attempts");
                try {
                    System.out.println("Please retry in a few seconds...");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                error++;
                // waiting
                login();
            }
            error++;
            login();
        }
    }

    @Override
    public String toString() {
        return "User information: Name: " + name + "/n email: " + email + "/n username: " + username + "/n age: " + age
                + "/n address: " + address + "/n account number: " + accountNo + "/n phone number: " + phoneNo;
    }

    // setters and getters
    public String getName() {
        return name;
    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        String enteredName;
        int errorName = 0;
        try {
            System.out.println("Enter Name: ");
            enteredName = input.next();
            for (int i = 1; i <= enteredName.length(); i++) {
                if (enteredName.substring(i - 1, i).matches(".*[0-9].*")) {
                    errorName = 1;

                }

            }
            if (errorName == 0) {
                this.name = enteredName;
            } else {
                System.out.println("Invalid name, retry");
                setName();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Name, retry");
            setName();
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password: ");
        String enteredPassword = input.next();
        if (enteredPassword.length() < 8) {
            System.out.println("Password can't be less than 8 characters, retry");
            setPassword();
        } else {
            this.password = enteredPassword;
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge() throws IllegalArgumentException {

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter age: ");
            int age = input.nextInt();

            if (age < 0 | age > 100) {

                System.out.println("Invalid age, age must be an integer between 0 and 100");
                setAge();
            } else {
                this.age = age;
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid age, age must be an integer between 0 and 100");
            setAge();
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo() {
        Scanner input = new Scanner(System.in);
        long enteredphoneNo;
        try {
            System.out.println("Enter phone number: ");
            enteredphoneNo = input.nextLong();
            String phone = Long.toString(enteredphoneNo);
            if (phone.length() != 11 ) { // checks if number is not 11 digits
                System.out.println("Invalid phone number, phone number must be 11 digit integer");
                setPhoneNo();
            } else {
                this.phoneNo = enteredphoneNo;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid phone number, phone number must be 11 digit integer");
            setPhoneNo();
        }
    }

    public static int getAccountNo() {
        return accountNo;
    }
}
