package Mysweetsystem2024;

import java.util.Map;

public class LoginManager {
	private Map<String, User> users;

    public LoginManager(Map<String, User> users) {
        this.users = users;
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("The username does not exist in system.");
            return false;
        }
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            System.out.println("Wrong password, please try again.");
            return false;
        }
    }
    
}


