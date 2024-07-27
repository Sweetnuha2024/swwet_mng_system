Feature: User Management

  Description:
    Admins will have full control over user accounts, including store owners and raw material suppliers. This feature will enable admins to perform CRUD (Create, Read, Update, Delete) operations on user accounts.

  Background:
    Given the admin is logged into the Sweet Management System

  Scenario: Create User
    Given the admin wants to create a new user account
    When the admin provides valid details for a new store owner or supplier
    Then the new user account is created successfully
    And the user receives a notification about their new account

  Scenario: Read User
    Given the admin wants to view an existing user account
    When the admin searches for the user by username or other filters
    Then the system displays the user's account details

  Scenario: Update User
    Given the admin wants to update an existing user account
    When the admin modifies the user's information
    Then the user's account is updated successfully
    And the user is notified about the updates to their account

  Scenario: Delete User
    Given the admin wants to delete an existing user account
    When the admin confirms the deletion of the user account
    Then the user's account is deleted successfully
    And the user's account is archived for a certain period before permanent deletion

