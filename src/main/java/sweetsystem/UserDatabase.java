package sweetsystem;
import java.util.HashMap;
import java.util.Map;


public class UserDatabase {

	 private static final Map<String, String> users = new HashMap<>();

	  
	    public static void addUser(String username, String password) {
	        users.put(username, password);
	    }

	    // Check if username exists
	    public static boolean usernameExists(String username) {
	        return users.containsKey(username);
	    }

	    // Validate the password for a given username
	    public static boolean validatePassword(String username, String password) {
	        return users.get(username).equals(password);
	    }
	
	
}
