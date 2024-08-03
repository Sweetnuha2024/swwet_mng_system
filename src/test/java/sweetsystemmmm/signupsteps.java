package sweetsystemmmm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import Mysweetsystem2024.MyApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class signupsteps {

	 MyApplication app;
	  
	    String signupMessage;
	
	    public signupsteps(MyApplication ob) {
	    	super();
			this.app=ob;
			
	    }
	
	
	

@Given("the user is not currently signed up for the Sweet System")
public void theUserIsNotCurrentlySignedUpForTheSweetSystem() {
    
}

@Given("the user provides a unique username and a valid password")
public void theUserProvidesAUniqueUsernameAndAValidPassword() {
   
}

@When("the user enters username {string} and password {string}")
public void theUserEntersUsernameAndPassword(String username, String password) {
	//signupMessage = authService.register(username, password);
}

@Then("the user should be successfully signed up to the system")
public void theUserShouldBeSuccessfullySignedUpToTheSystem() {
	 assertTrue(signupMessage.equals("User successfully registered."));
}

@Then("a success message should be displayed")
public void aSuccessMessageShouldBeDisplayed() {
	  System.out.println(signupMessage);
}

@Given("the user provides a username that already exists and a valid password")
public void theUserProvidesAUsernameThatAlreadyExistsAndAValidPassword() {
	// authService.register("nuha", "securePass123");
}

@Then("the user should not be signed up to the system")
public void theUserShouldNotBeSignedUpToTheSystem() {
	  assertFalse(signupMessage.equals("User successfully registered."));
}

@Then("an error message should be displayed indicating the username already exists")
public void anErrorMessageShouldBeDisplayedIndicatingTheUsernameAlreadyExists() {
	 assertTrue(signupMessage.equals("Username already exists."));
}

@Given("the user provides a valid username but an invalid password format")
public void theUserProvidesAValidUsernameButAnInvalidPasswordFormat() {
    
}

@Then("an error message should be displayed indicating the password is invalid")
public void anErrorMessageShouldBeDisplayedIndicatingThePasswordIsInvalid() {
	 assertTrue(signupMessage.equals("Invalid password format."));
}

@Given("the user provides an invalid username format and a valid password")
public void theUserProvidesAnInvalidUsernameFormatAndAValidPassword() {
    
}

@Then("an error message should be displayed indicating the username is invalid")
public void anErrorMessageShouldBeDisplayedIndicatingTheUsernameIsInvalid() {
	 assertTrue(signupMessage.equals("Invalid username format."));
}

	
	
	
	
	
	
	
	
	
	
	
}
