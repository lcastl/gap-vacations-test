#Create users
#Author: Luis Castellanos

Feature: Create new users
  As a logged in user I want to be able to create new users

  @smoke
  Scenario Outline: Login into the GAP vacations management
    Given I am at the GAP vacations management site
    And I login with a valid <userName> and <password>

    When I click on "Create a new employee" link
    Then I verify that the new employee page is displayed

    When I enter the employee information
    And I click on "Create Employee" button
    Then I verify that the message "Employee was successfully created." is displayed

    Examples:
      |userName	                         |password|firstName|lastName|email					  |identification|leaderName        |dateIn	   |
      |gap-automation-test@mailinator.com|12345678|James    |Smith   |employee@mailinator.com|1234567890	 |Adrian Castellanos|21-01-2014|

