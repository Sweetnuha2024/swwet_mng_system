Feature: Monitoring and Reporting

  Scenario: Monitor profits and generate financial reports
    Given I am logged in as an Admin
    When I navigate to the Financial Reports section
    And I request a financial report for the current period
    Then I should see the total profits for the period
    And I should see a detailed financial report

  Scenario: Identify best-selling products in each store
    Given I am logged in as an Admin
    When I navigate to the Store Reports section
    And I request the best-selling products report for all stores
    Then I should see a list of best-selling products for each store
    And the list should include the product names and sales figures

  Scenario: Gather and display statistics on registered users by city
    Given I am logged in as an Admin
    When I navigate to the User Statistics section
    And I request user statistics by city
    Then I should see a list of cities with the number of registered users in each city
    And the list should include cities such as Nablus and Jenin
