package Mysweetsystem2024;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;
   

    
    private NotificationServices notificationService;//noti
    
    
    
    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
        loadUsers();
        notificationService = new NotificationServices();//noti
       
        
        
        // Initialize login manager with users map
       
        
        
        
        
        
        
        
    }
    /////
   
   
    
    

    
   /// 
   
    
    public NotificationServices getNotificationService() {///noti
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
    
    public boolean createUser(User user) {
        // Implement logic to create a user
       // notificationService.sendNotification(user.getUsername(), "Your account has been created.");
       // return true; // Assuming user creation is successful
    	if (users.containsKey(user.getUsername())) {
            return false; // User already exists
        }

        users.put(user.getUsername(), user);

        // إرسال الإشعار
        notificationService.sendNotification(user.getUsername(), "Your account has been created successfully.");

        return true;
    }
    
    
    
    public boolean isUserLoggedIn(String username) {
        return loginManager.isUserLoggedIn(username);
    }
    
}