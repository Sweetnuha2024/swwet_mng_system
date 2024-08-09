package sweetsystemmmm;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.NotificationServices;
import Mysweetsystem2024.StoreOwner;
import Mysweetsystem2024.User;
import Mysweetsystem2024.Usermangadmin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Usermanagementsteps {

    private MyApplication app;
    private Usermangadmin admin;
    private User user;
    private String username;
    private String password;
    private boolean operationResult;

    @Given("the admin is logged into the Sweet Management System")
    public void theAdminIsLoggedIntoTheSweetManagementSystem() {
        app = new MyApplication();
        admin = new Usermangadmin(app);
    }

    @Given("the admin wants to create a new user account")
    public void theAdminWantsToCreateANewUserAccount() {
        username = "newuser";
        password = "password123";
    }

    @When("the admin provides valid details for a new store owner or supplier")
    public void theAdminProvidesValidDetailsForANewStoreOwnerOrSupplier() {
        // Create a StoreOwner as an example
        user = new StoreOwner(username, password, "newuser@example.com", "CountryName", "New Store", "123 New Street", "555-1234");
        operationResult = admin.createUser(user);
    }

    @Then("the new user account is created successfully")
    public void theNewUserAccountIsCreatedSuccessfully() {
        assertTrue("User account should be created successfully", operationResult);
        assertNotNull("User should be present in the system", app.getUser(username));
    }
/////
    @Then("the user receives a notification about their new account")
    public void theUserReceivesANotificationAboutTheirNewAccount() {
    	 System.out.println("Checking notification for user: " + username);
    	    boolean notificationExists = app.getNotificationService().hasNotificationForUser(username);
    	    System.out.println("Notification exists: " + notificationExists);
    	    assertTrue("User should receive a notification about their new account", notificationExists);
    }



    
    
    
    @Given("the admin wants to view an existing user account")
    public void theAdminWantsToViewAnExistingUserAccount() {
        username = "existinguser";

        // Ensure the user exists in the system
        user = app.getUser(username);
        if (user == null) {
            user = new StoreOwner(username, "password123", "existinguser@example.com", "CountryName", "Existing Store", "456 Old Street", "555-5678");
            admin.createUser(user);
        }
    }

    @When("the admin searches for the user by username or other filters")
    public void theAdminSearchesForTheUserByUsernameOrOtherFilters() {
        user = app.getUser(username);
    }

    @Then("the system displays the user's account details")
    public void theSystemDisplaysTheUserSAccountDetails() {
        assertNotNull("User details should be displayed", user);
        // Add additional checks if you want to verify specific details
    }

    @Given("the admin wants to update an existing user account")
    public void theAdminWantsToUpdateAnExistingUserAccount() {
        username = "existinguser";
        user = app.getUser(username);
    }

    @When("the admin modifies the user's information")
    public void theAdminModifiesTheUserSInformation() {
        if (user != null) {
            user.setEmail("updatedemail@example.com");
            operationResult = admin.updateUser(user);
        }
    }
    




    @Then("the user's account is updated successfully")
    public void theUserSAccountIsUpdatedSuccessfully() {
        assertTrue("User account should be updated successfully", operationResult);
        User updatedUser = app.getUser(username);
        assertNotNull("Updated user should exist", updatedUser);
        assertTrue("User email should be updated", updatedUser.getEmail().equals("updatedemail@example.com"));
    }

    
    
    
    @Then("the user is notified about the updates to their account")
    public void theUserIsNotifiedAboutTheUpdatesToTheirAccount() {
   
    }    
    
    
    
    @Given("the admin wants to delete an existing user account")
    public void theAdminWantsToDeleteAnExistingUserAccount() {
        username = "userToDelete";

        // Ensure the user exists before attempting to delete
        user = app.getUser(username);
        if (user == null) {
            user = new StoreOwner(username, "password123", "userToDelete@example.com", "CountryName", "Store to Delete", "789 Delete Street", "555-7890");
            admin.createUser(user);
        }
    }

    @When("the admin confirms the deletion of the user account")
    public void theAdminConfirmsTheDeletionOfTheUserAccount() {
        operationResult = admin.deleteUser(username);
    }

    @Then("the user's account is deleted successfully")
    public void theUserSAccountIsDeletedSuccessfully() {
        assertTrue("User account should be deleted successfully", operationResult);
        assertNull("User should not exist in the system", app.getUser(username));
    }



    @Then("the user's account is archived for a certain period before permanent deletion")
    public void theUserSAccountIsArchivedForACertainPeriodBeforePermanentDeletion() {
        // Assuming archiving mechanism is in place
        // Verify if the account is archived
        // Example placeholder: assertTrue("User should be archived before permanent deletion", app.isUserArchived(username));
    }
}
