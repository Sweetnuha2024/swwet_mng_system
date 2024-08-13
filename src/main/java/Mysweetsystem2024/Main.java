package Mysweetsystem2024;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Main extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private List <User> users;

    public Main() {
        // Set up the frame
        setTitle("Sweet Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        users = new ArrayList<>();
        initializeUsers();

        // Set up CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add all pages
        cardPanel.add(new LoginPage(this), "Login");
        cardPanel.add(new SignUpPage(this), "SignUp");
        cardPanel.add(new AdminDashboard(), "AdminDashboard");
        cardPanel.add(new StoreOwnerDashboard(), "StoreOwnerDashboard");
        cardPanel.add(new RawMaterialSupplierDashboard(), "RawMaterialSupplierDashboard");
        cardPanel.add(new BeneficiaryUserDashboard(), "BeneficiaryUserDashboard");
        cardPanel.add(new UserManagementPage(), "UserManagementPage");
        cardPanel.add(new ProductManagementPage(), "ProductManagementPage");
        cardPanel.add(new CommunicationPage(), "CommunicationPage");
        cardPanel.add(new OrderManagementPage(), "OrderManagementPage");
        cardPanel.add(new FeedbackPage(), "FeedbackPage");
        //cardPanel.add(new UserManagementPage(), "User Management Page");
        

        add(cardPanel);

        // Show the login page initially
        cardLayout.show(cardPanel, "Login");
    }

    
    
    private void initializeUsers() {
        // Add users to the application
        users.add(new User("nuha", "111111", "Palestine", "nuha@gmail.com", UserRole.REGULAR_USER));
        users.add(new User("shahd", "222222", "Palestine", "shahd@gmail.com", UserRole.ADMIN));
        users.add(new User("hala", "333333", "Palestine", "hala@gmail.com", UserRole.STORE_OWNER));
        users.add(new User("safaa", "444444", "Palestine", "safa@gmail.com", UserRole.SUPPLIER));
        
       // app.saveUsers();
    }
    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }
    
    
    

   // public static void main(String[] args) {
     //   SwingUtilities.invokeLater(() -> {
       //     new Main().setVisible(true);
            
       // });
   // }
}

// Login Page
class LoginPage extends JPanel {

    public LoginPage(Main mainFrame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Admin", "Store Owner", "Raw Material Supplier", "Beneficiary User"};
        JComboBox<String> roleDropdown = new JComboBox<>(roles);

        JButton loginButton = new JButton("Login");
        JLabel signUpLink = new JLabel("<html><u>Sign Up</u></html>");
        signUpLink.setForeground(Color.BLUE);
        signUpLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(roleLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(roleDropdown, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(signUpLink, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleDropdown.getSelectedItem();
            if ("Admin".equals(role)) {
                mainFrame.showCard("AdminDashboard");
            } else if ("Store Owner".equals(role)) {
                mainFrame.showCard("StoreOwnerDashboard");
            } else if ("Raw Material Supplier".equals(role)) {
                mainFrame.showCard("RawMaterialSupplierDashboard");
            } else if ("Beneficiary User".equals(role)) {
                mainFrame.showCard("BeneficiaryUserDashboard");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Login Attempt: \nUsername: " + username + "\nRole: " + role);
            }
        });

        signUpLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainFrame.showCard("SignUp");
            }
        });
    }
    
    private UserRole convertRoleToUserRole(String role) {
        switch (role) {
            case "Admin":
                return UserRole.ADMIN;
            case "Store Owner":
                return UserRole.STORE_OWNER;
            case "Raw Material Supplier":
                return UserRole.SUPPLIER;
            case "Beneficiary User":
                return UserRole.REGULAR_USER;
            default:
                return null;
        }
    }
}

// Sign-Up Page
class SignUpPage extends JPanel {

    public SignUpPage(Main mainFrame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel countryLabel = new JLabel("Country:");
        JTextField countryField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Admin", "Store Owner", "Raw Material Supplier", "Beneficiary User"};
        JComboBox<String> roleDropdown = new JComboBox<>(roles);

        JButton signUpButton = new JButton("Sign Up");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(countryLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(countryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(roleLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(roleDropdown, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(signUpButton, gbc);

        signUpButton.addActionListener(e -> {
            String name = nameField.getText();
            String country = countryField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleDropdown.getSelectedItem();
            JOptionPane.showMessageDialog(mainFrame, "Sign Up Attempt: \nName: " + name + "\nCountry: " + country +
                    "\nEmail: " + email + "\nRole: " + role);
        });
    }
}

// Admin Dashboard
class AdminDashboard extends JPanel {

    public AdminDashboard() {
        setLayout(new BorderLayout());

        // Create sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout(0, 1)); // Vertical layout for sidebar
        sidebarPanel.setPreferredSize(new Dimension(200, 0)); // Fixed width for sidebar
        sidebarPanel.setBackground(new Color(220, 220, 220));

        JButton userManagementButton = new JButton("User Management");
        JButton monitoringReportingButton = new JButton("Monitoring and Reporting");
        JButton contentManagementButton = new JButton("Content Management");
        JButton statisticsButton = new JButton("Statistics");

        sidebarPanel.add(userManagementButton);
        sidebarPanel.add(monitoringReportingButton);
        sidebarPanel.add(contentManagementButton);
        sidebarPanel.add(statisticsButton);

        // Create content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE); // Background color for content area
        contentPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Admin Dashboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a split pane to separate sidebar and content
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, contentPanel);
        splitPane.setDividerLocation(200); // Set initial divider location

        add(splitPane, BorderLayout.CENTER);

        // Add action listeners to buttons to show different content
        userManagementButton.addActionListener(e ->  openUserManagementPage());
        monitoringReportingButton.addActionListener(e -> showPanel("Monitoring and Reporting", contentPanel));
        contentManagementButton.addActionListener(e -> showPanel("Content Management", contentPanel));
        statisticsButton.addActionListener(e -> showPanel("Statistics", contentPanel));
    }

    private void showPanel(String panelName, JPanel contentPanel) {
        contentPanel.removeAll();
        JLabel label = new JLabel("Displaying " + panelName, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(label, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    private void openUserManagementPage () {
        // Create and show the ManagePersonalAccountFrame
    	UserManagementPage f = new UserManagementPage();
        f.setVisible(true);
    }
}


//Store Owner Dashboard
class StoreOwnerDashboard extends JPanel {

 public StoreOwnerDashboard() {
     setLayout(new BorderLayout());

     // Create sidebar panel
     JPanel sidebarPanel = new JPanel();
     sidebarPanel.setLayout(new GridLayout(0, 1)); // Vertical layout for sidebar
     sidebarPanel.setPreferredSize(new Dimension(200, 0)); // Fixed width for sidebar
     sidebarPanel.setBackground(new Color(220, 220, 220));

     JButton productManagementButton = new JButton("Product Management");
     JButton salesAndProfitsButton = new JButton("Sales and Profits");
     JButton communicationButton = new JButton("Communication");
     JButton accountManagementButton = new JButton("Account Management");
     JButton orderManagementButton = new JButton("Order Management");

     sidebarPanel.add(productManagementButton);
     sidebarPanel.add(salesAndProfitsButton);
     sidebarPanel.add(communicationButton);
     sidebarPanel.add(accountManagementButton);
     sidebarPanel.add(orderManagementButton);

     // Create content panel
     JPanel contentPanel = new JPanel();
     contentPanel.setBackground(Color.WHITE); // Background color for content area
     contentPanel.setLayout(new BorderLayout());

     JLabel titleLabel = new JLabel("Welcome to Store Owner Dashboard", JLabel.CENTER);
     titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
     contentPanel.add(titleLabel, BorderLayout.NORTH);

     // Create a split pane to separate sidebar and content
     JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, contentPanel);
     splitPane.setDividerLocation(200); // Set initial divider location

     add(splitPane, BorderLayout.CENTER);

     // Add action listeners to buttons to show different content
     productManagementButton.addActionListener(e -> showPanel("Product Management", contentPanel));
     salesAndProfitsButton.addActionListener(e -> showPanel("Sales and Profits", contentPanel));
     communicationButton.addActionListener(e -> showPanel("Communication", contentPanel));
     accountManagementButton.addActionListener(e -> showPanel("Account Management", contentPanel));
     orderManagementButton.addActionListener(e -> showPanel("Order Management", contentPanel));
 }

 private void showPanel(String panelName, JPanel contentPanel) {
     contentPanel.removeAll();
     JLabel label = new JLabel("Displaying " + panelName, JLabel.CENTER);
     label.setFont(new Font("Arial", Font.BOLD, 18));
     contentPanel.add(label, BorderLayout.CENTER);
     contentPanel.revalidate();
     contentPanel.repaint();
 }
}

//Raw Material Supplier Dashboard
class RawMaterialSupplierDashboard extends JPanel {

 public RawMaterialSupplierDashboard() {
     setLayout(new BorderLayout());

     // Create sidebar panel
     JPanel sidebarPanel = new JPanel();
     sidebarPanel.setLayout(new GridLayout(0, 1)); // Vertical layout for sidebar
     sidebarPanel.setPreferredSize(new Dimension(200, 0)); // Fixed width for sidebar
     sidebarPanel.setBackground(new Color(220, 220, 220));

     JButton productManagementButton = new JButton("Product Management");
     JButton salesAndProfitsButton = new JButton("Sales and Profits");
     JButton communicationButton = new JButton("Communication");
     JButton accountManagementButton = new JButton("Account Management");

     sidebarPanel.add(productManagementButton);
     sidebarPanel.add(salesAndProfitsButton);
     sidebarPanel.add(communicationButton);
     sidebarPanel.add(accountManagementButton);

     // Create content panel
     JPanel contentPanel = new JPanel();
     contentPanel.setBackground(Color.WHITE); // Background color for content area
     contentPanel.setLayout(new BorderLayout());

     JLabel titleLabel = new JLabel("Welcome to Raw Material Supplier Dashboard", JLabel.CENTER);
     titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
     contentPanel.add(titleLabel, BorderLayout.NORTH);

     // Create a split pane to separate sidebar and content
     JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, contentPanel);
     splitPane.setDividerLocation(200); // Set initial divider location

     add(splitPane, BorderLayout.CENTER);

     // Add action listeners to buttons to show different content
     productManagementButton.addActionListener(e -> showPanel("Product Management", contentPanel));
     salesAndProfitsButton.addActionListener(e -> showPanel("Sales and Profits", contentPanel));
     communicationButton.addActionListener(e -> showPanel("Communication", contentPanel));
     accountManagementButton.addActionListener(e -> showPanel("Account Management", contentPanel));
 }

 private void showPanel(String panelName, JPanel contentPanel) {
     contentPanel.removeAll();
     JLabel label = new JLabel("Displaying " + panelName, JLabel.CENTER);
     label.setFont(new Font("Arial", Font.BOLD, 18));
     contentPanel.add(label, BorderLayout.CENTER);
     contentPanel.revalidate();
     contentPanel.repaint();
 }
}


//Beneficiary User Dashboard
class BeneficiaryUserDashboard extends JPanel {

 public BeneficiaryUserDashboard() {
     setLayout(new BorderLayout());

     // Create sidebar panel
     JPanel sidebarPanel = new JPanel();
     sidebarPanel.setLayout(new GridLayout(0, 1)); // Vertical layout for sidebar
     sidebarPanel.setPreferredSize(new Dimension(200, 0)); // Fixed width for sidebar
     sidebarPanel.setBackground(new Color(220, 220, 220));

     JButton exploreAndPurchaseButton = new JButton("Explore and Purchase Desserts");
     JButton manageAccountButton = new JButton("Manage Personal Account");
     JButton postAndShareButton = new JButton("Post and Share Creations");
     JButton provideFeedbackButton = new JButton("Provide Feedback");

     sidebarPanel.add(exploreAndPurchaseButton);
     sidebarPanel.add(manageAccountButton);
     sidebarPanel.add(postAndShareButton);
     sidebarPanel.add(provideFeedbackButton);

     // Create content panel
     JPanel contentPanel = new JPanel();
     contentPanel.setBackground(Color.WHITE); // Background color for content area
     contentPanel.setLayout(new BorderLayout());

     JLabel titleLabel = new JLabel("Welcome to Beneficiary User Dashboard", JLabel.CENTER);
     titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
     contentPanel.add(titleLabel, BorderLayout.NORTH);

     // Create a split pane to separate sidebar and content
     JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, contentPanel);
     splitPane.setDividerLocation(200); // Set initial divider location

     add(splitPane, BorderLayout.CENTER);

     // Add action listeners to buttons to show different content
     exploreAndPurchaseButton.addActionListener(e -> showPanel("Explore and Purchase Desserts", contentPanel));
     manageAccountButton.addActionListener(e -> showPanel("Manage Personal Account", contentPanel));
     postAndShareButton.addActionListener(e -> showPanel("Post and Share Creations", contentPanel));
     provideFeedbackButton.addActionListener(e -> showPanel("Provide Feedback", contentPanel));
 }

 private void showPanel(String panelName, JPanel contentPanel) {
     contentPanel.removeAll();
     JLabel label = new JLabel("Displaying " + panelName, JLabel.CENTER);
     label.setFont(new Font("Arial", Font.BOLD, 18));
     contentPanel.add(label, BorderLayout.CENTER);
     contentPanel.revalidate();
     contentPanel.repaint();
 }
 
}

//User Management Page
class UserManagementPage extends JPanel {

	
	    private JTable userTable;
	    private DefaultTableModel tableModel;

	    public UserManagementPage() {
	        setLayout(new BorderLayout());

	        // Create the table model with columns
	        tableModel = new DefaultTableModel(new String[]{"User ID", "Username", "Email"}, 0);
	        userTable = new JTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(userTable);

	        // Create buttons
	        JButton addUserButton = new JButton("Add New User");
	        JButton viewUserButton = new JButton("View User");
	        JButton editUserButton = new JButton("Edit User");
	        JButton deleteUserButton = new JButton("Delete User");

	        // Create button panel
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.add(addUserButton);
	        buttonPanel.add(viewUserButton);
	        buttonPanel.add(editUserButton);
	        buttonPanel.add(deleteUserButton);

	        // Add components to the panel
	        add(scrollPane, BorderLayout.CENTER);
	        add(buttonPanel, BorderLayout.SOUTH);

	        // Add action listeners to buttons
	        addUserButton.addActionListener(e -> showAddUserDialog());
	        viewUserButton.addActionListener(e -> showViewUserDialog());
	        editUserButton.addActionListener(e -> showEditUserDialog());
	        deleteUserButton.addActionListener(e -> deleteUser());
	        
	        // Populate sample data for demonstration
	        populateSampleData();
	    }

	    // Method to show dialog for adding a new user
	    private void showAddUserDialog() {
	        JTextField usernameField = new JTextField(15);
	        JTextField emailField = new JTextField(15);
	        JPanel panel = new JPanel();
	        panel.add(new JLabel("Username:"));
	        panel.add(usernameField);
	        panel.add(new JLabel("Email:"));
	        panel.add(emailField);

	        int result = JOptionPane.showConfirmDialog(this, panel, "Add New User", JOptionPane.OK_CANCEL_OPTION);
	        if (result == JOptionPane.OK_OPTION) {
	            String username = usernameField.getText();
	            String email = emailField.getText();
	            if (!username.isEmpty() && !email.isEmpty()) {
	                // Add user to the database or list
	                // For demonstration, adding to table directly
	                int newId = tableModel.getRowCount() + 1;
	                tableModel.addRow(new Object[]{newId, username, email});
	                JOptionPane.showMessageDialog(this, "User added successfully.");
	            } else {
	                JOptionPane.showMessageDialog(this, "Please enter both username and email.");
	            }
	        }
	    }

	    // Method to show dialog for viewing user details
	    private void showViewUserDialog() {
	        int selectedRow = userTable.getSelectedRow();
	        if (selectedRow != -1) {
	            String userId = (String) tableModel.getValueAt(selectedRow, 0);
	            String username = (String) tableModel.getValueAt(selectedRow, 1);
	            String email = (String) tableModel.getValueAt(selectedRow, 2);

	            String message = String.format("User ID: %s\nUsername: %s\nEmail: %s", userId, username, email);
	            JOptionPane.showMessageDialog(this, message, "User Details", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "Please select a user to view.");
	        }
	    }

	    // Method to show dialog for editing user details
	    private void showEditUserDialog() {
	        int selectedRow = userTable.getSelectedRow();
	        if (selectedRow != -1) {
	            String userId = (String) tableModel.getValueAt(selectedRow, 0);
	            String username = (String) tableModel.getValueAt(selectedRow, 1);
	            String email = (String) tableModel.getValueAt(selectedRow, 2);

	            JTextField usernameField = new JTextField(username, 15);
	            JTextField emailField = new JTextField(email, 15);
	            JPanel panel = new JPanel();
	            panel.add(new JLabel("Username:"));
	            panel.add(usernameField);
	            panel.add(new JLabel("Email:"));
	            panel.add(emailField);

	            int result = JOptionPane.showConfirmDialog(this, panel, "Edit User", JOptionPane.OK_CANCEL_OPTION);
	            if (result == JOptionPane.OK_OPTION) {
	                String newUsername = usernameField.getText();
	                String newEmail = emailField.getText();
	                if (!newUsername.isEmpty() && !newEmail.isEmpty()) {
	                    // Update user in the database or list
	                    tableModel.setValueAt(newUsername, selectedRow, 1);
	                    tableModel.setValueAt(newEmail, selectedRow, 2);
	                    JOptionPane.showMessageDialog(this, "User details updated successfully.");
	                } else {
	                    JOptionPane.showMessageDialog(this, "Please enter both username and email.");
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Please select a user to edit.");
	        }
	    }

	    // Method to delete the selected user
	    private void deleteUser() {
	        int selectedRow = userTable.getSelectedRow();
	        if (selectedRow != -1) {
	            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	            if (confirmation == JOptionPane.YES_OPTION) {
	                // Remove user from database or list
	                tableModel.removeRow(selectedRow);
	                JOptionPane.showMessageDialog(this, "User deleted successfully.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
	        }
	    }

	    // Method to populate the table with sample data
	    public void populateSampleData() {
	        tableModel.addRow(new Object[]{"1", "john_doe", "john@example.com"});
	        tableModel.addRow(new Object[]{"2", "jane_smith", "jane@example.com"});
	    }
	   
	    
	}

	  
	    


//Product Management Page
class ProductManagementPage extends JPanel {

 public ProductManagementPage() {
     setLayout(new BorderLayout());

     // Create list panel
     JPanel listPanel = new JPanel();
     listPanel.setLayout(new BorderLayout());

     JTextArea productList = new JTextArea();
     productList.setText("List of products will be displayed here.");
     JScrollPane scrollPane = new JScrollPane(productList);

     JButton addProductButton = new JButton("Add New Product");
     JButton updateProductButton = new JButton("Update Product");
     JButton removeProductButton = new JButton("Remove Product");

     JPanel buttonPanel = new JPanel();
     buttonPanel.add(addProductButton);
     buttonPanel.add(updateProductButton);
     buttonPanel.add(removeProductButton);

     listPanel.add(scrollPane, BorderLayout.CENTER);
     listPanel.add(buttonPanel, BorderLayout.SOUTH);

     add(listPanel, BorderLayout.CENTER);

     // Add action listeners to buttons
     addProductButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(this, "Add New Product functionality.");
     });
     updateProductButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(this, "Update Product functionality.");
     });
     removeProductButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(this, "Remove Product functionality.");
     });
 }
}

//Communication Page
class CommunicationPage extends JPanel {

 public CommunicationPage() {
     setLayout(new BorderLayout());

     // Create messaging panel
     JPanel messagingPanel = new JPanel();
     messagingPanel.setLayout(new BorderLayout());

     JTextArea messageArea = new JTextArea();
     messageArea.setText("Messaging system will be here.");
     JScrollPane scrollPane = new JScrollPane(messageArea);

     JButton settingsButton = new JButton("Notification Settings");

     messagingPanel.add(scrollPane, BorderLayout.CENTER);
     messagingPanel.add(settingsButton, BorderLayout.SOUTH);

     add(messagingPanel, BorderLayout.CENTER);

     // Add action listener to button
     settingsButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(this, "Notification Settings functionality.");
     });
 }
}

//Order Management Page
class OrderManagementPage extends JPanel {

 public OrderManagementPage() {
     setLayout(new BorderLayout());

     // Create order list panel
     JPanel orderListPanel = new JPanel();
     orderListPanel.setLayout(new BorderLayout());

     JTextArea orderList = new JTextArea();
     orderList.setText("List of orders with status tracking will be displayed here.");
     JScrollPane scrollPane = new JScrollPane(orderList);

     JButton processOrderButton = new JButton("Process Order");

     orderListPanel.add(scrollPane, BorderLayout.CENTER);
     orderListPanel.add(processOrderButton, BorderLayout.SOUTH);

     add(orderListPanel, BorderLayout.CENTER);

     // Add action listener to button
     processOrderButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(this, "Process Order functionality.");
     });
 }
}

//Feedback Page
class FeedbackPage extends JPanel {

 public FeedbackPage() {
     setLayout(new BorderLayout());

     // Create feedback form panel
     JPanel feedbackFormPanel = new JPanel();
     feedbackFormPanel.setLayout(new BorderLayout());

     JTextArea feedbackForm = new JTextArea();
     feedbackForm.setText("Form for providing feedback.");
     JScrollPane scrollPane = new JScrollPane(feedbackForm);

     JButton submitFeedbackButton = new JButton("Submit Feedback");

     feedbackFormPanel.add(scrollPane, BorderLayout.CENTER);
     feedbackFormPanel.add(submitFeedbackButton, BorderLayout.SOUTH);

     // Create feedback list panel
     JPanel feedbackListPanel = new JPanel();
     feedbackListPanel.setLayout(new BorderLayout());

     JTextArea feedbackList = new JTextArea();
     feedbackList.setText("List of received feedback.");
     JScrollPane feedbackScrollPane = new JScrollPane(feedbackList);

     feedbackListPanel.add(feedbackScrollPane, BorderLayout.CENTER);

     // Add both panels
     add(feedbackFormPanel, BorderLayout.NORTH);
     add(feedbackListPanel, BorderLayout.CENTER);

     // Add action listener to button
     submitFeedbackButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(this, "Submit Feedback functionality.");
     });
 }


}

