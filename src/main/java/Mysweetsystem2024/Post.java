package Mysweetsystem2024;

public class Post {

	
	 private String description;
	    private String image;
	    private String status; 

	    
	    public Post(String description, String image, String status) {
	        this.description = description;
	        this.image = image;
	        this.status = status;
	    }

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
