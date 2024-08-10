package Mysweetsystem2024;

public class Post {

	
	 private String description;
	    private String image;
	    private String status; // Example statuses: "success", "failed", etc.

	    // Constructor
	    public Post(String description, String image, String status) {
	        this.description = description;
	        this.image = image;
	        this.status = status;
	    }

	    // Getter for description
	    public String getDescription() {
	        return description;
	    }

	    // Setter for description
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    // Getter for image
	    public String getImage() {
	        return image;
	    }

	    // Setter for image
	    public void setImage(String image) {
	        this.image = image;
	    }

	    // Getter for status
	    public String getStatus() {
	        return status;
	    }

	    // Setter for status
	    public void setStatus(String status) {
	        this.status = status;
	    }

	    // Method to display post details
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
	
	
	
	
	
	
	
	
	
}
