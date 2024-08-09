Feature: Manage Personal Accounts

  Scenario: Add Personal Information
    Given the user is signed in to the Sweet System
    When the user adds their personal information with email "shahdrawajbeh@gmail.com" and phone "0566195195"
    Then the information should be saved successfully
    And a confirmation message should be displayed

  Scenario: Update Personal Information
    Given the user is signed in to the Sweet System
    When the user updates their personal information with email "shahdshahd@gmail.com" and phone "0598716602"
    Then the changes should be saved successfully
    And a confirmation message should be displayed

  Scenario: Delete Personal Information
    Given the user is signed in to the Sweet System
    When the user deletes their personal information
    Then the information should be removed successfully
    And a confirmation message should be displayed