package Mysweetsystem2024;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;
    private NotificationServices notificationService;

    
    
    
    
   // private List<DessertCreation> dessertCreations;
    private Map<String, Order> orders;
    private List<Post> posts;
    
    
    
    
    
    
    private static final String FILE_PATH = "users.dat"; // Changed to .dat for serialization

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
        notificationService = new NotificationServices();
        posts = new ArrayList<>();
        
        
        
        
       // dessertCreations = new ArrayList<>();
        
        
        
        loadUsers();
    }

    //order class
    
    
    
    
    
    public boolean processOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            // Logic to process the order
            order.setStatus("Processed");
            return true;
        }
        return false;
    }
    public Order getOrderById(String orderId) {
        return orders.get(orderId);
    }
    public boolean updateOrderStatus(String orderId, String newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            return true;
        }
        return false;
    }
    public boolean hasExistingOrder() {
        return orders != null && !orders.isEmpty();
    }
    
    
    
    public boolean hasNewOrders() {
        if (orders == null || orders.isEmpty()) {
            return false;
        }

        for (Order order : orders.values()) {
            if (order.isNew()) { // Check if the order is new
                return true;
            }
        }

        return false;
    }
    
    //order class

    
    
    
    //post
    public boolean postContent(User user, String description, String image) {
        // Check if the user is logged in
        if (!isUserLoggedIn(user.getUsername())) {
            System.err.println("User is not logged in.");
            return false;
        }

        // Validate inputs
        if (description == null || description.isEmpty()) {
            System.err.println("Description is required.");
            return false;
        }

        if (image == null || image.isEmpty()) {
            System.err.println("Image is required.");
            return false;
        }

        // Create the post
        Post newPost = new Post(description, image, user.getUsername());
        posts.add(newPost);
        return true;
    }


    // Method to display all posts (for testing)
    public void displayAllPosts() {
        for (Post post : posts) {
            System.out.println(post);
        }
    }//
        
    
        
    
 /*       
    public boolean submitDessertCreation(DessertCreation dessertCreation) {
        // Validate dessert creation
        if (dessertCreation.getTitle() == null || dessertCreation.getTitle().trim().isEmpty()) {
            System.err.println("Title is required.");
            return false;
        }
        if (dessertCreation.getDescription() == null || dessertCreation.getDescription().trim().isEmpty()) {
            System.err.println("Description is required.");
            return false;
        }
        if (dessertCreation.getImage() == null || dessertCreation.getImage().trim().isEmpty()) {
            System.err.println("Image is required.");
            return false;
        }

        // If all validations pass, add to the list
        dessertCreations.add(dessertCreation);
        // Optionally, save to a file or database here
        saveDessertCreations();
        
        return true;
    }
    
    
    
    
   private void saveDessertCreations() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dessertCreations.dat"))) {
            oos.writeObject(dessertCreations);
        } catch (IOException e) {
            System.err.println("Error saving dessert creations: " + e.getMessage());
        }
    
    
   }
    */
    
    
    
    
    
    
    
    public NotificationServices getNotificationService() {
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
        saveUsers();
    }

    public boolean createUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false; // User already exists
        }

        users.put(user.getUsername(), user);
        saveUsers();
        
        // Send a notification after creating the user
        notificationService.sendNotification(user.getUsername(), "Your account has been created successfully.");

        return true;
    }

    public boolean isUserLoggedIn(String username) {
        return loginManager.isUserLoggedIn(username);
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (Map<String, User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading users: " + e.getMessage());
            }
        }
    }

    public boolean updateUser(User user) {
        if (users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user); // Update the user
            saveUsers(); // Save the updated users list
            return true;
        }
        return false;
    }
}
