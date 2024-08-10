package Mysweetsystem2024;

import java.util.HashMap;
import java.util.Map;

public class NotificationServices {
    private Map<String, String> notifications = new HashMap<>();

    // Method to send a notification
    public void sendNotification(String username, String message) {
        notifications.put(username, message);
        // In a real application, you might send an email or push notification here
        System.out.println("Notification sent to " + username + ": " + message);
    }

    // Method to check if a notification exists for a user
    public boolean hasNotificationForUser(String username) {
        return notifications.containsKey(username);
    }
    public String getNotificationForUser(String username) {
        return notifications.get(username);
    }
}
