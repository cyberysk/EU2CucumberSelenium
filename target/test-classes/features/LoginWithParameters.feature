Feature: Login as different user

  Scenario: Login as a driver
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    Then the user should be able to login
    And the title contains "Dashboard"

  Scenario: Login as a driver
    Given the user logged in as "store manager"
    Then the user should be able to login
    And the title contains "Dashboard"
    #driver, sales manager, store manager