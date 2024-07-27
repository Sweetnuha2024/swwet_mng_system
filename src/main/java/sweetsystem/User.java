package sweetsystem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import io.cucumber.java.it.Date;
public class User {
	
	private String username;
    private String password;

   
    public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String un, String pass) {
        this.username = un;
        this.password = pass;
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
