Feature: Account Management

Scenario: Manage Account Details
Given the store owner or supplier is signed in
When they update their account details with new email "newemail@example.com" and phone "1234567890"
Then the account details should be updated successfully
And a confirmation message should be displayed