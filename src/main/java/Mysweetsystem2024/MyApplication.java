package Mysweetsystem2024;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;
    private NotificationServices notificationService;

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
        notificationService = new NotificationServices();
        loadUsers();
    }

    public NotificationServices getNotificationService() {
        return notificationService;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
        saveUsers();
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public LoginManager getLoginManager() {
        return loginManager;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public void signUpUser(String username, String password, String email, String country, UserRole role) {
        if (!userExists(username)) {
            addUser(new User(username, password, email, country, role));
        }
    }

    public void removeUser(String username) {
        users.remove(username);
        saveUsers();
    }

    public boolean createUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false; // User already exists
        }

        users.put(user.getUsername(), user);
        saveUsers();
        
        // Send a notification after creating the user
        notificationService.sendNotification(user.getUsername(), "Your account has been created successfully.");

        return true;
    }

    public boolean isUserLoggedIn(String username) {
        return loginManager.isUserLoggedIn(username);
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        File file = new File("users.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (Map<String, User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean updateUser(User user) {
        if (users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user); // Update the user
            saveUsers(); // Save the updated users list
            return true;
        }
        return false;
    }
    

}
