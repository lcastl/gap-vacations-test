#Login
#Author: Luis Castellanos

  @smoke
Feature: Login and create employees
  As a user I want to be able to log in on the application,
  so that I can create and validate employees


  Scenario Outline: Login into the GAP vacations management
    Given I am at the GAP vacations management site
    When I login with a valid <userName> and <password>
    Then I verify that the user navigated to the home page
    And I verify that the site logo is displayed
    And I verify that the Signed in successfully banner is displayed

    Examples:
      |userName	                         |password|
      |gap-automation-test@mailinator.com|12345678|


  Scenario Outline: Crate a new employee and verify successful message
    Given I am at the home page
    When I click on Create a new employee link
    Then I verify that the new employee page is displayed
    When I enter the employee information
      |firstName|lastName|email					  |identification|leaderName        |dateIn	   |
      |James    |Smith   |employee@mailinator.com|1234567890	 |Adrian Castellanos|21-01-2014|
    And I click on Create Employee button
    Then I verify that the message <employeeCreationMessage>  is displayed

    Examples:
      |employeeCreationMessage           |
      |Employee was successfully created.|


  Scenario Outline: Verify that the employee was correctly created
    Given I am at the home page
    When I search for a given user <leaderName> in the list
    Then I verify that the found user information is the same than the given user
      |firstName|lastName|identification|leaderName        |dateIn	   |
      |James    |Smith   |1234567890	 |Adrian Castellanos|01/21/2014|

    Examples:
      |leaderName        |
      |Adrian Castellanos|