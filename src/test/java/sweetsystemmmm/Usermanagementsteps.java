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


   

      

        @Given("the admin wants to create a new user")
        public void theAdminWantsToCreateANewUser() {
            username = "newuser";
            password = "password123";
        }

        @When("the admin enters valid details")
        public void theAdminEntersValidDetails() {
            user = new StoreOwner(username, password, "newuser@example.com", "CountryName", "New Store", "123 New Street", "555-1234");
            operationResult = admin.createUser(user);
        }

        @Then("the user account is created")
        public void theUserAccountIsCreated() {
            assertTrue("User account should be created successfully", operationResult);
            assertNotNull("User should be present in the system", app.getUser(username));
        }

        @Given("the admin wants to view a user")
        public void theAdminWantsToViewAUser() {
            username = "existinguser";
            user = app.getUser(username);

            if (user == null) {
                user = new StoreOwner(username, "password123", "existinguser@example.com", "CountryName", "Existing Store", "456 Old Street", "555-5678");
                admin.createUser(user);
            }
        }

        @When("the admin searches for the user by username")
        public void theAdminSearchesForTheUserByUsername() {
            user = app.getUser(username);
        }

        @Then("the system displays the user details")
        public void theSystemDisplaysTheUserDetails() {
            assertNotNull("User details should be displayed", user);
        }

        @Given("the admin wants to update a user")
        public void theAdminWantsToUpdateAUser() {
            username = "existinguser";
            user = app.getUser(username);
        }

        @When("the admin modifies the user’s information")
        public void theAdminModifiesTheUserSInformation() {
            if (user != null) {
                user.setEmail("updatedemail@example.com");
                operationResult = admin.updateUser(user);
            } else {
                operationResult = false;
            }
        }

 @Then("the user account is updated")
   public void theUserAccountIsUpdated() {
  System.out.println("Operation Result: " + operationResult);
   User updatedUser = app.getUser(username);
    System.out.println("Updated User: " + updatedUser);
     if (updatedUser != null) {
     System.out.println("Updated Email: " + updatedUser.getEmail());
        	}

       assertTrue("User account should be updated successfully", operationResult);
      assertNotNull("Updated user should exist", updatedUser);
      assertTrue("User email should be updated", updatedUser.getEmail().equals("shahd@example.com"));
        }

        
        
        
        
        @Given("the admin wants to delete a user")
        public void theAdminWantsToDeleteAUser() {
            username = "userToDelete";
            user = app.getUser(username);

            if (user == null) {
                user = new StoreOwner(username, "password123", "userToDelete@example.com", "CountryName", "Store to Delete", "789 Delete Street", "555-7890");
                admin.createUser(user);
            }
        }

        @When("the admin confirms the deletion")
        public void theAdminConfirmsTheDeletion() {
            operationResult = admin.deleteUser(username);
        }

        @Then("the user account is deleted")
        public void theUserAccountIsDeleted() {
            assertTrue("User account should be deleted successfully", operationResult);
            assertNull("User should not exist in the system", app.getUser(username));
        }

        @Then("the user account is archived")
        public void theUserAccountIsArchived() {
            // Assuming an archiving mechanism is in place
            // Verify if the account is archived
            // Example placeholder: assertTrue("User should be archived before permanent deletion", app.isUserArchived(username));
        }
    }

    
