package Mysweetsystem2024;

import java.util.HashMap;
import java.util.Map;

public class NotificationServices {

	
	
	private Map<String, String> notifications = new HashMap<>();

    public void sendNotification(String username, String message) {
        notifications.put(username, message);
    }

    public boolean hasNotificationForUser(String username) {
        return notifications.containsKey(username);
    }

	public String getNotificationContentForUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
