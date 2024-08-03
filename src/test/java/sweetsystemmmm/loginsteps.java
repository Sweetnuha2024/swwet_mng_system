package sweetsystemmmm;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
//import Mysweetsystem2024.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class loginsteps {

	MyApplication app;
	public loginsteps(MyApplication ob) {
		super();
		this.app=ob;
		
	}
	
	
	

@Given("user is not in the sweet system")
public void userIsNotInTheSweetSystem() {
	app.is_logged_in = false;
    assertFalse(app.is_logged_in);
}

@When("user enters  username {string} and password {string}")
public void userEntersUsernameAndPassword(String un, String pass) {
  //User user =new User (un,pass, pass);
 // boolean validUser = false;
 // for (User u:app.getList_user()) {
  
 // if (user.equals(u));{
	//  validUser = true;
	 // break;
 // }
  
  //}
 // app.is_logged_in = validUser;
}
 
@Then("user is now in the system")
public void userIsNowInTheSystem() {
    assertTrue(app.is_logged_in);
}
@Then("welcome msg will be appeared")
public void welcomeMsgWillBeAppeared() {
	 if (app.is_logged_in) {
         System.out.println("Welcome to the Sweet Management System!");
     }
}
@Then("user is now out of the system")
public void userIsNowOutOfTheSystem() {
	 assertFalse(app.is_logged_in);
}

@Then("failed login msg will be appeared")
public void failedLoginMsgWillBeAppeared() {
	if (!app.is_logged_in) {
        System.out.println("Login failed. Please check your username and password.");
    }
}


}
