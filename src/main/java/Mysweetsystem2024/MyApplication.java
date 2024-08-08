package Mysweetsystem2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
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
        User newUser = new User(username, password, country, email, role);
        addUser(newUser);
    }
    
    
    public void removeUser(String username) {
        users.remove(username);
    }
}