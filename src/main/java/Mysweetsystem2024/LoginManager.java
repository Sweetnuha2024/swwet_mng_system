package Mysweetsystem2024;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LoginManager {
    private final Map<String, User> users;
    private final Set<String> loggedInUsers;  // To track logged-in users

    public LoginManager(Map<String, User> users) {
        this.users = users;
        this.loggedInUsers = new HashSet<>();
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            System.out.println("Username or password cannot be null.");
            return false;
        }
        User user = users.get(username);
        if (user == null) {
            System.out.println("The username does not exist in the system.");
            return false;
        }
        if (user.getPassword().equals(password)) {
            loggedInUsers.add(username);  // Track successful login
            return true;
        } else {
            System.out.println("Wrong password, please try again.");
            return false;
        }
    }

    public boolean logout(String username) {
        if (username == null) {
            System.out.println("Username cannot be null.");
            return false;
        }
        if (loggedInUsers.remove(username)) {
            return true;
        } else {
            System.out.println("User is not logged in.");
            return false;
        }
    }

    public boolean isUserLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}
