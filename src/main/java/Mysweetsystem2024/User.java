/*package Mysweetsystem2024;


public class User {
    private String username;
    private String password;
    private UserRole role;
    private String email;
    private String country;
    private String phoneNumber;
    private String confirmationMessage;
    
    private boolean feedbackRecorded;
    public User(String username, String password,  String email,String country, UserRole role) {
        this.username = username;
        this.password = password;
        
        this.email = email;
        this.country = country;
        this.role = role;
    }

    public User(String username, String password, String role) {
		// TODO Auto-generated constructor stub
	}
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    
    
    
    
    
    
	public User(String username2, String email2) {
		this.username=username2;
		this.email=email2;
	}

	public User(String username, String email, String password, String role1) {
		 this.username = username;
	        this.password = password;
	        this.role = role;
	        this.email = email;
	}

	
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", email=" + email
				+ ", country=" + country + "]";
	}

	public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String toFileString() {
        return username + "," + password + "," + country + "," + email + "," + role;
    }

   
    
    public String sendMessageToStoreOwner(String subject, String message) {
        // Simulate sending a message (In reality, this would interact with a messaging system)
        confirmationMessage = "Message sent to store owner with subject: " + subject;
        return confirmationMessage;
    }
    public boolean submitProductFeedback(String rating, String comment) {
        // Simulate feedback submission (In reality, this would involve saving feedback in a database)
        feedbackRecorded = true; // Assuming feedback submission is successful
        return feedbackRecorded;
    }
    public String notifyStoreOwner() {
        // Simulate notifying the store owner (In reality, this would send a notification)
        return "Store owner notified of feedback";
    }
    public String notifyRecipeOwner() {
        // Simulate notifying the recipe owner (In reality, this would send a notification)
        return "Recipe owner notified of feedback";
    }
    
}
*/
package Mysweetsystem2024;


public class User {
    private String username;
    private String password;
    private UserRole role;
    private String email;
    private String country;
    private String phoneNumber;
    
    private String confirmationMessage;
    private boolean feedbackRecorded;
    public User(String username) {
        this.username = username;
    }
    public String sendMessageToStoreOwner(String subject, String message) {
        // Simulate sending a message (In reality, this would interact with a messaging system)
        confirmationMessage = "Message sent to store owner with subject: " + subject;
        return confirmationMessage;
    }
    public User(String username, String password, String email, String country, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.country = country;
    }
    public boolean submitProductFeedback(String rating, String comment) {
        // Simulate feedback submission (In reality, this would involve saving feedback in a database)
        feedbackRecorded = true; // Assuming feedback submission is successful
        return feedbackRecorded;
    }
    public String notifyStoreOwner() {
        // Simulate notifying the store owner (In reality, this would send a notification)
        return "Store owner notified of feedback";
    }
    public String notifyRecipeOwner() {
        // Simulate notifying the recipe owner (In reality, this would send a notification)
        return "Recipe owner notified of feedback";
    }

    public User(String username, String password, String role) {
		// TODO Auto-generated constructor stub
	}
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    
    
    
    
    
    
	public User(String username2, String email2) {
		this.username=username2;
		this.email=email2;
	}

	public User(String username, String email, String password, String role1) {
		 this.username = username;
	        this.password = password;
	        this.role = role;
	        this.email = email;
	}

	// Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", email=" + email
				+ ", country=" + country + "]";
	}

	public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String toFileString() {
        return username + "," + password + "," + country + "," + email + "," + role;
    }

   
    
    
    
}