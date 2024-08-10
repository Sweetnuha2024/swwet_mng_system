Feature: User Management

Background:
    Given the admin is logged into the Sweet Management System

Scenario: Create User
    Given the admin wants to create a new user
    When the admin enters valid details
    Then the user account is created

Scenario: View User
    Given the admin wants to view a user
    When the admin searches for the user by username
    Then the system displays the user details

Scenario: Update User
    Given the admin wants to update a user
    When the admin modifies the user’s information
    Then the user account is updated

Scenario: Delete User
    Given the admin wants to delete a user
    When the admin confirms the deletion
    Then the user account is deleted
    And the user account is archived
