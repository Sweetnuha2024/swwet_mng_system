Feature: Monitoring and Reporting

Description:
    Admins will be able to generate and view various reports to monitor the system's performance, financial health, and user activities.

  Background:
    Given the admin is logged into the Sweet Management System

  Scenario: Generate Financial Reports
    Given the admin wants to generate a financial report
    When the admin selects a date range and generates the report
    Then the system displays the overall profits, revenue trends, and financial health for the selected period

  Scenario: Identify Best-Selling Products
    Given the admin wants to identify best-selling products
    When the admin selects a store and time period
    Then the system displays a list of best-selling products in that store for the selected period
    And the list includes sales quantities and revenue

  Scenario: Display User Statistics by City
    Given the admin wants to view user statistics by city
    When the admin selects a city or multiple cities
    Then the system displays statistics on registered users in the selected city or cities
    And the statistics include total users, active users, and user growth trends
