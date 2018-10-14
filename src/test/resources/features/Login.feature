#Login
#Author: Luis Castellanos

Feature: Login into the GAP vacations management
  As a user I want to be able to log in on the application,
  so that I can navigate for the different features

  @smoke
  Scenario Outline: Login into the GAP vacations management
    Given I am at the GAP vacations management site

    When I login with a valid <userName> and <password>
    Then I verify that the user navigated to the home page
    And I verify that the site logo is displayed
    And I verify that the Signed in successfully banner is displayed

    Examples:
      |userName	                         |password|
      |gap-automation-test@mailinator.com|12345678|