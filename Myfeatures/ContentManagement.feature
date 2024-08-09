Feature: Content Management


Background:
    Given the admin is logged into the Sweet Management System

Scenario: Manage Recipes
    Given the admin wants to manage recipes shared by users
    When the admin reviews a new recipe submitted by a user
    Then the admin can approve the recipe for publication
    And the admin can edit the recipe details if needed
    And the admin can delete the recipe if it does not meet the platform's standards

Scenario: Manage Posts
    Given the admin wants to manage posts made by users
    When the admin reviews a new post submitted by a user
    Then the admin can approve the post for publication
    And the admin can edit the post content if necessary
    And the admin can delete the post if it does not adhere to platform guidelines

Scenario: Manage User Feedback
    Given the admin wants to manage user feedback and reviews
    When the admin reviews feedback submitted by users
    Then the admin can approve, edit, or delete feedback to ensure it is appropriate and helpful
    And the admin can respond to feedback if needed
