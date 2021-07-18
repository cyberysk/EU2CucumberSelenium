@login @smoke
Feature: Users should be able to login

  Background:
    Given the user is on the login page
    #it there is a common step for all scenario we can use Background
  @driver  @VYT_123
  Scenario: Login as a driver
    When the user enter the driver information
    Then the user should be able to login

  @sales_manager @VYT_123
  Scenario: Login as a sales manager
    When the user enter sales manager information
    Then  the user should be able to login

  @store_manager
  Scenario: Login as a store manager
    When the user enter store manager information
    Then the user should be able to login


#comment