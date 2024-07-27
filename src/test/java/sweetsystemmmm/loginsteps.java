package sweetsystemmmm;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweetsystem.MyApplication;

public class loginsteps {

	MyApplication app;
	public loginsteps(MyApplication ob) {
		app=ob;
		
	}
	
	
	

	@Given("user has a valid username and  invalid password")
	public void userHasAValidUsernameAndInvalidPassword() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user is now out of the system")
	public void userIsNowOutOfTheSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("failed login msg will be appeared")
	public void failedLoginMsgWillBeAppeared() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("user has a invalid username and  valid password")
	public void userHasAInvalidUsernameAndValidPassword() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user is not currently signed up for the Sweet System")
	public void theUserIsNotCurrentlySignedUpForTheSweetSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user provides a unique username and a valid password")
	public void theUserProvidesAUniqueUsernameAndAValidPassword() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user enters username {string} and password {string}")
	public void theUserEntersUsernameAndPassword(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be successfully signed up to the system")
	public void theUserShouldBeSuccessfullySignedUpToTheSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a success message should be displayed")
	public void aSuccessMessageShouldBeDisplayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user provides a username that already exists and a valid password")
	public void theUserProvidesAUsernameThatAlreadyExistsAndAValidPassword() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should not be signed up to the system")
	public void theUserShouldNotBeSignedUpToTheSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("an error message should be displayed indicating the username already exists")
	public void anErrorMessageShouldBeDisplayedIndicatingTheUsernameAlreadyExists() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user provides a valid username but an invalid password format")
	public void theUserProvidesAValidUsernameButAnInvalidPasswordFormat() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("an error message should be displayed indicating the password is invalid")
	public void anErrorMessageShouldBeDisplayedIndicatingThePasswordIsInvalid() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user provides an invalid username format and a valid password")
	public void theUserProvidesAnInvalidUsernameFormatAndAValidPassword() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("an error message should be displayed indicating the username is invalid")
	public void anErrorMessageShouldBeDisplayedIndicatingTheUsernameIsInvalid() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	
	
}
