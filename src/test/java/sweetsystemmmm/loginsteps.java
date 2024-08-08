package sweetsystemmmm;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
//import Mysweetsystem2024.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class loginsteps {
	 String currentUser;
	MyApplication app;
	public loginsteps(MyApplication ob) {
		super();
		this.app=ob;
		
	}
	//1
	@Given("the user {string} is not logged in")
	public void theUserIsNotLoggedIn(String username) {
		currentUser = username;
	}
	
	
	
	
	//2

	@When("the user tries to login with password {string}")
	public void theUserTriesToLoginWithPassword(String password) {
		 boolean loginSuccess = app.getLoginManager().login(currentUser, password);
	        if (loginSuccess) {
	            System.out.println(currentUser + " logged in successfully.");
	        } else {
	            System.out.println(currentUser + " failed to log in.");
	        }
	}
	
	
//3
	@Then("the user login succeeds")
	public void theUserLoginSucceeds() {
		  // Perform the login attempt
	    boolean loginSuccess = app.getLoginManager().login(currentUser, "111111");
	    
	    // Print debugging information
	    System.out.println("Attempting to login with user: " + currentUser);
	    System.out.println("Login result: " + (loginSuccess ? "Success" : "Failure"));
	    
	    // Assert that the login should succeed
	    assertTrue("User should be able to login successfully", loginSuccess);
	}
	
	
	
	
//4
	@Then("the user is logged in")
	public void theUserIsLoggedIn() {
		assertTrue(app.getLoginManager().login(currentUser, "111111"));
	}

	
	
	
	//5
	@Then("the user login fails")
	public void theUserLoginFails() {
		 assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}
	//6
	@Then("the user is not logged in")
	public void theUserIsNotLoggedIn() {
		 assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}

	
	
	
	//1
	@Given("the admin {string} is not logged in")
	public void theAdminIsNotLoggedIn(String username) {
		currentUser = username;
	}
//2
	@When("the admin tries to login with password {string}")
	public void theAdminTriesToLoginWithPassword(String password) {
		 boolean loginSuccess = app.getLoginManager().login(currentUser, password);
	        if (loginSuccess) {
	            System.out.println(currentUser + " logged in successfully.");
	        } else {
	            System.out.println(currentUser + " failed to log in.");
	        }
	}
//3
	@Then("the admin login succeeds")
	public void theAdminLoginSucceeds() {
		 assertTrue(app.getLoginManager().login(currentUser, "222222"));
	}
//4
	@Then("the admin is logged in")
	public void theAdminIsLoggedIn() {
		assertTrue(app.getLoginManager().login(currentUser, "222222"));
	}
//5
	@Then("the admin login fails")
	public void theAdminLoginFails() {
		 assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}
//6
	@Then("the admin is not logged in")
	public void theAdminIsNotLoggedIn() {
		 assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}

	//1
	@Given("the owner {string} is not logged in")
	public void theOwnerIsNotLoggedIn(String username) {
		currentUser = username;
	}
//2
	@When("the owner tries to login with password {string}")
	public void theOwnerTriesToLoginWithPassword(String password) {
			 boolean loginSuccess = app.getLoginManager().login(currentUser, password);
		        if (loginSuccess) {
		            System.out.println(currentUser + " logged in successfully.");
		        } else {
		            System.out.println(currentUser + " failed to log in.");
		        }
	}
//3
	@Then("the owner login succeeds")
	public void theOwnerLoginSucceeds() {
		assertTrue(app.getLoginManager().login(currentUser, "333333"));
	}
//4
	@Then("the owner is logged in")
	public void theOwnerIsLoggedIn() {
		assertTrue(app.getLoginManager().login(currentUser, "333333"));
	}
//5
	@Then("the owner login fails")
	public void theOwnerLoginFails() {
		assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}
//6
	@Then("the owner is not logged in")
	public void theOwnerIsNotLoggedIn() {
		 assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}

	
	
	
	
	@Given("the supplier {string} is not logged in")
	public void theSupplierIsNotLoggedIn(String username) {
		currentUser = username;
	}

	@When("the supplier tries to login with password {string}")
	public void theSupplierTriesToLoginWithPassword(String password) {
		boolean loginSuccess = app.getLoginManager().login(currentUser, password);
        if (loginSuccess) {
            System.out.println(currentUser + " logged in successfully.");
        } else {
            System.out.println(currentUser + " failed to log in.");
        }
	}

	@Then("the supplier login succeeds")
	public void theSupplierLoginSucceeds() {
		assertTrue(app.getLoginManager().login(currentUser, "444444"));
	}

	@Then("the supplier is logged in")
	public void theSupplierIsLoggedIn() {
		assertTrue(app.getLoginManager().login(currentUser, "444444"));
	}

	@Then("the supplier login fails")
	public void theSupplierLoginFails() {
		assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}

	@Then("the supplier is not logged in")
	public void theSupplierIsNotLoggedIn() {
		assertFalse(app.getLoginManager().login(currentUser, "wrongpassword"));
	}
	



}
