package sweetsystemmmm;

import Mysweetsystem2024.MyApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostandSharesteps {
	
	
	MyApplication app;
	public PostandSharesteps(MyApplication ob) {
		super();
		this.app=ob;
		
	}
	
	
	@Given("the user is logged into the Sweet System")
	public void theUserIsLoggedIntoTheSweetSystem() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the user is a beneficiary")
	public void theUserIsABeneficiary() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user provides a title {string} and a description {string}")
	public void theUserProvidesATitleAndADescription(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user provides an image {string}")
	public void theUserProvidesAnImage(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user submits the dessert creation")
	public void theUserSubmitsTheDessertCreation() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the dessert creation should be posted successfully")
	public void theDessertCreationShouldBePostedSuccessfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user provides a description {string}")
	public void theUserProvidesADescription(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the dessert creation should not be posted")
	public void theDessertCreationShouldNotBePosted() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("an error message should be displayed indicating the title is required")
	public void anErrorMessageShouldBeDisplayedIndicatingTheTitleIsRequired() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user provides a title {string}")
	public void theUserProvidesATitle(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("an error message should be displayed indicating the description is required")
	public void anErrorMessageShouldBeDisplayedIndicatingTheDescriptionIsRequired() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("an error message should be displayed indicating the image is required")
	public void anErrorMessageShouldBeDisplayedIndicatingTheImageIsRequired() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	

}
