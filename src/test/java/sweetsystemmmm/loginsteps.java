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
	
	
	
	
	
	@Given("I am not in system")
	public void iAmNotInSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("set username {string} and pass {string}")
	public void setUsernameAndPass(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("login succeed")
	public void loginSucceed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	


	
	
	
	
	
	
}
