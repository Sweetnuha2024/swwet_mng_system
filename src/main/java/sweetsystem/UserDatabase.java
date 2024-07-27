package sweetsystem;
import java.util.HashMap;
import java.util.Map;



public class UserDatabase {
    private Map<String, User> users;

    public UserDatabase() {
        this.users = new HashMap<>();
    }

    public void addUser(String username, String password) throws Exception {
        if (users.containsKey(username)) {
            throw new Exception("User already exists");
        }
        users.put(username, new User(username, password));
    }

    public boolean validateUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }
        return users.get(username).getPassword().equals(password);
    }
}
