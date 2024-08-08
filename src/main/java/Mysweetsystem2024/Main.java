package Mysweetsystem2024;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private MyApplication app;
    private JFrame frame;
    private JComboBox<String> roleComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public Main() {
        app = new MyApplication();
        initializeUsers();

        frame = new JFrame("Login System");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Role Label and ComboBox
        JLabel roleLabel = new JLabel("Select Role:");
        roleLabel.setBounds(20, 20, 100, 25);
        frame.add(roleLabel);

        String[] roles = {"Admin", "Store Owner", "User", "Raw Supplier"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(120, 20, 150, 25);
        frame.add(roleComboBox);

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 60, 100, 25);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 60, 150, 25);
        frame.add(usernameField);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 100, 100, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 100, 150, 25);
        frame.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 140, 100, 25);
        frame.add(loginButton);

        // Sign Up Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(230, 140, 100, 25);
        frame.add(signUpButton);

        // Result Label
        resultLabel = new JLabel("");
        resultLabel.setBounds(20, 180, 350, 25);
        frame.add(resultLabel);

        // Login Button Action Listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        // Sign Up Button Action Listener
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignUpFrame();
            }
        });

        // Show Frame
        frame.setVisible(true);
    }

    private void initializeUsers() {
        // Add users to the application
        app.addUser(new User("shahd", "222222", "Palestine", "shahd@gmail.com", UserRole.ADMIN));
        app.addUser(new User("hala", "333333", "Palestine", "hala@gmail.com", UserRole.STORE_OWNER));
        app.addUser(new User("tasneem", "123456", "Palestine", "tasneem@gmail.com", UserRole.STORE_OWNER));
        app.addUser(new User("alaa", "000000", "Palestine", "alaa@gmail.com", UserRole.SUPPLIER));
        app.addUser(new User("safa", "444444", "Palestine", "safa@gmail.com", UserRole.SUPPLIER));
        app.addUser(new User("nuha", "111111", "Palestine", "nuha@gmail.com", UserRole.REGULAR_USER));
    }

    private void handleLogin() {
        String selectedRole = (String) roleComboBox.getSelectedItem();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        UserRole role = UserRole.valueOf(selectedRole.toUpperCase().replace(" ", "_"));
        User user = app.getUser(username);

        if (user == null) {
            resultLabel.setText("The username does not exist in the system.");
        } else {
            if (app.getLoginManager().login(username, password)) {
                if (user.getRole() == role) {
                    resultLabel.setText(username + " logged in successfully as " + selectedRole + ".");
                    if (role == UserRole.ADMIN) {
                        openAdminPanel();
                    }
                } else {
                    resultLabel.setText("The username does not match the selected role.");
                }
            } else {
                // Password is incorrect
                resultLabel.setText("Wrong password, please try again.");
            }
        }
    }

    private void openSignUpFrame() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(400, 300); 
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLayout(null);

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 100, 25);
        signUpFrame.add(usernameLabel);

        JTextField signUpUsernameField = new JTextField();
        signUpUsernameField.setBounds(120, 20, 150, 25);
        signUpFrame.add(signUpUsernameField);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 100, 25);
        signUpFrame.add(passwordLabel);

        JPasswordField signUpPasswordField = new JPasswordField();
        signUpPasswordField.setBounds(120, 60, 150, 25);
        signUpFrame.add(signUpPasswordField);

        // Email Label and TextField
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 100, 100, 25);
        signUpFrame.add(emailLabel);

        JTextField signUpEmailField = new JTextField();
        signUpEmailField.setBounds(120, 100, 150, 25);
        signUpFrame.add(signUpEmailField);

        // Country Label and ComboBox
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(20, 140, 100, 25);
        signUpFrame.add(countryLabel);

        String[] countries = {"Palestine", "Jordan", "Lebanon", "Syria", "Other"};
        JComboBox<String> countryComboBox = new JComboBox<>(countries);
        countryComboBox.setBounds(120, 140, 150, 25);
        signUpFrame.add(countryComboBox);

        // Role Label and ComboBox
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(20, 180, 100, 25);
        signUpFrame.add(roleLabel);

        String[] roles = {"Admin", "Store Owner", "User", "Raw Supplier"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(120, 180, 150, 25);
        signUpFrame.add(roleComboBox);

        // Sign Up Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(120, 220, 100, 25);
        signUpFrame.add(signUpButton);

        // Result Label
        JLabel signUpResultLabel = new JLabel("");
        signUpResultLabel.setBounds(20, 250, 350, 25);
        signUpFrame.add(signUpResultLabel);

        // Sign Up Button Action Listener
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = signUpUsernameField.getText();
                String password = new String(signUpPasswordField.getPassword());
                String email = signUpEmailField.getText();
                String country = (String) countryComboBox.getSelectedItem();
                String selectedRole = (String) roleComboBox.getSelectedItem();

                UserRole role = UserRole.valueOf(selectedRole.toUpperCase().replace(" ", "_"));
                if (app.userExists(username)) {
                    signUpResultLabel.setText("Username already exists. Please try a different one.");
                } else {
                    app.signUpUser(username, password, email, country, role);
                    signUpResultLabel.setText("Sign up successful!");
                }
            }
        });

        // Show Sign Up Frame
        signUpFrame.setVisible(true);
    }

    private void openAdminPanel() {
        JFrame adminPanelFrame = new JFrame("Admin Panel");
        adminPanelFrame.setSize(400, 300);
        adminPanelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminPanelFrame.setLayout(null);

        // User Management Button
        JButton userManagementButton = new JButton("User Management");
        userManagementButton.setBounds(100, 30, 200, 40);
        adminPanelFrame.add(userManagementButton);

        // Monitoring and Reporting Button
        JButton monitoringButton = new JButton("Monitoring and Reporting");
        monitoringButton.setBounds(100, 90, 200, 40);
        adminPanelFrame.add(monitoringButton);

        // Content Management Button
        JButton contentManagementButton = new JButton("Content Management");
        contentManagementButton.setBounds(100, 150, 200, 40);
        adminPanelFrame.add(contentManagementButton);

        // Action Listener for User Management
        userManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUserManagementFrame();
            }
        });

        // Show Admin Panel
        adminPanelFrame.setVisible(true);
    }

    private void openUserManagementFrame() {
        JFrame userManagementFrame = new JFrame("User Management");
        userManagementFrame.setSize(500, 400);
        userManagementFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userManagementFrame.setLayout(null);

        // Create Store Owner Account Button
        JButton createStoreOwnerButton = new JButton("Create Store Owner Account");
        createStoreOwnerButton.setBounds(50, 30, 200, 40);
        userManagementFrame.add(createStoreOwnerButton);

        // Edit Store Owner Account Button
        JButton editStoreOwnerButton = new JButton("Edit Store Owner Account");
        editStoreOwnerButton.setBounds(50, 80, 200, 40);
        userManagementFrame.add(editStoreOwnerButton);

        // Delete Store Owner Account Button
        JButton deleteStoreOwnerButton = new JButton("Delete Store Owner Account");
        deleteStoreOwnerButton.setBounds(50, 130, 200, 40);
        userManagementFrame.add(deleteStoreOwnerButton);

        // View Store Owner Account Button
        JButton viewStoreOwnerButton = new JButton("View Store Owner Accounts");
        viewStoreOwnerButton.setBounds(50, 180, 200, 40);
        userManagementFrame.add(viewStoreOwnerButton);

        // Create Raw Supplier Account Button
        JButton createRawSupplierButton = new JButton("Create Raw Supplier Account");
        createRawSupplierButton.setBounds(50, 230, 200, 40);
        userManagementFrame.add(createRawSupplierButton);

        // Edit Raw Supplier Account Button
        JButton editRawSupplierButton = new JButton("Edit Raw Supplier Account");
        editRawSupplierButton.setBounds(50, 280, 200, 40);
        userManagementFrame.add(editRawSupplierButton);

        // Delete Raw Supplier Account Button
        JButton deleteRawSupplierButton = new JButton("Delete Raw Supplier Account");
        deleteRawSupplierButton.setBounds(50, 330, 200, 40);
        userManagementFrame.add(deleteRawSupplierButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(300, 330, 100, 40);
        userManagementFrame.add(backButton);

        // Action Listener for Create Store Owner Account
        createStoreOwnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreateStoreOwnerFrame();
            }
        });

        // Back Button Action Listener
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManagementFrame.dispose(); // Close User Management Frame
            }
        });

        // Show User Management Frame
        userManagementFrame.setVisible(true);
    }

    private void openCreateStoreOwnerFrame() {
        JFrame createStoreOwnerFrame = new JFrame("Create Store Owner Account");
        createStoreOwnerFrame.setSize(400, 400);
        createStoreOwnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createStoreOwnerFrame.setLayout(null);

        // Name Label and TextField
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        createStoreOwnerFrame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(120, 20, 150, 25);
        createStoreOwnerFrame.add(nameField);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 100, 25);
        createStoreOwnerFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 150, 25);
        createStoreOwnerFrame.add(passwordField);

        // Email Label and TextField
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 100, 100, 25);
        createStoreOwnerFrame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 100, 150, 25);
        createStoreOwnerFrame.add(emailField);

        // Country Label and TextField
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(20, 140, 100, 25);
        createStoreOwnerFrame.add(countryLabel);

        JTextField countryField = new JTextField();
        countryField.setBounds(120, 140, 150, 25);
        createStoreOwnerFrame.add(countryField);

        // Address Label and TextField
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 180, 100, 25);
        createStoreOwnerFrame.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(120, 180, 150, 25);
        createStoreOwnerFrame.add(addressField);

        // Phone Number Label and TextField
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(20, 220, 100, 25);
        createStoreOwnerFrame.add(phoneNumberLabel);

        JTextField phoneNumberField = new JTextField();
        phoneNumberField.setBounds(120, 220, 150, 25);
        createStoreOwnerFrame.add(phoneNumberField);

        // Create Button
        JButton createButton = new JButton("Create");
        createButton.setBounds(120, 260, 100, 25);
        createStoreOwnerFrame.add(createButton);

        // Result Label
        JLabel createResultLabel = new JLabel("");
        createResultLabel.setBounds(20, 300, 350, 25);
        createStoreOwnerFrame.add(createResultLabel);

        // Create Button Action Listener
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the logic to create a new store owner account
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();
                String country = countryField.getText();
                String address = addressField.getText();
                String phoneNumber = phoneNumberField.getText();

                if (app.userExists(name)) {
                    createResultLabel.setText("Store owner already exists.");
                } else {
                    // Create the store owner
                    app.signUpUser(name, password, email, country, UserRole.STORE_OWNER);
                    createResultLabel.setText("Store owner account created successfully.");
                }
            }
        });

        // Show Create Store Owner Frame
        createStoreOwnerFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
