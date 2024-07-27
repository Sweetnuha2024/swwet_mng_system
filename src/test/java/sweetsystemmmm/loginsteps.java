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
	
	
	

	@Given("user is not in the sweet system")
	public void userIsNotInTheSweetSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("user has a valid username and password")
	public void userHasAValidUsernameAndPassword() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("user enters  username {string} and password {string}")
	public void userEntersUsernameAndPassword(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("user is now in the system")
	public void userIsNowInTheSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("welcome msg will be appeared")
	public void welcomeMsgWillBeAppeared() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}






	


	
	
	
	
	
	
}
