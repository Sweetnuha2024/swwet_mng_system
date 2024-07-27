package sweetsystemmmm;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweetsystem.MyApplication;
import sweetsystem.User;

public class loginsteps {

	MyApplication app;
	public loginsteps(MyApplication ob) {
		super();
		this.app=ob;
		
	}
	
	
	

@Given("user is not in the sweet system")
public void userIsNotInTheSweetSystem() {
    assertFalse(app.is_logged_in);
}

@When("user enters  username {string} and password {string}")
public void userEntersUsernameAndPassword(String un, String pass) {
  User user =new User (un,pass);
  
  for (User u:app.getList_user()) {
  
  if (user.equals(u));{
	  app.is_logged_in=true;
	  break;
  }
  }
  
}
 
@Then("user is now in the system")
public void userIsNowInTheSystem() {
    assertTrue(app.is_logged_in);
}
@Then("welcome msg will be appeared")
public void welcomeMsgWillBeAppeared() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("user is now out of the system")
public void userIsNowOutOfTheSystem() {
    assertFalse(app.is_logged_in);
}

@Then("failed login msg will be appeared")
public void failedLoginMsgWillBeAppeared() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}


}
