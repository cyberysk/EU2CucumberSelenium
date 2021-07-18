
Feature: Navigation Menu


  Scenario: Navigation Fleet -- Vehicle
    Given the user is on the login page
    And the user enter sales manager information
    When the user navigates to Fleet, Vehicles
    Then the title should be Vehicles
@db
  Scenario: Navigating Marketing -- Campaigns
    Given the user is on the login page
    And the user enter sales manager information
    When the user navigates Marketing, Campaigns
    Then the title should be be Campaigns

  Scenario: Navigating Activities -- Calendar Events
    Given the user is on the login page
    And the user enter sales manager information
    When the user navigates Activities, Calendar Events
    Then the title should be be Calendar Events

