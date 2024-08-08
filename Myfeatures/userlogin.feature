Feature: Login Sweet Management System

Scenario: User can login
    Given the user "nuha" is not logged in
    When the user tries to login with password "111111"
    Then the user login succeeds
    And the user is logged in

Scenario: User cannot login
    Given the user "nuha" is not logged in
    When the user tries to login with password "wrongpassword"
    Then the user login fails
    And the user is not logged in

Scenario: Admin can login
    Given the admin "shahd" is not logged in
    When the admin tries to login with password "222222"
    Then the admin login succeeds
    And the admin is logged in

Scenario: Admin cannot login
    Given the admin "shahd" is not logged in
    When the admin tries to login with password "wrongpassword"
    Then the admin login fails
    And the admin is not logged in

Scenario: Owner can login
    Given the owner "hala" is not logged in
    When the owner tries to login with password "333333"
    Then the owner login succeeds
    And the owner is logged in

Scenario: Owner cannot login
    Given the owner "hala" is not logged in
    When the owner tries to login with password "wrongpassword"
    Then the owner login fails
    And the owner is not logged in

Scenario: Supplier can login
    Given the supplier "safaa" is not logged in
    When the supplier tries to login with password "444444"
    Then the supplier login succeeds
    And the supplier is logged in

Scenario: Supplier cannot login
    Given the supplier "safaa" is not logged in
    When the supplier tries to login with password "wrongpassword"
    Then the supplier login fails
    And the supplier is not logged in
