package Mysweetsystem2024;

import java.util.ArrayList;

public class MyApplication {


	public boolean is_logged_in=false;
	private String welcome_msg;
	
	
	
	
	
	static ArrayList<User>List_user=new ArrayList<User>();
	
	public static ArrayList<User> getList_user() {
		return List_user;
	}
    public static void setList_user(ArrayList<User> list_user) {
		List_user = list_user;
	}
    
    
    ///new
    public void addUser(User user) {
        List_user.add(user);
    }

    public boolean userExists(String username) {
        for (User user : List_user) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public boolean isValidPassword(String password) {
        //  password must be at least 8 characters
        return password.length() >= 8;
    }
    
    
    
    public boolean isValidUsername(String username) {
        // Example validation: username must not contain spaces or special characters
        return username.matches("^[a-zA-Z0-9_]+$");
    }
    //////
	public MyApplication() {
		List_user.add(new User("shahd","822003"));
		List_user.add(new User("nuha","132003"));
	}

}
