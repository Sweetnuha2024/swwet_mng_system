Feature: User login sweet system
Actor: regular user
 
Scenario: valid login
Given user is not in the sweet system
When user enters  username "shahd" and password "822003"
Then user is now in the system
And welcome msg will be appeared

Scenario: invalid password
Given user is not in the sweet system
When user enters  username "shahd" and password "822004"
Then user is now out of the system
And failed login msg will be appeared

Scenario: invalid user name 
Given user is not in the sweet system
When user enters  username "shahed" and password "822003"
Then user is now out of the system
And failed login msg will be appeared

