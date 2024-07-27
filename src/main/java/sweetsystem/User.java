package sweetsystem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import io.cucumber.java.it.Date;
public class User {
	
	private String username;
    private String password;

   
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
public String toString()
{
	return "User [username="+username+",Password=" +password +"]";
}
	
	
	
	
	
	
	
	
	
	
}
