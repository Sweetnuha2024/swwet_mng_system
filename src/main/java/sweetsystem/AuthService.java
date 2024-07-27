package sweetsystem;
public class AuthService {
    private UserDatabase userManager;

    public AuthService(UserDatabase userManager) {
        this.userManager = userManager;
    }

    public String login(String username, String password) {
        if (userManager.validateUser(username, password)) {
            return "Welcome!";
        }
        return "Failed login";
    }

    public String register(String username, String password) {
        try {
            userManager.addUser(username, password);
            return "Registration successful";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

