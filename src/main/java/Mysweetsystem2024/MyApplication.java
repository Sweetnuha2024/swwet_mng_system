package Mysweetsystem2024;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;
    private static final String FILE_PATH = "users.txt";
    
    private static final String DESSERT_CREATIONS_FILE = "dessert_creations.txt";
    private static final String IMAGES_DIR = "images/";
    
    private JTextArea descriptionTextArea;
    private JButton uploadImageButton;
    private File selectedImageFile;
    
    

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
        loadUserData();
        showLoginFrame();
    }

    private void initializeUsers() {
        // Add users to the application
        users.put("nuha", new User("nuha", "111111", "nuha@gmail.com", "Palestine", UserRole.REGULAR_USER));
        users.put("shahd", new User("shahd", "222222", "shahd@gmail.com", "Palestine", UserRole.ADMIN));
        users.put("hala", new User("hala", "333333", "hala@gmail.com", "Palestine", UserRole.STORE_OWNER));
        users.put("safaa", new User("safaa", "444444", "safa@gmail.com", "Palestine", UserRole.SUPPLIER));
        saveUsers();
    }
//log in
    private void showLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(600, 500);
        loginFrame.setLayout(new GridLayout(4, 2));
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null); // Center the frame

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JButton loginButton = new JButton("Log In");
        JButton signUpButton = new JButton("Sign Up");

        loginFrame.add(userLabel);
        loginFrame.add(userText);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordText);
        loginFrame.add(loginButton);
        loginFrame.add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (loginManager.login(username, password)) {
                    loginFrame.dispose();
                    User user = users.get(username);
                    if (user != null) {
                        switch (user.getRole()) {
                            case REGULAR_USER:
                                showBeneficiaryUserDashboard();
                                break;
                            case ADMIN:
                                showAdminDashboard();
                                break;
                            case STORE_OWNER:
                                showStoreOwnerDashboard();
                                break;
                            case SUPPLIER:
                            	showStoreOwnerDashboard  ();
                                break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid credentials. Please try again.");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpFrame();
            }
        });

        loginFrame.setVisible(true);
    }
//sign up up up up up up up up up up up 
    private void showSignUpFrame() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(400, 300);
        signUpFrame.setLayout(new GridLayout(6, 2));
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null); // Center the frame

        JLabel nameLabel = new JLabel("Username:");
        JTextField nameText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailText = new JTextField();
        JLabel countryLabel = new JLabel("Country:");
        JTextField countryText = new JTextField();
        JLabel roleLabel = new JLabel("Role:");
        JComboBox<UserRole> roleComboBox = new JComboBox<>(UserRole.values());
        JButton signUpButton = new JButton("Sign Up");

        signUpFrame.add(nameLabel);
        signUpFrame.add(nameText);
        signUpFrame.add(passwordLabel);
        signUpFrame.add(passwordText);
        signUpFrame.add(emailLabel);
        signUpFrame.add(emailText);
        signUpFrame.add(countryLabel);
        signUpFrame.add(countryText);
        signUpFrame.add(roleLabel);
        signUpFrame.add(roleComboBox);
        signUpFrame.add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameText.getText();
                String password = new String(passwordText.getPassword());
                String email = emailText.getText();
                String country = countryText.getText();
                UserRole role = (UserRole) roleComboBox.getSelectedItem();

                if (!userExists(username)) {
                    signUpUser(username, password, email, country, role);
                    JOptionPane.showMessageDialog(signUpFrame, "Account created successfully.");
                    signUpFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(signUpFrame, "User already exists.");
                }
            }
        });

        signUpFrame.setVisible(true);
    }
//Admin Admin Admin  Admin
    private void showAdminDashboard() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("User Management", createUserManagementPanel());
        tabbedPane.addTab("Monitoring & Reporting", createMonitoringReportingPanel());
        tabbedPane.addTab("Content Management", createContentManagementPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel createUserManagementPanel() {
        JPanel panel = new JPanel();
        // Add components for managing users
        return panel;
    }

    private JPanel createMonitoringReportingPanel() {
        JPanel panel = new JPanel();
        // Add components for monitoring profits, generating reports, etc.
        return panel;
    }

    private JPanel createContentManagementPanel() {
        JPanel panel = new JPanel();
        // Add components for managing content and feedback
        return panel;
    }
    
    
    
    
    
//////////////////Store ownerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
    private void showStoreOwnerDashboard() {
    	JFrame frame = new JFrame("Store Owner Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Product Management", createProductManagementPanel());
        tabbedPane.addTab("Sales & Profits", createSalesProfitsPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    private JPanel createProductManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Top section: Add new product
        JPanel addProductPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField();
        JLabel descriptionLabel = new JLabel("Product Description:");
        JTextField descriptionField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();
        JButton addButton = new JButton("Add Product");

        addProductPanel.add(nameLabel);
        addProductPanel.add(nameField);
        addProductPanel.add(descriptionLabel);
        addProductPanel.add(descriptionField);
        addProductPanel.add(priceLabel);
        addProductPanel.add(priceField);
        addProductPanel.add(new JLabel());
        addProductPanel.add(addButton);

        // Center section: Product list
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane productScrollPane = new JScrollPane(productList);
        
        
        
        loadProductsFromFile(productListModel);
        
        

        // Bottom section: Buttons for update and delete
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Update Product");
        JButton deleteButton = new JButton("Delete Product");
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        panel.add(addProductPanel, BorderLayout.NORTH);
        panel.add(productScrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Action for adding product
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = nameField.getText().trim();
                String productDescription = descriptionField.getText().trim();
                double productPrice;
                try {
                    productPrice = Double.parseDouble(priceField.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid price.");
                    return;
                }

                if (!productName.isEmpty() && !productDescription.isEmpty()) {
                    productListModel.addElement(productName + " - " + productDescription + " - $" + productPrice);
                    
                    // Add logic to save product to the file or database
                    saveProductsToFile(productListModel);
                    JOptionPane.showMessageDialog(panel, "Product added successfully.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please fill all fields.");
                }
            }
        });

        // Action for updating product
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String product = productListModel.getElementAt(selectedIndex);
                    String[] parts = product.split(" - ");
                    nameField.setText(parts[0]);
                    descriptionField.setText(parts[1]);
                    priceField.setText(parts[2].substring(1));
                    productListModel.remove(selectedIndex);
                    
                    JOptionPane.showMessageDialog(panel, "Product updated. Please re-add with new details.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a product to update.");
                }
            }
        });

        // Action for deleting product
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    productListModel.remove(selectedIndex);
                    saveProductsToFile(productListModel);
                    JOptionPane.showMessageDialog(panel, "Product deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a product to delete.");
                }
            }
        });

        return panel;
    }
    
    private JPanel createSalesProfitsPanel() {
        JPanel panel = new JPanel();
        // Add components for monitoring sales, profits, and discounts
        return panel;
    }
    
    
    
    
    private void saveProductsToFile(DefaultListModel<String> productListModel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Product.txt"))) {
            for (int i = 0; i < productListModel.size(); i++) {
                String productString = productListModel.get(i);
                writer.write(productString);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProductsFromFile(DefaultListModel<String> productListModel) {
        File file = new File("Product.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    productListModel.addElement(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////end Store Ownerrrrr
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    private void showSupplierDashboard() {
        // Implement Supplier Dashboard display
        System.out.println("Showing Supplier Dashboard");
    }
//////////USER USER  USER USER USER USER
    private void showBeneficiaryUserDashboard() {
        // Implementation specific to the Beneficiary User Dashboard
        // You can use the `showMainFrame` method if it meets the needs of this dashboard
        showMainFrame();
    }

    private void showMainFrame() {
        JFrame frame = new JFrame("Beneficiary User Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Account Management", createAccountManagementPanel());
        tabbedPane.addTab("Explore & Purchase", createExplorePurchasePanel());
        tabbedPane.addTab("Communication & Feedback", createCommunicationFeedbackPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    
    

    private JPanel createAccountManagementPanel() {
    	JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a tabbed pane for account management features
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel for managing account details
        JPanel accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridLayout(6, 2, 10, 10));
        
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        
        JLabel countryLabel = new JLabel("Country:");
        JTextField countryField = new JTextField(15);
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        
        JButton updateButton = new JButton("Update Details");
        
        accountDetailsPanel.add(usernameLabel);
        accountDetailsPanel.add(usernameField);
        accountDetailsPanel.add(emailLabel);
        accountDetailsPanel.add(emailField);
        accountDetailsPanel.add(countryLabel);
        accountDetailsPanel.add(countryField);
        accountDetailsPanel.add(passwordLabel);
        accountDetailsPanel.add(passwordField);
        accountDetailsPanel.add(new JLabel()); // Empty cell
        accountDetailsPanel.add(updateButton);

        // Action for the update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to update user details here
            	// Update user details logic
                String username = usernameField.getText().trim();
                String email = emailField.getText().trim();
                String country = countryField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (username.isEmpty() || email.isEmpty() || country.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "All fields are required.");
                    return;
                }

                String currentUsername = getCurrentUsername();
                User user = users.get(currentUsername);
                if (user != null) {
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setCountry(country);
                    user.setPassword(password);
                    saveUsers();
                    JOptionPane.showMessageDialog(panel, "Details updated successfully.");
                }
            }        });
        
        
        
    
        JPanel postDessertPanel = createPostDessertPanel();

        // Add tabs to the JTabbedPane
        tabbedPane.addTab("Account Details", accountDetailsPanel);
       // tabbedPane.addTab("View My Posts", viewMyPostsPanel);
        tabbedPane.addTab("Post Dessert", postDessertPanel);

        panel.add(tabbedPane, BorderLayout.CENTER);

        return panel;
    }
        
    
    private String getCurrentUsername() {
        // Implement logic to retrieve the currently logged-in username
        // Placeholder implementation:
        return "nuha"; // Replace with actual logic
    }
    private String loadUserPosts(String username) {
        StringBuilder posts = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(DESSERT_CREATIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(username + ":")) {
                    // Assuming the format is username:imagePath:description
                    String[] parts = line.split(":");
                    if (parts.length >= 3) {
                        String imagePath = parts[1];
                        String description = parts[2];
                        posts.append("Description: ").append(description).append("\n");
                        posts.append("Image: ").append(imagePath).append("\n\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts.toString();
    }


    
  
    
    
    
    
    
    
    
    
    //post and share
    
    private void showAllUserPosts() {
        JFrame postsFrame = new JFrame("My Dessert Creations");
        postsFrame.setSize(800, 600);
        postsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        postsFrame.setLayout(new BorderLayout());

        JPanel postsPanel = new JPanel();
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(postsPanel);
        postsFrame.add(scrollPane, BorderLayout.CENTER);

        String currentUsername = getCurrentUsername();
        loadUserPosts(postsPanel, currentUsername);

        postsFrame.setVisible(true);
    }

    private void loadUserPosts(JPanel panel, String username) {
        panel.removeAll(); // Clear existing content

        try (BufferedReader reader = new BufferedReader(new FileReader(DESSERT_CREATIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) { // Ensure the line has the correct format
                    String postUsername = parts[0];
                    String imagePath = parts[1];
                    String description = parts[2];

                    if (postUsername.equals(username)) {
                        JPanel contentItemPanel = new JPanel();
                        contentItemPanel.setLayout(new BoxLayout(contentItemPanel, BoxLayout.Y_AXIS));
                        contentItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around each item

                        JLabel descriptionLabel = new JLabel("Description: " + description);
                        contentItemPanel.add(descriptionLabel);

                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                        JLabel imageLabel = new JLabel(new ImageIcon(image));
                        contentItemPanel.add(imageLabel);

                        panel.add(contentItemPanel);
                        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Space between items
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }

        panel.revalidate(); // Refresh the panel to show new content
        panel.repaint();
    }

    
    
    
    
    
    
    
    
    
    
    //post and share
    
    private JPanel createPostDessertPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // Adjusted GridLayout for the additional button

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionTextArea = new JTextArea(4, 30);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

        uploadImageButton = new JButton("Upload Image");
        JButton postButton = new JButton("Post Dessert");
        JButton viewPostsButton = new JButton("View My Posts"); // Added button to view posts

        panel.add(descriptionLabel);
        panel.add(scrollPane);
        panel.add(uploadImageButton);
        panel.add(postButton);
        panel.add(viewPostsButton); // Added button to panel

        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(null, "Image selected: " + selectedImageFile.getName());
                }
            }
        });

        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionTextArea.getText().trim();
                if (description.isEmpty() || selectedImageFile == null) {
                    JOptionPane.showMessageDialog(null, "Please provide a description and select an image.");
                    return;
                }

                saveDessertCreation(description, selectedImageFile);
                JOptionPane.showMessageDialog(null, "Dessert creation posted!");
            }
        });

        viewPostsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllUserPosts(); // Call the method to show user posts
            }
        });

        return panel;
    }


    
    
    
    
    
   
    private void saveDessertCreation(String description, File imageFile) {
        String currentUsername = getCurrentUsername();
        String imagePath = imageFile.getAbsolutePath(); // Store the full path of the image

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DESSERT_CREATIONS_FILE, true))) {
            // Format: username|imagePath|description
            writer.write(currentUsername + "|" + imagePath + "|" + description);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save dessert creation.");
        }
    }

    //post and share
    
    
    
    public JPanel createExplorePurchasePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create components for browsing and searching products
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Products:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Create a list to display the search results (products)
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane productScrollPane = new JScrollPane(productList);

        // Create components for filtering based on dietary needs or food allergies
        JCheckBox glutenFreeCheckbox = new JCheckBox("Gluten-Free");
        JCheckBox veganCheckbox = new JCheckBox("Vegan");
        JCheckBox nutFreeCheckbox = new JCheckBox("Nut-Free");
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter by:"));
        filterPanel.add(glutenFreeCheckbox);
        filterPanel.add(veganCheckbox);
        filterPanel.add(nutFreeCheckbox);

        // Create a button to show available products for purchase
        JButton purchaseButton = new JButton("Purchase Selected Product");

        // Load all products from the file initially
        List<String> allProducts = loadProductsFromFile("Product.txt");
        allProducts.forEach(productListModel::addElement);

        // Add action listener for the search button
        searchButton.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            boolean glutenFree = glutenFreeCheckbox.isSelected();
            boolean vegan = veganCheckbox.isSelected();
            boolean nutFree = nutFreeCheckbox.isSelected();

            // Filter products based on search query and selected filters
            List<String> filteredProducts = allProducts.stream()
                .filter(product -> product.toLowerCase().contains(query))
                .filter(product -> {
                    boolean matchesFilter = true;
                    if (glutenFree) {
                        matchesFilter = matchesFilter && product.toLowerCase().contains("gluten-free");
                    }
                    if (vegan) {
                        matchesFilter = matchesFilter && product.toLowerCase().contains("vegan");
                    }
                    if (nutFree) {
                        matchesFilter = matchesFilter && product.toLowerCase().contains("nut-free");
                    }
                    return matchesFilter;
                })
                .collect(Collectors.toList());

            // Update the list model with filtered products
            productListModel.clear();
            filteredProducts.forEach(productListModel::addElement);
        });

        
        
        purchaseButton.addActionListener(e -> {
            String selectedProduct = productList.getSelectedValue();
            if (selectedProduct != null) {
                int confirm = JOptionPane.showConfirmDialog(panel,
                        "Are you sure you want to purchase: " + selectedProduct + "?",
                        "Confirm Purchase",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Simulate purchase logic (e.g., update inventory, deduct balance)
                    JOptionPane.showMessageDialog(panel, "Purchase successful! You bought: " + selectedProduct);
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Please select a product to purchase.");
            }
        });
        
        
        
        // Add components to the panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(productScrollPane, BorderLayout.CENTER);
        panel.add(filterPanel, BorderLayout.WEST);
        panel.add(purchaseButton, BorderLayout.SOUTH);

        return panel;
    }

    
    
    
    
    
    
    
    
    
    
    

    private List<String> loadProductsFromFile(String fileName) {
        List<String> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                products.add(line); // Assuming each line in the file is a product description
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }


    private void showAvailableProductsForPurchase(String recipeName) {
        // Load products from the "Product.txt" file
        List<String> availableProducts = loadProductsFromFile("Product.txt");

        if (availableProducts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products available for purchase.");
            return;
        }

        String selectedProduct = (String) JOptionPane.showInputDialog(
                null,
                "Select a product to purchase:",
                "Available Products",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableProducts.toArray(new String[0]),
                availableProducts.get(0));

        if (selectedProduct != null) {
            // Handle the purchase logic (e.g., deduct balance, confirm order)
            JOptionPane.showMessageDialog(null, "You have successfully purchased: " + selectedProduct);
        }
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private JPanel createCommunicationFeedbackPanel() {
        JPanel panel = new JPanel();
        // Add components for communication and feedback
        return panel;
    }

    public void signUpUser(String username, String password, String email, String country, UserRole role) {
        if (!userExists(username)) {
            users.put(username, new User(username, password, email, country, role));
            saveUsers(); // This will save the updated users map to the file
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    
 

    public User getUser(String username) {
        return users.get(username);
    }
    public void addUser(User user) {
        users.put(user.getUsername(), user);
        saveUsers();
    }
// read  users from file
    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String username = parts[0];
                    String password = parts[1];
                    String email = parts[2];
                    String country = parts[3];
                    UserRole role = UserRole.valueOf(parts[4]);
                    users.put(username, new User(username, password, email, country, role));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getCountry() + "," + user.getRole());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initGUI() {
        // Create the main application window
        JFrame frame = new JFrame("Explore and Purchase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create the Explore and Purchase panel
        JPanel explorePurchasePanel = createExplorePurchasePanel();
        frame.add(explorePurchasePanel);

        // Make the frame visible
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyApplication());
       // MyApplication app = new MyApplication();
        //app.initGUI();
    }
}


