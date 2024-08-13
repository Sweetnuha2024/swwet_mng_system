package Mysweetsystem2024;

import java.time.LocalDateTime;

public class Order {

	private String orderId;
    private String status; 
    private String details; 
    private LocalDateTime creationTime;
    // Constructor
    public Order(String orderId, String status, String details) {
        this.orderId = orderId;
        this.status = status;
        this.details = details;
    }
    public Order(String orderId, String status, LocalDateTime creationTime) {
        this.orderId = orderId;
        this.status = status;
        this.creationTime = creationTime;
    }
    
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
	
    public boolean isNew() {
        
        boolean isNewStatus = "new".equalsIgnoreCase(status);
        boolean isCreatedRecently = creationTime.isAfter(LocalDateTime.now().minusHours(24)); 
        return isNewStatus || isCreatedRecently;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
