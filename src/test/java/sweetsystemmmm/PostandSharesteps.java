package sweetsystemmmm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Mysweetsystem2024.MyApplication;
import Mysweetsystem2024.Post;  // Import the Post class
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostandSharesteps {

    MyApplication app;
    private String username;
    private Post post;  // Instance of Post class
    private boolean postSuccess;
    private String errorMessage;
    
    @Given("the user {string} is logged in")
    public void theUserIsLoggedIn(String username) {
        this.username = username;
    }

    @When("the user posts content with description {string} and image {string}")
    public void theUserPostsContentWithDescriptionAndImage(String description, String image) {
        if (description.isEmpty()) {
            postSuccess = false;
            errorMessage = "Description cannot be empty";
        } else if (image.isEmpty()) {
            postSuccess = false;
            errorMessage = "Image cannot be empty";
        } else {
            post = new Post(username, image, description);  // Create a new Post object
            postSuccess = true;
            errorMessage = null;
        }
    }

    @Then("the post should be successfully created")
    public void thePostShouldBeSuccessfullyCreated() {
        assertTrue("Post should be created successfully", postSuccess);
        assertTrue("Post object should not be null", post != null);
    }

    @Then("the post description should be {string}")
    public void thePostDescriptionShouldBe(String expectedDescription) {
        assertEquals("Post description should match", expectedDescription, post.getDescription());
    }

    @Then("the post image should be {string}")
    public void thePostImageShouldBe(String expectedImage) {
        assertEquals("Post image should match", expectedImage, post.getImage());
    }

    @Then("the post should fail with an error message {string}")
    public void thePostShouldFailWithAnErrorMessage(String expectedErrorMessage) {
        assertFalse("Post should not be created", postSuccess);
        assertEquals("Error message should match", expectedErrorMessage, errorMessage);
        assertTrue("Post object should be null", post == null);  // Ensure post is not created
    }
}



    

   

   

    

  

    

  
