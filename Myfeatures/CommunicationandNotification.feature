Feature: Communication and Notification

Scenario: Communicate with Users and Other Suppliers
Given the store owner or supplier is signed in
When they send a message to a user or another supplier
Then the message should be sent successfully
And a confirmation message should be displayed
