Feature: Communication and Feedback

Scenario: Communicate with Store Owners
    Given the user is signed in
    When the user sends a message to a store owner for inquiries or assistance
    Then the message should be sent successfully
    And a confirmation message should be displayed

Scenario: Communicate with Suppliers
    Given the user is signed in
    When the user sends a message to a supplier for inquiries or assistance
    Then the message should be sent successfully
    And a confirmation message should be displayed

Scenario: Provide Feedback on Purchased Products
    Given the user is signed in and has purchased a product
    When the user submits feedback for the purchased product
    Then the feedback should be submitted successfully
    And a confirmation message should be displayed

Scenario: Provide Feedback on Shared Recipes
    Given the user is signed in and has viewed a shared recipe
    When the user submits feedback on the recipe
    Then the feedback should be submitted successfully
    And a confirmation message should be displayed

Scenario: View Feedback History
    Given the user is signed in
    When the user views their feedback history
    Then all submitted feedback should be displayed
    And each entry should show the feedback content and associated product or recipe