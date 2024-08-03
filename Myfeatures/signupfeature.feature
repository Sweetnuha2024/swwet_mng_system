Feature: Sign up
Actor: An outsider to the system

Scenario: The sign up is successful
Given that the user "nonexistent" is  not logged in
And they do not have an account in the system
Then the sign up succeeds
And the user is redirected to the login page

Scenario: The sign up is unsuccessful
Given that the user "shahd" is  not logged in
And they does have an account in the system
Then the sign up fails
And the user is prompted to try again