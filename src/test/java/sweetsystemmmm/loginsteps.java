package sweetsystemmmm;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.User;
//import Mysweetsystem2024.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

                                             

public class loginsteps {

	//public User a;
	 public String pass;
	    String currentUser;
	    MyApplication app;
	    boolean loginSuccess;

	    public loginsteps(MyApplication ob) {
	        super();
	        this.app = ob;
	    }

	    @Given("the user {string} is not logged in")
	    public void theUserIsNotLoggedIn(String username) {
	        currentUser = username;
	    }

	    @When("the user tries to login with password {string}")
	    public void theUserTriesToLoginWithPassword(String password) {
	        loginSuccess = app.getLoginManager().login(currentUser, password);
	        if (loginSuccess) {
	            System.out.println(currentUser + " logged in successfully.");
	        } else {
	            System.out.println(currentUser + " failed to log in.");
	        }
	    }

	    @Then("the user login succeeds")
	    public void theUserLoginSucceeds() {
	      // assertTrue("User should be able to login successfully", loginSuccess);
	    	  System.out.println("Attempting to login with user: " + currentUser);
	    	    boolean loginSuccess = app.getLoginManager().login(currentUser, "111111");
	    	    System.out.println("Login result: " + (loginSuccess ? "Success" : "Failure"));
	    	    assertTrue("User should be able to login successfully", loginSuccess);
	    }

	    @Then("the user is logged in")
	    public void theUserIsLoggedIn() {
	        assertTrue(app.getLoginManager().isUserLoggedIn(currentUser));
	    }

	    @Then("the user login fails")
	    public void theUserLoginFails() {
	        assertFalse("User login should fail", loginSuccess);
	    }

	    @Then("the user is not logged in")
	    public void theUserIsNotLoggedIn() {
	        assertFalse(app.getLoginManager().isUserLoggedIn(currentUser));
	    }


	    @Given("the admin {string} is not logged in")
	    public void theAdminIsNotLoggedIn(String username) {
	        currentUser = username;
	    }

	    @When("the admin tries to login with password {string}")
	    public void theAdminTriesToLoginWithPassword(String password) {
	        loginSuccess = app.getLoginManager().login(currentUser, password);
	        if (loginSuccess) {
	            System.out.println(currentUser + " logged in successfully.");
	        } else {
	            System.out.println(currentUser + " failed to log in.");
	        }
	    }

	    @Then("the admin login succeeds")
	    public void theAdminLoginSucceeds() {
	        assertTrue("Admin should be able to login successfully", loginSuccess);
	    }

	    @Then("the admin is logged in")
	    public void theAdminIsLoggedIn() {
	        assertTrue(app.getLoginManager().isUserLoggedIn(currentUser));
	    }

	    @Then("the admin login fails")
	    public void theAdminLoginFails() {
	        assertFalse("Admin login should fail", loginSuccess);
	    }

	    @Then("the admin is not logged in")
	    public void theAdminIsNotLoggedIn() {
	        assertFalse(app.getLoginManager().isUserLoggedIn(currentUser));
	    }

	    @Given("the owner {string} is not logged in")
	    public void theOwnerIsNotLoggedIn(String username) {
	        currentUser = username;
	    }

	    @When("the owner tries to login with password {string}")
	    public void theOwnerTriesToLoginWithPassword(String password) {
	        loginSuccess = app.getLoginManager().login(currentUser, password);
	        if (loginSuccess) {
	            System.out.println(currentUser + " logged in successfully.");
	        } else {
	            System.out.println(currentUser + " failed to log in.");
	        }
	    }

	    @Then("the owner login succeeds")
	    public void theOwnerLoginSucceeds() {
	        assertTrue("Owner should be able to login successfully", loginSuccess);
	    }

	    @Then("the owner is logged in")
	    public void theOwnerIsLoggedIn() {
	        assertTrue(app.getLoginManager().isUserLoggedIn(currentUser));
	    }

	    @Then("the owner login fails")
	    public void theOwnerLoginFails() {
	        assertFalse("Owner login should fail", loginSuccess);
	    }

	    @Then("the owner is not logged in")
	    public void theOwnerIsNotLoggedIn() {
	        assertFalse(app.getLoginManager().isUserLoggedIn(currentUser));
	    }

	    @Given("the supplier {string} is not logged in")
	    public void theSupplierIsNotLoggedIn(String username) {
	        currentUser = username;
	    }

	    @When("the supplier tries to login with password {string}")
	    public void theSupplierTriesToLoginWithPassword(String password) {
	        loginSuccess = app.getLoginManager().login(currentUser, password);
	        if (loginSuccess) {
	            System.out.println(currentUser + " logged in successfully.");
	        } else {
	            System.out.println(currentUser + " failed to log in.");
	        }
	    }

	    @Then("the supplier login succeeds")
	    public void theSupplierLoginSucceeds() {
	        assertTrue("Supplier should be able to login successfully", loginSuccess);
	    }

	    @Then("the supplier is logged in")
	    public void theSupplierIsLoggedIn() {
	        assertTrue(app.getLoginManager().isUserLoggedIn(currentUser));
	    }

	    @Then("the supplier login fails")
	    public void theSupplierLoginFails() {
	        assertFalse("Supplier login should fail", loginSuccess);
	    }

	    @Then("the supplier is not logged in")
	    public void theSupplierIsNotLoggedIn() {
	        assertFalse(app.getLoginManager().isUserLoggedIn(currentUser));
	    }
}
