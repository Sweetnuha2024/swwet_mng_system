/*package Mysweetsystem2024;

public class Post {

	
	 private String description;
	    private String image;
	    private String status; 
	    private String username;
	    
	   // public Post(String description, String image, String status) {
	     //   this.description = description;
	       // this.image = image;
	        //this.status = status;
	    //}
	    public Post(String username, String imagePath, String text) {
	        this.username = username;
	        this.image = imagePath;
	        this.description = text;
	    }
	    public Post(String imagePath, String text) {
	        this.image = imagePath;
	        this.description = text;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public String getUsername() {
	        return username;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }

	  
	    public String getImage() {
	        return image;
	    }

	   
	    public void setImage(String image) {
	        this.image = image;
	    }

	   
	    public String getStatus() {
	        return status;
	    }

	    
	    public void setStatus(String status) {
	        this.status = status;
	    }

	    
	    public String displayPostDetails() {
	        return "Description: " + description + ", Image: " + image + ", Status: " + status;
	    }

	    @Override
	    public String toString() {
	        return "Post{" +
	                "description='" + description + '\'' +
	                ", image='" + image + '\'' +
	                ", status='" + status + '\'' +
	                '}';
	    }
	
	
	
	
	
	
	
	
	
}*/
package Mysweetsystem2024;

public class Post {
    private String description;
    private String image;
    private String status;
    private String username;

    // Constructor with username
    public Post(String username, String imagePath, String text) {
        this.username = username;
        this.image = imagePath;
        this.description = text;
        this.status = "active"; // Default status if needed
    }

    // Constructor without username
    public Post(String imagePath, String text) {
        this(null, imagePath, text); // Delegate to the other constructor with default username
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    // Display post details
    public String displayPostDetails() {
        return "Description: " + description + ", Image: " + image + ", Status: " + status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

