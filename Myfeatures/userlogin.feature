Feature: Login Sweet Management System


  Scenario: user login
    Given that the user "nuha" is not logged in
    When user tries to login
    And  password is "111111"
    Then the user login succeeds
    And the user is logged in

  Scenario: user cannot login
    Given that the user "nuha" is not logged in
    When user tries to login
    And  password is "wrongpassword"
    Then the user login fails
    And the user is not logged in

  Scenario: admin can login
    Given that the admin "shahd" is not logged in
    When admin tries to login
    And  password is "222222"
    Then the admin login succeeds
    And the admin is logged in

  Scenario: admin cannot login
    Given that the admin "shahd" is not logged in
    When admin tries to login
    And  password is "wrongpassword"
    Then the admin login fails
    And the admin is not logged in

  Scenario: owner can login
    Given that the owner "hala" is not logged in
    When owner tries to login
    And  password is "333333"
    Then the owner login succeeds
    And the owner is logged in

  Scenario: owner cannot login
    Given that the owner "hala" is not logged in
    When owner tries to login
    And  password is "wrongpassword"
    Then the owner login fails
    And the owner is not logged in

  Scenario: supplier can login
    Given that the supplier "safa" is not logged in
    When supplier tries to login
    And  password is "444444"
    Then the supplier login succeeds
    And the supplier is logged in

  Scenario: supplier cannot login
    Given that the supplier "safa" is not logged in
    When supplier tries to login
    And  password is "wrongpassword"
    Then the supplier login fails
    And the supplier is not logged in