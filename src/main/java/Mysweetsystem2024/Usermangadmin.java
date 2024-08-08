package Mysweetsystem2024;

public class Usermangadmin {
    private MyApplication app;

    public Usermangadmin(MyApplication app) {
        this.app = app;
    }

    // Method to create a new user
    public boolean createUser(User user) {
        if (user == null || app.userExists(user.getUsername())) {
            return false; // User already exists or invalid user
        }
        app.addUser(user); // Add user to the application
        return true; // User created successfully
    }

    // Method to update an existing user
    public boolean updateUser(User updatedUser) {
        if (updatedUser == null || !app.userExists(updatedUser.getUsername())) {
            return false; // User does not exist or invalid user
        }
        app.addUser(updatedUser); // Update the user in the application
        return true; // User updated successfully
    }

    // Method to delete a user
    public boolean deleteUser(String username) {
        if (username == null || !app.userExists(username)) {
            return false; // User does not exist
        }
        app.removeUser(username); // Remove the user from the application
        return true; // User deleted successfully
    }

    // Method to retrieve a user
    public User getUser(String username) {
        return app.getUser(username);
    }
}
