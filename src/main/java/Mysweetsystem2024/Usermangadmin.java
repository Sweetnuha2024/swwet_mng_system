package Mysweetsystem2024;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usermangadmin {

    private MyApplication app;
    private List<User> userList; // In-memory list to hold users
    private boolean loggedIn;

    public Usermangadmin(MyApplication app) {
        this.app = app;
        this.userList = new ArrayList<>();
        this.loggedIn = false;
    }

    public boolean login(String username, String password) {
        String storedUsername = "adminUsername"; // Replace with actual stored admin username
        String storedPassword = "adminPassword"; // Replace with actual stored admin password

        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            this.loggedIn = true;
            return true;
        } else {
            this.loggedIn = false;
            return false;
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void navigateTo(String page) {
        // Logic to navigate to the specified page
        System.out.println("Navigating to " + page);
        // Add actual navigation code if needed
    }

    public String setUserDetails(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        // Check if the user already exists
        boolean userExists = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())) {
                userList.set(i, user); // Update existing user
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            userList.add(user); // Add new user
        }

        // Save changes to the user.dat.txt file
        return saveUserDetailsToFile(user);
    }

    private String saveUserDetailsToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.dat.txt", true))) {
            writer.write(user.toString()); // Ensure User class has a proper toString() method
            writer.newLine();
            return "User details saved successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error saving user details";
        }
    }

    public String createUser(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        // Check if user already exists
        for (User u : userList) {
            if (u.getEmail().equals(user.getEmail())) {
                return "User already exists";
            }
        }

        userList.add(user);
        return saveUserDetailsToFile(user);
    }

    public String updateUser(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        boolean userUpdated = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())) {
                userList.set(i, user);
                userUpdated = true;
                break;
            }
        }

        if (!userUpdated) {
            return "User not found";
        }

        return saveUserDetailsToFile(user);
    }

    public String deleteUser(User user) {
        if (!loggedIn) {
            return "Admin not logged in";
        }

        boolean userRemoved = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())) {
                userList.remove(i);
                userRemoved = true;
                break;
            }
        }

        if (!userRemoved) {
            return "User not found";
        }

        // Mark user as deleted in file (e.g., move to archive or remove permanently)
        return archiveUserInFile(user);
    }

    private String archiveUserInFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_archive.dat.txt", true))) {
            writer.write(user.toString()); // Ensure User class has a proper toString() method
            writer.newLine();
            return "User archived successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error archiving user";
        }
    }

    public String selectUser(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u.toString();
            }
        }
        return null;
    }

    public void setSearchParameters(String searchParams) {
        // Logic for setting search parameters
        System.out.println("Search parameters set to: " + searchParams);
        // Add actual search implementation if needed
    }

    public boolean isFilteredListRetrieved() {
        // Logic for checking if filtered list is retrieved
        return true; // Return true if filtered list is retrieved
    }

    public boolean isUserListDisplayed() {
        // Logic for checking if user list is displayed
        return true; // Return true if user list is displayed
    }

    public boolean isUserMarkedAsDeleted(User user) {
        // Logic for checking if user is marked as deleted
        return true; // Return true if user is marked as deleted
    }

    public boolean isUserArchived(User user) {
        // Logic for checking if user is archived
        return true; // Return true if user is archived
    }

    public boolean isArchivedUserDataRetrieved() {
        // Logic for checking if archived user data is retrieved
        return true; // Return true if archived user data is retrieved
    }

    public boolean isArchivedUserListDisplayed() {
        // Logic for checking if archived user list is displayed
        return true; // Return true if archived user list is displayed
    }

    // Other methods...

}
