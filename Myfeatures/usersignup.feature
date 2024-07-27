Feature: User Sign Up
Actor: Regular User

Scenario: Successful Sign Up
Given the user is not currently signed up for the Sweet System
And the user provides a unique username and a valid password
When the user enters username "nuha" and password "securePass123"
Then the user should be successfully signed up to the system
And a success message should be displayed

Scenario: Username Already Exists
Given the user is not currently signed up for the Sweet System
And the user provides a username that already exists and a valid password
When the user enters username "nuha" and password "newPass456"
Then the user should not be signed up to the system
And an error message should be displayed indicating the username already exists

Scenario: Invalid Password
Given the user is not currently signed up for the Sweet System
And the user provides a valid username but an invalid password format
When the user enters username "new_user" and password "short"
Then the user should not be signed up to the system
And an error message should be displayed indicating the password is invalid

Scenario: Invalid Username
Given the user is not currently signed up for the Sweet System
And the user provides an invalid username format and a valid password
When the user enters username "invalid username!" and password "validPass123"
Then the user should not be signed up to the system
And an error message should be displayed indicating the username is invalid


   