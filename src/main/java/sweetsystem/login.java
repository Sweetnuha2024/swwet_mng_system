package sweetsystem;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        UserDatabase userManager = new UserDatabase();
        AuthService authService = new AuthService(userManager);

        // Pre-register a user for testing purposes
        System.out.println(authService.register("shahd", "822003"));

        Scanner scanner = new Scanner(System.in);

        // Prompt user for username and password
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Login scenario
        System.out.println("");
        System.out.println(authService.login(username, password));

        // Close the scanner
        scanner.close();
    }
}

