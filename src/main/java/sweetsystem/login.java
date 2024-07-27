package sweetsystem;


import java.util.Scanner;

public class login {

    public static void main(String[] args) {
        // Add a user to simulate an existing user
        UserDatabase.addUser("shahd", "822003");

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check login credentials
        if (UserDatabase.usernameExists(username)) {
            if (UserDatabase.validatePassword(username, password)) {
                System.out.println("User is now in the system.");
                System.out.println("Welcome, " + username + "!");
            } else {
                System.out.println("User is now out of the system.");
                System.out.println("Failed login: Invalid password.");
            }
        } else {
            System.out.println("User is now out of the system.");
            System.out.println("Failed login: Invalid username.");
        }

        // Close the scanner
        scanner.close();
    }
}
